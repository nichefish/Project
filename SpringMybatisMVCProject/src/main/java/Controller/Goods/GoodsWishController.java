package Controller.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsWishService;

@Controller
public class GoodsWishController {
	@Autowired
	private GoodsWishService goodsWishService;
	
	@RequestMapping("/goods/goodsWishAdd")
	public String goodsWishAdd(@RequestParam(value="seq") Long goodsSeq, Model model, HttpSession session) {
		Integer i = goodsWishService.goodsWishAdd(goodsSeq, model, session);
		return "redirect:/goods/goodsDetail?seq=" + goodsSeq;
	}
	
	@RequestMapping("/goods/goodsWishList")
	public String goodsWishList(Model model, HttpSession session) {
		goodsWishService.goodsWishList(model, session);
		return "GoodsView/goodsWishList";
	}
}