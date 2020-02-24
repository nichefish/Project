package Controller.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Library.LibraryBoardDeleteService;

@Controller
public class LibraryBoardDeleteController {
	@Autowired
	private LibraryBoardDeleteService libraryBoardDeleteService;
	
	@RequestMapping("/libraryBoard/boardDelete")
	public String deleteLibrary(@ModelAttribute("num") String boardNum, Model model) {
		model.addAttribute("boardNum", boardNum);
		return "libraryBoard/board_delete";
	}
	
	@RequestMapping("/libraryBoard/boardDeletePro")
	public String deleteLibraryPro(@ModelAttribute("boardNum") String boardNum, @RequestParam(value="boardPass") String boardPass, Model model) {
		System.out.println(boardNum);
		Integer result = libraryBoardDeleteService.deleteBoard(boardNum, boardPass);
		String path = null;
		
		if (result == 0) {
			// 에러메세지 출력...
			System.out.println("result:" +result);
			model.addAttribute("passError", "비밀번호가 틀렸습니다.");
			path = "libraryBoard/board_delete";
		} else {
			path = "redirect:/libraryBoard/library";
		}
		return path;
	}
}
