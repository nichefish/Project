package Controller.Answer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Answer.AnswerCommand;
import Service.Answer.AnswerBoardReplyService;

@Controller
@RequestMapping("/answer/boardReply")
public class AnswerBoardReplyController {
	@Autowired
	private AnswerBoardReplyService answerBoardReplyService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String replyWrite(@RequestParam("num") Integer boardNum, AnswerCommand answerCommand) {
		return "answerBoard/ans_board_reply";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String replyWritePro(AnswerCommand answerCommand, HttpSession session, HttpServletRequest request) {
		answerBoardReplyService.replyWrite(answerCommand, session, request);
		System.out.println("!?!@!?? reply write..");
		return "answerBoard/ans_board_reply";
	}
}
