package Controller.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Board.BoardCommand;
import Service.Board.BoardDetailService;
import Service.Board.BoardModifyService;
import Service.Board.BoardWriteService;
import Validator.BoardCommandValidator;

@Controller
public class BoardModifyController {
	@Autowired
	private BoardModifyService boardModifyService;
	@Autowired
	private BoardDetailService boardDetailService;
	
	@RequestMapping("/edit/boardModify")	// 글쓰기..
	public String boardForm(@RequestParam(value="boardNum") String boardNum, BoardCommand boardCommand, Model model) {
		boardDetailService.boardDetail(boardNum, model);
		return "board/qna_board_modify";
	}
	
	@RequestMapping("/edit/boardModifyAction")	// 글쓰기..
	public String boardModify(BoardCommand boardCommand, Errors errors, HttpServletRequest request) {
		System.out.println(boardCommand.getBoardNum());
		// 지금 여기서 막힌 건가...
		new BoardCommandValidator().validate(boardCommand, errors);	// 에러 검사...
		if (errors.hasErrors()) {		// 에러가 발생했다면...
			return "board/qna_board_modify";		// 글쓰기 form으로 돌려보냄...
		}
		Integer result = boardModifyService.execute(boardCommand);
		if (result == 0) {
			errors.rejectValue("boardPass", "badPw");		// 에러 주입...
			System.out.println("에러인데...");
			return "redirect:/edit/boardModify?boardNum=" + boardCommand.getBoardNum();
		}
		return "redirect:/board/boardInfo/" + boardCommand.getBoardNum();
	}
}
