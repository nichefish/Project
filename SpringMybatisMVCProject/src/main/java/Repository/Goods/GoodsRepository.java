package Repository.Goods;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.GoodsDTO;

@Repository
public class GoodsRepository {
	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "goodsMapper";

	public Integer goodsInsert(GoodsDTO dto) {
		String statement = namespace + ".goodsInsert";
		return sqlSession.insert(statement, dto);
	}

	public List<GoodsDTO> goodsList() {
		String statement = namespace + ".goodsList";
		return sqlSession.selectList(statement);
	}

	public GoodsDTO goodsDetail(Long goodsSeq) {
		String statement = namespace + ".goodsList";
		return sqlSession.selectOne(statement);
	}

	public Integer goodsWishAdd(Long goodsSeq, String userId) {
		String statement = namespace + ".goodsList";
		GoodsDTO dto = sqlSession.selectOne(statement, goodsSeq);
		dto.setUserId(userId); //여기까지 된다...
		statement = namespace + ".goodsWish";
		return sqlSession.update(statement, dto);
		
	}
}
