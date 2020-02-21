package Service.Library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Library.LibraryBoardCommand;
import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.AuthInfo;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	
	public Integer writePro(LibraryBoardCommand libraryBoardCommand, HttpSession session, HttpServletRequest request) {
		Integer result = 0;
		LibraryBoardDTO libraryDTO = new LibraryBoardDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		libraryDTO.setUserId(authInfo.getId());
		libraryDTO.setBoardName(libraryBoardCommand.getBoardName());
		libraryDTO.setBoardPass(Encrypt.getEncryption(libraryBoardCommand.getBoardPass()));
		libraryDTO.setBoardSubject(libraryBoardCommand.getBoardSubject());
		libraryDTO.setBoardContent(libraryBoardCommand.getBoardContent());
		libraryDTO.setIpAddr(request.getRemoteAddr());
		result = libraryBoardDAO.insertBoard(libraryDTO);
		return result;
	}
}