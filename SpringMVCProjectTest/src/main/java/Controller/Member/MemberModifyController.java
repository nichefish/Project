package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Service.Member.MemberDetailService;
import Service.Member.MemberModifyService;
import Validator.MemberModifyValidator;

@Controller
public class MemberModifyController {
	@Autowired
	private MemberDetailService memberDetailService;
	@Autowired
	private MemberModifyService memberModifyService;
	
	@RequestMapping(value="/member/memberModify")
	public String memberModify(@RequestParam(value="id") String userId, Model model) {
		memberDetailService.memberDetail(userId, model);
//		위에 서비스에서 이미.. MemberDTO를 갖고와서 model.addAttribute("member", member)를 한 상태다...
//		model.addAttribute("member", new MemberCommand());
		return "member/memberModify";
	}
	
	@RequestMapping(value="/member/memberModifyPro")
	public String memberModifyPro(MemberCommand memberCommand, Model model, Errors errors) {
		new MemberModifyValidator().validate(memberCommand, errors);
		if (errors.hasErrors()) {
			return "member/memberModify";			
		}
		Integer result = memberModifyService.memberModify(memberCommand, model);
		if (result == 0) {
			errors.rejectValue("userPw", "badPw");		// 에러 주입...
			return "member/memberModify";
		}
		return "redirect:/member/memberInfo/" + memberCommand.getUserId();
	}
}