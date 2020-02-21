package Service.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Board.BoardCommand;
import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

@Service
public class BoardModifyService {
	@Autowired
	private BoardDAO boardDAO;
	
	public Integer execute(BoardCommand boardCommand) {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardNum(Integer.parseInt(boardCommand.getBoardNum()));
		boardDTO.setBoardName(boardCommand.getBoardName());
		boardDTO.setBoardPass(boardCommand.getBoardPass());
		boardDTO.setBoardSubject(boardCommand.getBoardSubject());
		boardDTO.setBoardContent(boardCommand.getBoardContent());
		return boardDAO.updateBoard(boardDTO);
	}

}
