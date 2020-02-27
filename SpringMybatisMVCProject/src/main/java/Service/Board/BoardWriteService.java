package Service.Board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Board.BoardCommand;
import Controller.Encrypt;
import Model.DTO.BoardDTO;
import Repository.Board.BoardWriteRepository;
import Validator.BoardCommandValidator;

@Service
public class BoardWriteService {
	@Autowired
	private BoardWriteRepository boardWriteRepository;
	
	public void boardInsert(BoardCommand boardCommand,HttpServletRequest request) {
		BoardDTO dto = new BoardDTO();
		dto.setUserId("test");
		dto.setBoardName(boardCommand.getBoardName());
		dto.setBoardPass(Encrypt.getEncryption(boardCommand.getBoardPass()));
		dto.setBoardSubject(boardCommand.getBoardSubject());
		dto.setBoardContent(boardCommand.getBoardContent());
		dto.setIpAddr(request.getRemoteAddr());
		boardWriteRepository.insertBoard(dto);
	}
}
