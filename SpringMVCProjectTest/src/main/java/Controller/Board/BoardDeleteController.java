package Controller.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Board.BoardCommand;
import Service.Board.BoardDeleteService;

@Controller
public class BoardDeleteController {
	@Autowired
	private BoardDeleteService boardDeleteService;
	
	@RequestMapping("/edit/boardDelete")
	public String boardDelete(@RequestParam(value="boardNum") String boardNum) {
		Integer result = boardDeleteService.execute(boardNum);
		if (result == 0) {
			return "board/qna_board_view";
		}
		return "redirect:/board/list";
	}
}
