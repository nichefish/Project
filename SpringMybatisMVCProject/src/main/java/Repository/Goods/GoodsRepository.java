package Repository.Goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CartDTO;
import Model.DTO.CartRemove;
import Model.DTO.GoodsDTO;
import Model.DTO.WishDTO;

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
		return sqlSession.selectOne(statement, goodsSeq);
	}

	public Integer goodsWishAdd(Long goodsSeq, String userId) {
		WishDTO dto = new WishDTO();
		dto.setGoodsSeq(goodsSeq);
		dto.setUserId(userId);
		String statement = namespace + ".goodsWishCount";
		Integer i = sqlSession.selectOne(statement, dto);
		if (i == 0) {
			statement = namespace + ".wishInsert";
			sqlSession.insert(statement, dto);
			i = 1;
		} else {
			statement = namespace + ".wishDelete";
			sqlSession.delete(statement, dto);
			i = 0;
		}
		return i;
		
//		GoodsDTO dto = sqlSession.selectOne(statement, goodsSeq);
//		dto.setUserId(userId); //여기까지 된다...
//		statement = namespace + ".goodsWish";
//		return sqlSession.update(statement, dto); // 요게 2를 반환하네...
	}

	public List<GoodsDTO> goodsWishList(String userId) {
		String statement = namespace + ".goodsWishList";
		return sqlSession.selectList(statement, userId);
	}

	public Integer goodsCartAdd(CartDTO cart) {
		String statement = namespace + ".goodsCartAdd";
		return sqlSession.insert(statement, cart);
	}

	public List<CartDTO> goodsCartList(String userId) {
		String statement = namespace + ".goodsCartList";
		return sqlSession.selectList(statement, userId);
	}

	public void goodsCartQtyDown(CartDTO cart) {
		String statement = namespace + ".goodsCartDown";
		sqlSession.update(statement, cart);
	}

	public void goodsCartRemove(Map<String, Object> condition) {
		String statement = namespace + ".goodsCartRemove";
		sqlSession.delete(statement, condition);
	}
}
