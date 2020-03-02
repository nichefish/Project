package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Member.MemberDetailService;

@Controller
public class MemberDetailController {
	@Autowired
	private MemberDetailService memberDetailService;
	
	@RequestMapping("/edit/memberInfo/{aa}")
	public String memberInfo(@PathVariable("aa") String userId, Model model) {
//	public String memberInfo(@RequestParam(userId)) {	// ?쿼리스트링으로 날리면 이런 식으로 받으면 되는거고...
		try {
			memberDetailService.memberDetail(userId, model);
		} catch (Exception e) {
			System.out.println("익셉션!!!");
			return "redirect:/edit/memberList";
		}
		return "member/memberInfo";
	}
	
	@RequestMapping(value="/edit/memberModify")
	public String memberModify(@RequestParam(value="id") String userId, Model model) {
		memberDetailService.memberDetail(userId, model);
		return "member/memberModify";
	}
	
	
}
