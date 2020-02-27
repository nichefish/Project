package Service.Answer;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.Answer.AnswerCommand;
import Controller.Encrypt;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;
import Model.DTO.AuthInfo;

@Service
public class AnswerBoardReplyService {
	@Autowired
	private AnswerBoardDAO answerBoardDAO;
	public String replyWrite(AnswerCommand answerCommand, HttpSession session, HttpServletRequest request) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		dto.setUserId(authInfo.getId());
		dto.setBoardName(answerCommand.getBoardName());
		dto.setBoardPass(Encrypt.getEncryption(answerCommand.getBoardPass()));
		dto.setBoardSubject(answerCommand.getBoardSubject());
		dto.setBoardContent(answerCommand.getBoardContent());
		dto.setIpAddr(request.getRemoteAddr());
		dto.setBoardReRef(answerCommand.getBoardReRef());
//		System.out.println(dto.getboardReRef());
		dto.setBoardReLev(answerCommand.getBoardReLev());
		dto.setBoardReSeq(answerCommand.getBoardReSeq());
		Integer result = answerBoardDAO.insertReply(dto);
		String path = "";
		if (result == 1) {		// 제대로 DB에 삽입되었을 때..
			path = "answer/ans_board_list";
		} else {
			path = "answer/ans_board_reply";
		}
		return path;
	}
}
