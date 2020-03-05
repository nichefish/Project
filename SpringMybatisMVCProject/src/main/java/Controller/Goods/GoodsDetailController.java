package Controller.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsDetailService;

@Controller
public class GoodsDetailController {
	@Autowired
	private GoodsDetailService goodsDetailService;
	
	@RequestMapping("/goods/goodsDetail")
	public String goodsDetail(@RequestParam(value="seq") Long goodsSeq, Model model) {
		goodsDetailService.goodsDetail(model, goodsSeq);
		return "GoodsView/goodsDetail";
	}
}
