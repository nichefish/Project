package Controller.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Answer.AnswerBoardListService;

@Controller
public class AnswerBoardController {
	@Autowired
	AnswerBoardListService answerBoardListService;
	
	@RequestMapping("/answer/answerBoard")
	public String form(Model model, @RequestParam(value="page", required=false) Integer page) {
		answerBoardListService.boardList(model, page);
		return "answerBoard/ans_board_list";
	}
}
