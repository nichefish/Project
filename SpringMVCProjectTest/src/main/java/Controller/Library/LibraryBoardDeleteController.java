package Controller.Library;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDeleteService;

@Controller
@RequestMapping("/libraryBoard/boardDelete")
public class LibraryBoardDeleteController {
	@Autowired
	private LibraryBoardDeleteService libraryBoardDeleteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteLibrary(@ModelAttribute("num") String boardNum, Model model) {
		return "libraryBoard/board_delete";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String deleteLibraryPro(@RequestParam("boardNum") String boardNum, @RequestParam("boardPass") String boardPass, HttpServletRequest request) {
		System.out.println("boardNum: " + boardNum);
		System.out.println("boardPass: " + boardPass);
		return libraryBoardDeleteService.deleteBoard(boardNum, boardPass, request);
	}
}
