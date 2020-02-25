package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.AnswerBoardDTO;

public class AnswerBoardDAO {
	private JdbcTemplate jdbcTemplate;
	final String COLUMNS = "board_num, user_id, board_name, board_pass, board_subject, board_content, ip_addr, read_count, board_date, original_file_name, store_file_name, file_size, board_re_ref, board_re_lev, board_re_seq";
	private RowMapper<AnswerBoardDTO> boardRowMapper = new RowMapper<AnswerBoardDTO>() { 	// RowMapper 생성자를 오버라이딩...
		public AnswerBoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {		// 얘가 rs.next() 해주는 애나 마찬가지고.. 한줄 한줄..
			AnswerBoardDTO board = new AnswerBoardDTO();
			board.setBoardNum(rs.getInt("board_num"));
			board.setUserId(rs.getString("user_id"));
			board.setBoardName(rs.getString("board_name"));
			board.setBoardPass(rs.getString("board_pass"));
			board.setBoardSubject(rs.getString("board_subject"));
			board.setBoardContent(rs.getString("board_content"));
			board.setIpAddr(rs.getString("ip_addr"));
			board.setReadCount(rs.getInt("read_count"));
			board.setBoardDate(rs.getTimestamp("board_date"));
			board.setOriginalFileName(rs.getString("original_file_name"));
			board.setStoreFileName(rs.getString("store_file_name"));
			board.setFileSize(rs.getString("file_size"));
			//
			//
			//			
			return board;
		}
	};
	@Autowired
	public AnswerBoardDAO(DataSource dataSource) {	// 생성자.. spring-jdbc.xml에서 dataSource를 갖고와서 자동주입...
		this.jdbcTemplate = new JdbcTemplate(dataSource);	// getConnection() 등등 대신에 이거 쓰는 거..
	}
	
	public Integer insertBoard(AnswerBoardDTO board) {
		Integer i = 0;
		String sql = "insert into answerboard (" + COLUMNS + ") values(num_seq.nextval,?,?,?,?,?,?,0,sysdate,?,?,?,num_seq.currval,0,0)";
		i = jdbcTemplate.update(sql, board.getUserId(), board.getBoardName(), board.getBoardPass(), board.getBoardSubject(), board.getBoardContent(), board.getIpAddr(), board.getOriginalFileName(), board.getStoreFileName(), board.getFileSize());
		return i;
	}

	public List<AnswerBoardDTO> selectList(int nowPage, int limit) {
		int startRow = (nowPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		String sql = "select * from (select rownum rn, " + COLUMNS + " from (select " + COLUMNS + " from answerboard order by board_num desc)) where rn between ? and ?";
		List<AnswerBoardDTO> results = jdbcTemplate.query(sql, boardRowMapper, startRow, endRow);
		return results;
	}
	
	public int count() {
		String sql = "select count(*) from answerboard";
		return jdbcTemplate.queryForObject(sql, Integer.class);		// 요런 식으로 바로 리턴하는 게 더 나은 코드라고-
	}

	public AnswerBoardDTO selectByBoardNum(AnswerBoardDTO board, String tableName) {
		String sql = "select " + COLUMNS + " from " + tableName + " where board_num=?";
		List<AnswerBoardDTO> results = jdbcTemplate.query(sql, boardRowMapper, board.getBoardNum());
		return results.isEmpty() ? null : results.get(0);
	}

	public Integer updateBoard(AnswerBoardDTO board) {
		String sql = "update answerboard set board_subject=?, board_content=? where board_num=? and board_pass=?";
		return jdbcTemplate.update(sql, board.getBoardSubject(), board.getBoardContent(), board.getBoardNum(), board.getBoardPass());
	}

	public Integer deleteBoard(AnswerBoardDTO board) {
		String sql = "delete from answerboard where board_num=? and board_pass=?";
		return jdbcTemplate.update(sql, board.getBoardNum(), board.getBoardPass());		// 삽입/수정/삭제는 .update..
	}

	public void boardReadCountUpdate(Integer boardNum) {
		String sql = "update answerboard set read_count=read_count+1 where board_num=?";
		jdbcTemplate.update(sql, boardNum);		// 삽입/수정/삭제는 .update..
	}
}
