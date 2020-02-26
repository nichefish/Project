package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Answer.AnswerCommand;
import Service.Answer.AnswerWriteService;

@Controller
@RequestMapping("/answer/boardWrite")
public class AnswerBoardWriteController {
	@Autowired
	private AnswerWriteService answerWriteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(AnswerCommand answerCommand) {
//	public String form1(@ModelAttribute("answerBoardCommand")) {	// 두 번째 방법.. 요렇게 쓰는 데도 되게 많다고.. 모델에 저장해서 보내겠단 얘기...
//	public String form1(Model model) {	
//		model.addAttribute("answerCommand", new AnswerCommand());	// 세 번째 방법... 근데 이건 뭔가 별로같아 보임...
		return "answerBoard/ans_board_write";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(AnswerCommand answerCommand, HttpSession session, HttpServletRequest request) {
		String path = answerWriteService.answerInsert(answerCommand, session, request);
		return path;
//			"redirect:/answer/answerBoard";
	}
	
}
