package Service.Answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

@Service
public class AnswerBoardDetailService {
	@Autowired
	private AnswerBoardDAO answerBoardDAO;
	
	public String detailView(Integer boardNum, Model model, int num) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setBoardNum(boardNum);
		dto = answerBoardDAO.selectByBoardNum(dto);
		if (num != 1) {
			dto.setBoardContent(dto.getBoardContent().replace("\n", "<br />"));		// textarea에서 줄바꿈...
		}
		String [] oriFile = dto.getOriginalFileName().split("-");
		String [] strFile = dto.getStoreFileName().split("-");
		String [] fileSize = dto.getFileSize().split("-");
		model.addAttribute("answerCommand", dto);		// dto를 저장해서 커맨드객체로 쓰는 거임... 저장되는 값이 이름이 같으니까... 이런 식으로...
		model.addAttribute("originalFileName", oriFile);
		model.addAttribute("storeFileName", strFile);
		model.addAttribute("fileSize", fileSize);
		return "answerBoard/ans_board_view";
	}
	
	
	
	
	
}
