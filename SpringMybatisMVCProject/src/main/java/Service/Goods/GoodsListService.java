package Service.Goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsListService {
	@Autowired
	private GoodsRepository goodsRepository;

	public void execute(Model model) {
		List<GoodsDTO> lists = goodsRepository.goodsList();
		model.addAttribute("lists", lists);
	}

}
