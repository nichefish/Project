package Controller.Board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Board.BoardCommand;
import Service.Board.BoardModifyService;
import Service.Board.BoardWriteService;
import Validator.BoardCommandValidator;

@Controller
public class BoardModifyController {
	@Autowired
	private BoardModifyService boardModifyService;
	
	@RequestMapping("/board/boardModify")	// 글쓰기..
	public String boardForm(BoardCommand boardCommand) {
		return "board/qna_board_modify";
	}
	
	@RequestMapping("/board/boardModifyAction")	// 글쓰기..
	public String boardModify(BoardCommand boardCommand, Errors errors, HttpServletRequest request) {
		new BoardCommandValidator().validate(boardCommand, errors);	// 에러 검사...
		if (errors.hasErrors()) {		// 에러가 발생했다면...
			return "board/qna_board_modify";		// 글쓰기 form으로 돌려보냄...
		}
		Integer i = 0;
		try {
			i = boardModifyService.execute(boardCommand, request);		// DB에 insert시 row수가 반환되니까.. 그거 확인...
			return "redirect:/board/list";
		} catch(Exception e) {
			return "board/qna_board_modify";
		}
	}
}
