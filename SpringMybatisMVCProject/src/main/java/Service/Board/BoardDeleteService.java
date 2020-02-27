package Service.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

@Service
public class BoardDeleteService {
	@Autowired
	private BoardDAO boardDAO;
	
	public Integer execute(String boardNum) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNum(Integer.parseInt(boardNum));
		return boardDAO.deleteBoard(boardDTO);
	}
}
