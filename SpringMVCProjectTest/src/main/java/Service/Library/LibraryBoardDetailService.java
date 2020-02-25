package Service.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.LibraryBoardDAO;
import Model.DTO.LibraryBoardDTO;

@Service
public class LibraryBoardDetailService {
	@Autowired
	private LibraryBoardDAO libraryBoardDAO;
	
	public void boardView(Integer boardNum, Model model, String tableName, Integer num) {
		libraryBoardDAO.boardReadCountUpdate(boardNum);
		LibraryBoardDTO dto = new LibraryBoardDTO();
		dto.setBoardNum(boardNum);
		dto = libraryBoardDAO.selectByBoardNum(dto, tableName);
		if (num != 1) {
			dto.setBoardContent(dto.getBoardContent().replace("\n", "<br />"));		// textarea에서 줄바꿈...
		}
		String [] oriFile = dto.getOriginalFileName().split("-");
		String [] strFile = dto.getStoreFileName().split("-");
		String [] fileSize = dto.getFileSize().split("-");
		model.addAttribute("libraryBoardCommand", dto);		// dto를 저장해서 커맨드객체로 쓰는 거임... 저장되는 값이 이름이 같으니까... 이런 식으로...
		model.addAttribute("originalFileName", oriFile);
		model.addAttribute("storeFileName", strFile);
		model.addAttribute("fileSize", fileSize);
	}
}
