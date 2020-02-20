package Service.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.BoardDAO;

@Service
public class BoardDeleteService {
	@Autowired
	private BoardDAO boardDAO;
	
	public void execute(String boardNum) {
		boardDAO.deleteBoard(boardNum);
	}
}
