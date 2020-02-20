package Service.Board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Board.BoardCommand;
import Model.DAO.BoardDAO;
import Model.DTO.BoardDTO;

@Service
public class BoardModifyService {
	@Autowired
	private BoardDAO boardDAO;
	
	public Integer execute(BoardCommand boardCommand, HttpServletRequest request) {
		Integer result = 0;
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBoardName(boardCommand.getBoardName());
		boardDTO.setBoardPass(boardCommand.getBoardPass());
		boardDTO.setBoardSubject(boardCommand.getBoardSubject());
		boardDTO.setBoardContent(boardCommand.getBoardContent());
		boardDTO.setIpAddr(request.getRemoteAddr());
		result = boardDAO.updateBoard(boardDTO);
		return result;
	}

}
