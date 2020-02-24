package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardDeleteService {
	@Autowired
	private LibraryBoardDAO libraryDAO;
	
	public Integer deleteBoard(String boardNum, String boardPass) {
		LibraryBoardDTO dto = new LibraryBoardDTO();
		dto.setBoardNum(Integer.parseInt(boardNum));
		dto.setBoardPass(Encrypt.getEncryption(boardPass));
		System.out.println(dto.getBoardPass());
		return libraryDAO.deleteBoard(dto);
	}
}
