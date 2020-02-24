package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDeleteService;

@Controller
public class LibraryBoardDeleteController {
	@Autowired
	private LibraryBoardDeleteService libraryBoardDeleteService;
	
	@RequestMapping("/libraryBoard/boardDelete")
	public String deleteLibrary(@RequestParam(value="num") String boardNum) {
		return "libraryBoard/board_delete";
	}
	
	@RequestMapping("/libraryBoard/boardDeletePro")
	public String deleteLibraryPro(@RequestParam(value="num") String boardNum, @RequestParam(value="boardPass") String boardPass, Model model) {
		Integer result = libraryBoardDeleteService.deleteBoard(boardNum, boardPass);
		String path = null;
		if (result == 0) {
			// 에러메세지 출력...
			model.addAttribute("passError", "비밀번호가 틀렸습니다.");
			path = "libraryBoard/board_delete";
		} else {
			path = "redirect:/libraryBoard/library";
		}
		return path;
	}
}
