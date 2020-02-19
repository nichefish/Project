package Controller.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Board.BoardDetailService;

@Controller
public class BoardInfoController {
	@Autowired
	private BoardDetailService boardDetailService;
	
	@RequestMapping("/board/boardInfo/{aa}")
	public String memberInfo(@PathVariable("aa") String boardNum, Model model) {
		try {
			boardDetailService.boardDetail(boardNum, model);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/board/list";
		}
		return "board/qna_board_view";
	}
}
