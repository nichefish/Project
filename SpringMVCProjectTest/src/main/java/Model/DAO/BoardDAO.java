package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.BoardDTO;

public class BoardDAO {
	private JdbcTemplate jdbcTemplate;
	final String COLUMNS = "board_num, user_id, board_name, board_pass, board_subject, board_content, ip_addr, board_date, read_count";
	private RowMapper<BoardDTO> boardRowMapper = new RowMapper<BoardDTO>() { 	// RowMapper 생성자를 오버라이딩...
		public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {		// 얘가 rs.next() 해주는 애나 마찬가지고.. 한줄 한줄..
			BoardDTO board = new BoardDTO();
			board.setBoardNum(rs.getInt("board_num"));
			board.setUserId(rs.getString("user_id"));
			board.setBoardName(rs.getString("board_name"));
			board.setBoardPass(rs.getString("board_pass"));
			board.setBoardSubject(rs.getString("board_subject"));
			board.setBoardContent(rs.getString("board_content"));
			board.setBoardDate(rs.getTimestamp("board_date"));
			board.setReadCount(rs.getInt("read_count"));
			board.setIpAddr(rs.getString("ip_addr"));
			return board;
		}
	};
	@Autowired
	public BoardDAO(DataSource dataSource) {	// 생성자.. spring-jdbc.xml에서 dataSource를 갖고와서 자동주입...
		this.jdbcTemplate = new JdbcTemplate(dataSource);	// getConnection() 등등 대신에 이거 쓰는 거..
	}
	
	public Integer insertBoard(BoardDTO boardDTO) {
		Integer i = 0;
		String sql = "insert into board (" + COLUMNS + ") values(num_seq.nextval,?,?,?,?,?,?,sysdate,0)";
		i = jdbcTemplate.update(sql, boardDTO.getUserId(), boardDTO.getBoardName(), boardDTO.getBoardPass(), boardDTO.getBoardSubject(), boardDTO.getBoardContent(), boardDTO.getIpAddr());
		return i;
	}

	public List<BoardDTO> selectList() {
		String sql = "select " + COLUMNS + " from board";
		List<BoardDTO> results = jdbcTemplate.query(sql, boardRowMapper);
		return results;
	}
	
	public int count() {
		String sql = "select count(*) from board";
		return jdbcTemplate.queryForObject(sql, Integer.class);		// 요런 식으로 바로 리턴하는 게 더 나은 코드라고-
	}

	public BoardDTO selectByBoardNum(BoardDTO board) {
		String sql = "select " + COLUMNS + " from board where board_num=?";
		System.out.println(sql);
		List<BoardDTO> results = jdbcTemplate.query(sql, boardRowMapper, board.getBoardNum());
		return results.isEmpty() ? null : results.get(0);
	}

	public Integer updateBoard(BoardDTO boardDTO) {
		String sql = "update board set board_subject=?, board_content=? where board_num=? and board_pass=?";
		return jdbcTemplate.update(sql, boardDTO.getBoardSubject(), boardDTO.getBoardContent(), boardDTO.getBoardNum(), boardDTO.getBoardPass());
	}

	public void deleteBoard(String boardNum) {
		// TODO Auto-generated method stub
		
	}
}
