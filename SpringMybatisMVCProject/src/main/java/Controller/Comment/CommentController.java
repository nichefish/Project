package Controller.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Comment.CommentInsertService;
import Service.Comment.CommentListService;
import Service.Comment.CommentUserService;

@Controller
public class CommentController {
	@Autowired
	private CommentInsertService commentInsertService;
	@Autowired
	private CommentUserService commentUserService;
	@Autowired
	private CommentListService commentListService;
	
	// spring-context에 mvc:controller 주소-뷰(=@RequestMapping) 설정함... "commentForm"까지...
	@RequestMapping(value="/comment/comment_insert", method=RequestMethod.POST)
	public String commentInsert(@RequestParam(value="commentSubject") String commentSubject, @RequestParam(value="commentContent") String commentContent, HttpSession session) {
		commentInsertService.execute(commentSubject, commentContent, session);
		return "redirect:/comment/comment_list";
	}
	
	@RequestMapping(value="/comment/comment_list", method=RequestMethod.GET)
	public String commentList(Model model) {
		commentListService.execute(model);
		return "comment/comment_list";
	}
	
	@RequestMapping("/comment/commentDetail")
	public String Comment(@RequestParam(value="num") Long commentNo, Model model) {
		commentUserService.execute(model, commentNo);
		return "comment/comment_collection";
	}
	
	@RequestMapping(value="/comment/replyInsert")
	public String replyInsert(@RequestParam(value="cUserId") String cUserId, @RequestParam(value="commentNo") Long commentNo, @RequestParam(value="replyContent") String replyContent, Model model, HttpSession session) {
		commentInsertService.replyInsert(cUserId, commentNo, replyContent, session);
		return "redirect:/comment/commentDetail?num=" + commentNo;
	}
}
