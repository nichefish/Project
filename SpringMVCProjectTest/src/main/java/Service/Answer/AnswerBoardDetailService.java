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
	
	public String detailView(Integer boardNum, Model model) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setBoardNum(boardNum);
		dto = answerBoardDAO.selectByBoardNum(dto);
		model.addAttribute("board", dto);
		return "answerBoard/ans_board_view";
	}
}
