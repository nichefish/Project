package Controller.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Board.BoardCommand;
import Service.Board.BoardDeleteService;

@Controller
public class BoardDeleteController {
	@Autowired
	private BoardDeleteService boardDeleteService;
	
	@RequestMapping("/edit/boardDelete/{aa}")
	public String boardDelete(@PathVariable("aa") String boardNum) {
		boardDeleteService.execute(boardNum);
		return "redirect:/board/list";
	}
}
