package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.LibraryBoardDTO;

public class LibraryBoardDAO {
	private JdbcTemplate jdbcTemplate;
	final String COLUMNS = "board_num, user_id, board_name, board_pass, board_subject, board_content, ip_addr, board_date, read_count";
	private RowMapper<LibraryBoardDTO> boardRowMapper = new RowMapper<LibraryBoardDTO>() { 	// RowMapper 생성자를 오버라이딩...
		public LibraryBoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {		// 얘가 rs.next() 해주는 애나 마찬가지고.. 한줄 한줄..
			LibraryBoardDTO board = new LibraryBoardDTO();
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
	public LibraryBoardDAO(DataSource dataSource) {	// 생성자.. spring-jdbc.xml에서 dataSource를 갖고와서 자동주입...
		this.jdbcTemplate = new JdbcTemplate(dataSource);	// getConnection() 등등 대신에 이거 쓰는 거..
	}
	
	public Integer insertBoard(LibraryBoardDTO board) {
		Integer i = 0;
		String sql = "insert into libraryboard (" + COLUMNS + ") values(num_seq.nextval,?,?,?,?,?,?,sysdate,0)";
		i = jdbcTemplate.update(sql, board.getUserId(), board.getBoardName(), board.getBoardPass(), board.getBoardSubject(), board.getBoardContent(), board.getIpAddr());
		return i;
	}

	public List<LibraryBoardDTO> selectList() {
		String sql = "select " + COLUMNS + " from libraryboard";
		List<LibraryBoardDTO> results = jdbcTemplate.query(sql, boardRowMapper);
		return results;
	}
	
	public int count() {
		String sql = "select count(*) from libraryboard";
		return jdbcTemplate.queryForObject(sql, Integer.class);		// 요런 식으로 바로 리턴하는 게 더 나은 코드라고-
	}

	public LibraryBoardDTO selectByBoardNum(LibraryBoardDTO board) {
		String sql = "select " + COLUMNS + " from libraryboard where board_num=?";
		List<LibraryBoardDTO> results = jdbcTemplate.query(sql, boardRowMapper, board.getBoardNum());
		return results.isEmpty() ? null : results.get(0);
	}

	public Integer updateBoard(LibraryBoardDTO board) {
		String sql = "update libraryboard set board_subject=?, board_content=? where board_num=? and board_pass=?";
		return jdbcTemplate.update(sql, board.getBoardSubject(), board.getBoardContent(), board.getBoardNum(), board.getBoardPass());
	}

	public Integer deleteBoard(LibraryBoardDTO board) {
		String sql = "delete from libraryboard where board_num=?";
		return jdbcTemplate.update(sql, board.getBoardNum());		// 삽입/수정/삭제는 .update..
	}
}
