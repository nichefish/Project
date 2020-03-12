package Service.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.AuthInfo;
import Model.DTO.CartDTO;
import Model.DTO.CartRemove;
import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsCartService {
	@Autowired
	private GoodsRepository goodsRepository;
	
	public void goodsCartAdd(Long goodsSeq, Model model, HttpSession session) {
		GoodsDTO dto = goodsRepository.goodsDetail(goodsSeq);
		CartDTO cart = new CartDTO();
		String userId = ((AuthInfo) session.getAttribute("authInfo")).getId();
		cart.setGoodsSeq(dto.getGoodsSeq());
		cart.setUserId(userId);
		cart.setGoodsName(dto.getGoodsName());
		cart.setGoodsImage(dto.getGoodsImage());
		cart.setGoodsPrice(dto.getGoodsPrice());
		cart.setGoodsQty(dto.getGoodsQty());
		Integer result = goodsRepository.goodsCartAdd(cart);
		model.addAttribute("cartAdd", result);
	}

	public void goodsCartList(Model model, HttpSession session) {
		String userId = ((AuthInfo) session.getAttribute("authInfo")).getId();
		List<CartDTO> list = goodsRepository.goodsCartList(userId);
		model.addAttribute("cartList", list);
	}

	public void goodsCartQtyDown(Long goodsSeq, Model model, HttpSession session) {
		CartDTO cart = new CartDTO();
		cart.setGoodsSeq(goodsSeq);
		String userId = ((AuthInfo) session.getAttribute("authInfo")).getId();
		cart.setUserId(userId);
		goodsRepository.goodsCartQtyDown(cart);
	}

	public void goodsCartRemove(Long[] goodsSeqs) {
		List<Long> cs = new ArrayList<Long>();
		for (Long goodsSeq : goodsSeqs) {
			cs.add(goodsSeq);
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("seqs", cs);
		goodsRepository.goodsCartRemove(condition);
	}
}
