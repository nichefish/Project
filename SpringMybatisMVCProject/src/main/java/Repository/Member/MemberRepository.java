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
		String statement = namespace + ".memberInsert";
		try {
			result = sqlSession.insert(statement, dto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		}
		return result;
	}
}
