package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardDetailService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	
	public void boardView(Integer boardNum, Model model, String tableName, Integer num) {
		libraryBoardDAO.boardReadCountUpdate(boardNum);
		LibraryBoardDTO board = new LibraryBoardDTO();
		board.setBoardNum(boardNum);
		board = libraryBoardDAO.selectByBoardNum(board, tableName);
		if (num != 1) {
			board.setBoardContent(board.getBoardContent().replace("\n", "<br />"));		// textarea에서 줄바꿈...
		}
		model.addAttribute("board", board);
	}

}
