package Service.Library;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Controller.Encrypt;
import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardDeleteService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	
	public String deleteBoard(String boardNum, String boardPass, HttpServletRequest request) {
		LibraryBoardDTO dto = new LibraryBoardDTO();
		dto.setBoardNum(Integer.parseInt(boardNum));
		dto.setBoardPass(Encrypt.getEncryption(boardPass));
		LibraryBoardDTO board = libraryBoardDAO.selectByBoardNum(dto, "libraryBoard");
		Integer result = libraryBoardDAO.deleteBoard(dto);
		String path = "";
		if (result > 0) {
			String realPath = "WEB-INF\\view\\libraryBoard\\update\\";
			String filePath = request.getServletContext().getRealPath(realPath);
			String [] storeFileName = board.getStoreFileName().split("-");
			for (String f : storeFileName) {
				File file = new File(filePath + "\\" + f);
				file.delete();
			}
			path = "redirect:/libraryBoard/library";
		} else {
			request.setAttribute("passError", "비밀번호가 틀렸습니다.");
			request.setAttribute("num", boardNum);
			path = "redirect:/libraryBoard/board_delete";
		}
		System.out.println(dto.getBoardPass());
		return path;
	}
}
