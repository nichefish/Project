package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Library.LibraryBoardCommand;
import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryModifyService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	
	public String modifyPro(LibraryBoardCommand libraryBoardCommand, Errors errors) {
		LibraryBoardDTO dto = new LibraryBoardDTO();
		// 커맨드객체와 DTO가 같더라도. 프로그램 로직상. 커맨드 값을 DTO에 일일히 할당해서 DTO를 통해 DB에 보내는 게 낫다고...
		dto.setBoardNum(libraryBoardCommand.getBoardNum());
		dto.setBoardSubject(libraryBoardCommand.getBoardSubject());
		dto.setBoardContent(libraryBoardCommand.getBoardContent());
		dto.setBoardPass(Encrypt.getEncryption(libraryBoardCommand.getBoardPass()));
		Integer result = libraryBoardDAO.updateBoard(dto);
		String path = null;
		if (result != 0) {
			path = "redirect:/libraryBoard/boardModify?num=" + dto.getBoardNum();
		} else {
			errors.rejectValue("boardPass", "badPw");
			path = "redirect:/libraryBoard/boardDetail?num=" + dto.getBoardNum();
		}
		return path;
	}
}
