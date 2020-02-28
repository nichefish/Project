package Repository.Member;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Service.Member.AbstractRepository;

@Repository
public class MemberRepository extends AbstractRepository {
	private final String namespace = "memberMapper";
	SqlSession sqlSession = getSqlSessionFactory().openSession();

	public Integer insertMember(MemberDTO dto) {
		Integer result = null;
		String statement = namespace + ".insertMember";
		try {
			result = sqlSession.insert(statement, dto);
//			sqlSession.commit();	// 여기 spring에선 commit을 자동으로 해주니까... 직접 transaction 관리 안하니까.. commit 못씀.. 에러 생김...
		} catch (Exception e) {
			e.printStackTrace();
//			sqlSession.rollback();
		}
		return result;
	}
}
