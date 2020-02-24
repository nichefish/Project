package Controller.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Board.BoardCommand;
import Command.Library.LibraryBoardCommand;
import Service.Board.BoardListService;
import Service.Library.LibraryBoardListService;
import Service.Library.LibraryBoardService;
import Validator.BoardCommandValidator;

@Controller
public class LibraryBoardController {
	@Autowired
	private LibraryBoardService libraryBoardService;
	@Autowired
	private LibraryBoardListService libraryBoardListService;
	
	@RequestMapping("/libraryBoard/library")
	public String libraryList(Model model, @RequestParam(value="page", required=false) Integer page) {
		libraryBoardListService.boardList(model, page);
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
		try {
			libraryBoardService.writePro(libraryBoardCommand, session, request);		// DB에 insert시 row수가 반환되니까.. 그거 확인...
			return "redirect:/libraryBoard/library";
		} catch(Exception e) {
			return "libraryBoard/board_write";
		}
	}
}
