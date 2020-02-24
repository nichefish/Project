package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import Command.Library.LibraryBoardCommand;
import Service.Library.LibraryModifyService;
import Validator.LibraryBoardModifyValidator;

@Controller
public class LibraryBoardModifyProController {
	@Autowired
	private LibraryModifyService libradyModifyService;
	
	@RequestMapping("/libraryBoard/boardModifyPro")
	public String boardModifyPro(LibraryBoardCommand libraryBoardCommand, Errors errors, Model model) {
		new LibraryBoardModifyValidator().validate(libraryBoardCommand, errors);	// 에러 검사...
		if (errors.hasErrors()) {
			return "libraryBoard/board_modify";
		}
		String path = libradyModifyService.modifyPro(libraryBoardCommand, errors);
		return path;
	}
}
