package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDetailService;

@Controller
public class BoardDetailController {
	@Autowired
	private LibraryBoardDetailService libraryBoardDetailService;
	
	@RequestMapping("/edit/boardWritePro")
	public String boardView(@RequestParam(value="num") Integer boardNum, Model model) {
		libraryBoardDetailService.boardView(boardNum, model);
		
		
		
		
		
		
		return "board/board_view";
	}
}
