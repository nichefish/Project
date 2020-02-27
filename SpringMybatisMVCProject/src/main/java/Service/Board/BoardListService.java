package Service.Board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

@Service
public class BoardListService {
	@Autowired
	private BoardDAO boardDAO;
	
	public void boardList(Model model) {
		List<BoardDTO> boards = boardDAO.selectList();
		if (boards != null) {
			model.addAttribute("boards", boards);
			model.addAttribute("count", boardDAO.count());		// 코드를 이런 식으로 가자고- 필요없는 코드 자꾸 적지 말자고-
		}
	}
}
