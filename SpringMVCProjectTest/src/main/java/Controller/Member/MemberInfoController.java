package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Member.MemberDetailService;

@Controller
public class MemberInfoController {
	@Autowired
	private MemberDetailService memberDetailService;
	
	@RequestMapping("/edit/memberInfo/{aa}")
	public String memberInfo(@PathVariable("aa") String userId, Model model) {
//	public String memberInfo(@RequestParam(userId)) {	// ?쿼리스트링으로 날리면 이런 식으로 받으면 되는거고...
		try {
			memberDetailService.memberDetail(userId, model);
		} catch (Exception e) {
			return "redirect:/edit/memberList";
		}
		return "member/memberInfo";
	}
}
