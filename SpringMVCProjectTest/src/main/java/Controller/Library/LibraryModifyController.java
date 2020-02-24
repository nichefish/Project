package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDetailService;

@Controller
public class LibraryModifyController {
	@Autowired
	private LibraryBoardDetailService libraryBoardDetailService;
	
	@RequestMapping("/libraryBoard/boardModify")
	public String boardModify(@RequestParam(value="num") Integer boardNum, @RequestParam(value="option") String option, Model model) {
		String tableName="libraryboard";
		libraryBoardDetailService.boardView(boardNum, model, tableName);
		return "libraryBoard/board_modify";
	}
}
