package Controller.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Board.BoardCommand;
import Service.Board.BoardWriteService;
import Validator.BoardCommandValidator;

@Controller
public class BoardWriteController {
	@Autowired
	private BoardWriteService boardWriteService;
	
	@RequestMapping("/board/boardWrite")	// 글쓰기..
	public String boardForm(BoardCommand boardCommand) {
		return "board/qna_board_write";
	}
	
	@RequestMapping("/board/boardWriteAction")	// 글쓰기..
	public String boardWrite(BoardCommand boardCommand, Errors errors, HttpSession session, HttpServletRequest request) {
		new BoardCommandValidator().validate(boardCommand, errors);	// 에러 검사...
		if (errors.hasErrors()) {		// 에러가 발생했다면...
			return "board/qna_board_write";		// 글쓰기 form으로 돌려보냄...
		}
		Integer result = boardWriteService.execute(boardCommand, session, request);		// DB에 insert시 row수가 반환되니까.. 그거 확인...
		if (result == 0) {
			return "board/qna_board_write";
		}
		return "redirect:/board/list";
	}
}