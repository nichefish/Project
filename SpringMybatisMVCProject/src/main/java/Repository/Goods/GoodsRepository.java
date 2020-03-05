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
	
}
