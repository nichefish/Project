package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import Model.DTO.MemberDTO;

public class MemberDAO {
	// jdbc 템플릿 사용... spring-jdbc.xml에서 dataSource를 갖고오는 거다... 그걸 이용해서 얘를 초기화...
	private JdbcTemplate jdbcTemplate;
	final String COLUMNS = "user_id, user_pw, user_name, user_gender, user_email, user_addr, user_ph1, user_ph2, user_birth, user_regist";
	
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
	
}
