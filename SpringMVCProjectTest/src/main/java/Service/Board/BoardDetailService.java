package Service.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

@Service
public class BoardDetailService {
	@Autowired
	private BoardDAO boardDAO;
	
	public BoardDTO boardDetail(String boardNum, Model model) {
		BoardDTO board = new BoardDTO();
		board.setBoardNum(Integer.parseInt(boardNum));
		board = boardDAO.selectByBoardNum(board);
		model.addAttribute("boardCommand", board);
		return board;
	}
}
