package Controller.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Goods.GoodsListService;

@Controller
public class GoodsController {
	@Autowired
	private GoodsListService goodsListService;
	
	@RequestMapping("/goods/goodsList")
	public String goodsList(Model model) {
		goodsListService.execute(model);
		return "GoodsView/goodsList";
	}
}