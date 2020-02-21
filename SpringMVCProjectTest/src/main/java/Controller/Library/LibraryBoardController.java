package Controller.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Board.BoardCommand;
import Command.Library.LibraryBoardCommand;
import Service.Board.BoardListService;
import Service.Library.LibraryBoardService;
import Validator.BoardCommandValidator;

@Controller
public class LibraryBoardController {
	@Autowired
	private LibraryBoardService libraryBoardService;
	
	@RequestMapping("/libraryBoard/library")
	public String libraryList() {
		return "libraryBoard/board_list";
	}
	
	@RequestMapping("/edit/boardWrite")
	public String libraryWrite(LibraryBoardCommand libraryBoardCommand) {
		return "libraryBoard/board_write";
	}
	
	@RequestMapping("/edit/boardWritePro")
	public String libraryWritePro(LibraryBoardCommand libraryBoardCommand, Errors errors, HttpSession session, HttpServletRequest request) {
//		new BoardCommandValidator().validate(libraryBoardCommand, errors);	// 에러 검사...
//		if (errors.hasErrors()) {		// 에러가 발생했다면...
//			return "board/qna_board_write";		// 글쓰기 form으로 돌려보냄...
//		}
		System.out.println("!!?!!!EEE");
		try {
			libraryBoardService.writePro(libraryBoardCommand, session, request);		// DB에 insert시 row수가 반환되니까.. 그거 확인...
			return "redirect:/libraryBoard/library";
		} catch(Exception e) {
			return "libraryBoard/board_write";
		}
	}
}
