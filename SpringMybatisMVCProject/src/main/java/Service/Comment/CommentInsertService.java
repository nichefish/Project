package Service.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.DTO.AuthInfo;
import Model.DTO.CommentDTO;
import Model.DTO.ReplyDTO;
import Repository.Comment.CommentInsertRepository;

@Service
public class CommentInsertService {
	@Autowired
	private CommentInsertRepository commentInsertRepository;
	
	public void execute(String commentSubject, String commentContent, HttpSession session) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		System.out.println("userId:" + userId);
		CommentDTO dto = new CommentDTO(null, userId, null, commentSubject, commentContent);
		commentInsertRepository.commentInsert(dto);
	}

	public void replyInsert(String cUserId, Long commentNo, String replyContent, HttpSession session) {
		ReplyDTO dto = new ReplyDTO();
		dto.setcUserId(cUserId);
		dto.setCommentNo(commentNo);
		dto.setReplyContent(replyContent);
		String rUserId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		commentInsertRepository.replyInsert(dto);
	}
}
