package Controller.Library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import Command.Library.LibraryBoardCommand;
import Validator.LibraryBoardModifyValidator;

@Controller
public class LibraryBoardModifyProController {
	@RequestMapping("/libraryBoard/boardModifyPro")
	public String boardModifyPro(LibraryBoardCommand board, Errors errors, Model model) {
		new LibraryBoardModifyValidator().validate(board, errors);	// 에러 검사...
		if (errors.hasErrors()) {
			return "libraryBoard/board_modify";
		}
		// 서리븟...
		return "libraryBoard/boardDetail";
	}
}
