package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Library.LibraryBoardCommand;
import Service.Library.LibraryBoardService;

@Controller
public class LibraryBoardController {
	@Autowired
	private LibraryBoardService libraryBoardService;
	
	
	@RequestMapping("/libraryBoard/library")
	public String libraryList() {
		return "libraryBoard/board_list";
	}
	
	@RequestMapping("/libraryBoard/boardWrite")
	public String libraryWrite() {
		return "libraryBoard/board_write";
	}
	
	@RequestMapping("/libraryBoard/boardWritePro")
	public String libraryWritePro(LibraryBoardCommand libraryBoardCommand) {
		libraryBoardService.writePro(libraryBoardCommand);
		return "redirect:/libraryBoard/library";
	}
	
}
