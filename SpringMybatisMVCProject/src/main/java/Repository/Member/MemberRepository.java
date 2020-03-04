package Repository.Member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import Model.DTO.MemberDTO;
import Model.DTO.StartEndPageDTO;
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

	public List<MemberDTO> getMemberList(int page, int limit) {
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		String statememt = namespace + ".memberList";
		List<MemberDTO> lists = sqlSession.selectList(statememt, new StartEndPageDTO(startRow, endRow));
		return lists;
	}
	
	public Integer getListCount() {
		String statement = namespace + ".memberCount";
		return sqlSession.selectOne(statement);
	}
	
	public MemberDTO selectByUserId(MemberDTO member) {
		String statement = namespace + ".selectUser";
		MemberDTO dto = sqlSession.selectOne(statement, member);
		return dto;
	}
}
