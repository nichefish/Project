package Repository.Member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.DTO.MemberDTO;
import Service.Member.AbstractRepository;

public class MemberDMLRepository extends AbstractRepository {
	//	@Autowired
	//	SqlSession sqlSession;	// 요게 스프링 스타일이고...
	// 마이바티스에 DB 설정해놓은 경우에는. 직접 SqlSession을 만들어써야 된다고.. getSqlSessionFactory()... 그게 AbstractRepository 부분...
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	private final String namespace = "memberDMLMapper";
	
	public Integer memberUpdate(MemberDTO dto) {
		String statement = namespace + ".memberUpdate";
		Integer result = sqlSession.update(statement, dto);
		try {
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public Integer memberDelete(MemberDTO dto) {
		String statement = namespace + ".memberDelete";
		Integer result = sqlSession.update(statement, dto);
		try {
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public Integer changePw(MemberDTO dto) {
		String statement = namespace + ".userPwChange";
		Integer result = sqlSession.update(statement, dto);
		try {
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		return result;
	}
}