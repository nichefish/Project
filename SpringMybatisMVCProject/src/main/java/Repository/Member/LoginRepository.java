package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Service.Member.AbstractRepository;

@Repository
public class LoginRepository extends AbstractRepository {
	private final String namespace = "loginMapper";		// 여기랑 어디꺼랑 같아야 되는데...
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	
	public MemberDTO selectByUserId(MemberDTO member) {
		String statement = namespace + ".selectUser";
		MemberDTO dto = sqlSession.selectOne(statement, member);
		dto.getUserId();
		return dto;
	}
}