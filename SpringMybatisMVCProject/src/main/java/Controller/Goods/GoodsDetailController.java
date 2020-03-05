package Controller.Goods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsDetailController {
	@RequestMapping("/goods/goodsDetail")
	public String goodsDetail(@RequestParam(value="num") Long goodsSeq) {
		return "GoodsView/goodsDetail";
	}
}
