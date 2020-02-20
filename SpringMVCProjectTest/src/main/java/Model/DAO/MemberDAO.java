package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.MemberDTO;

public class MemberDAO {
	// jdbc 템플릿 사용... spring-jdbc.xml에서 dataSource를 갖고오는 거다... 그걸 이용해서 얘를 초기화...
	private JdbcTemplate jdbcTemplate;
	final String COLUMNS = "user_id, user_pw, user_name, user_gender, user_email, user_addr, user_ph1, user_ph2, user_birth, user_regist";
	private RowMapper<MemberDTO> memRowMapper = new RowMapper<MemberDTO>() { 	// RowMapper 생성자를 오버라이딩...
		public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {		// 얘가 rs.next() 해주는 애나 마찬가지고.. 한줄 한줄..
			MemberDTO member = new MemberDTO();
			member.setUserId(rs.getString("user_id"));
			member.setUserName(rs.getString("user_name"));
			member.setUserBirth(rs.getTimestamp("user_birth"));
			member.setUserGender(rs.getString("user_gender"));
			member.setUserEmail(rs.getString("user_email"));
			member.setUserAddr(rs.getString("user_addr"));
			member.setUserPh1(rs.getString("user_ph1"));
			member.setUserPh2(rs.getString("user_ph2"));
			member.setUserRegist(rs.getTimestamp("user_regist"));
			member.setUserPw(rs.getString("user_pw"));
			return member;
		}
	};

	@Autowired
	public MemberDAO(DataSource dataSource) {	// 생성자.. spring-jdbc.xml에서 dataSource를 갖고와서 자동주입...
		this.jdbcTemplate = new JdbcTemplate(dataSource);	// getConnection() 등등 대신에 이거 쓰는 거..
	}
	
	public Integer insertMember(MemberDTO memberDTO) {	// 익명객체에서 파라미터로 쓸라면 final을 붙여줘야 된다고...
		Integer i = 0;
		String sql = "insert into member (" + COLUMNS + ") values(?,?,?,?,?,?,?,?,?,sysdate)";
		i = jdbcTemplate.update(sql, memberDTO.getUserId(), memberDTO.getUserPw(), memberDTO.getUserName(), memberDTO.getUserGender(), memberDTO.getUserEmail(), memberDTO.getUserAddr(), memberDTO.getUserPh1(), memberDTO.getUserPh2(), memberDTO.getUserBirth());
//		myBatis 들어가면 이거랑 또 다른 방식으로 쓴다고...
		return i;
//		<!-- 요거는 다른 방식.. 이것도 한번 봐두기는 하기... -- >
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			// PreparedStatementCreator()... 오버라이딩해야 되는 메소드.. 변수없는 익명객체.. 여기서 그냥 작성하면 된다... 얘가 '인터페이스'일 때만 가능하다고...
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				String sql = "insert into member (" + COLUMNS + ") values(?,?,?,?,?,?,?,?,?,sysdate)";
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1, memberDTO.getUserId());
//				pstmt.setString(2, memberDTO.getUserPw());
//				pstmt.setString(3, memberDTO.getUserName());
//				pstmt.setString(4, memberDTO.getUserGender());
//				pstmt.setString(5, memberDTO.getUserEmail());
//				pstmt.setString(6, memberDTO.getUserAddr());
//				pstmt.setString(7, memberDTO.getUserPh1());
//				pstmt.setString(8, memberDTO.getUserPh2());
//				pstmt.setTimestamp(9, memberDTO.getUserBirth());
//				return pstmt;
//			}
//		});
	}

	public MemberDTO selectByUserId(MemberDTO member) {			// 회원 한 명 받아오기
		String sql = "select " + COLUMNS + " from member where user_id=?";
		List<MemberDTO> results = jdbcTemplate.query(sql, memRowMapper, member.getUserId());
		// rowMapper(ResultSetExtractor<>...) 한 줄 단위로. 리스트로. 어떤 객체..에 저장해서 뽑아오는 그런 개념인가..
		// 물음표?들 포함해서 쿼리로 받아온 rs를. RowMapper에 매개변수로 주고. RowMapper에서 MemberDTO에 저장해서 하는거고.. memRowMapper를 위에 필드로 따로 뺐고...
		// 이후에.. ?에 들어갈 것들을 물음표 순서대로 나열주면 된다고..
		// select로 예전에는 한 행만 받아올 수도 있었는데. 여기(Spring)에서는 resultSet을 무조건 리스트..로 받아온다고... (while문 쓸 필요가 없고...)
		return results.isEmpty() ? null : results.get(0); // 결과값이 어차피 하나니깐. 없으면 null. 있으면 첫번째꺼 리턴...
	}

	public List<MemberDTO> selectList() {				// 회원 전체 목록 받아오기
		String sql = "select " + COLUMNS + " from member";
		List<MemberDTO> results = jdbcTemplate.query(sql, memRowMapper);
		return results;
	}
	
	public int count() {
		String sql = "select count(*) from member";
		return jdbcTemplate.queryForObject(sql, Integer.class);		// 요런 식으로 바로 리턴하는 게 더 나은 코드라고-
	}

//	public Integer modifyMember(final MemberDTO member) {		// 요 방식도 알고는 있어야 된다고.. 회사가서 어떤 방식일지 모른다고... 회사방식에 맞춰야..
//		final String sql = "update member set user_email=?, user_addr=?, user_ph1=?, user_ph2=? where user_id=? and user_pw=?";
//		Integer result = jdbcTemplate.update(new PreparedStatementCreator() {
//			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				pstmt.setString(1,  member.getUserEmail());
//				pstmt.setString(2,  member.getUserAddr());
//				pstmt.setString(3,  member.getUserPh1());
//				pstmt.setString(4,  member.getUserPh2());
//				pstmt.setString(5,  member.getUserId());
//				pstmt.setString(6,  member.getUserPw());
//				return pstmt;
//			}
//		});
//		return result;
//	}
	public Integer modifyMember(final MemberDTO member) {
		String sql = "update member set user_email=?, user_addr=?, user_ph1=?, user_ph2=? where user_id=? and user_pw=?";
		Integer result = jdbcTemplate.update(sql, member.getUserEmail(), member.getUserAddr(), member.getUserPh1(), member.getUserPh2(), member.getUserId(), member.getUserPw());
		return result;
	}
}
