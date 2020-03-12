package Controller.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsCartService;

@Controller
public class GoodsCartController {
	@Autowired
	private GoodsCartService goodsCartService;
	
	@RequestMapping("/goods/goodsCartAdd")
	public String goodsCartAdd(@RequestParam(value="seq") Long goodsSeq, Model model, HttpSession session) {
		goodsCartService.goodsCartAdd(goodsSeq, model, session);
		return "redirect:/goods/goodsDetail?seq=" + goodsSeq;
	}
	
	@RequestMapping("/goods/goodsCartList")
	public String goodsCartList(Model model, HttpSession session) {
		goodsCartService.goodsCartList(model, session);
		return "GoodsView/goodsCartList";
	}
	
	@RequestMapping("/goods/goodsCartQtyUp")
	public String goodsCartQtyUp(@RequestParam(value="seq") Long goodsSeq, Model model, HttpSession session) {
		goodsCartService.goodsCartAdd(goodsSeq, model, session);
		return "redirect:/goods/goodsCartList";
	}
	
	@RequestMapping("/goods/goodsCartQtyDown")
	public String goodsCartQtyDown(@RequestParam(value="seq") Long goodsSeq, Model model, HttpSession session) {
		goodsCartService.goodsCartQtyDown(goodsSeq, model, session);
		return "redirect:/goods/goodsCartList";
	}
	
	@RequestMapping("/goods/goodsCartRemove")
	public String goodsCartRemove(@RequestParam(value="delete") Long [] goodsSeqs) {
		goodsCartService.goodsCartRemove(goodsSeqs);
		return "redirect:/goods/goodsCartList";
	}
	
}
