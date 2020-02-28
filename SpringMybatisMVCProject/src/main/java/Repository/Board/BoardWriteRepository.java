package Repository.Board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.BoardDTO;

@Repository
public class BoardWriteRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "boardMapper";		// 아까 xml에서 설정한 거...
	
	public Integer insertBoard(BoardDTO dto) {
		String statement = namespace + ".boardInsert";
		Integer result = sqlSession.insert(statement, dto);
//		BoardDTO d = sqlSession.selectOne(statement, boardNum)
//		List<BoardDTO> list = sqlSession.selectList(statement, null);
		return result;
	}

}
