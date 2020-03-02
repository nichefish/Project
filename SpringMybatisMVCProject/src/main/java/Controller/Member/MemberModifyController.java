package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.MemberCommand;
import Service.Member.MemberModifyService;
import Validator.MemberModifyValidator;

@Controller
public class MemberModifyController {
	@Autowired
	private MemberModifyService memberModifyService;
	
	@RequestMapping(value="/edit/memberModifyPro", method=RequestMethod.POST)
	public String memberModifyPro(MemberCommand memberCommand, Model model, Errors errors) {
		new MemberModifyValidator().validate(memberCommand, errors);
		if (errors.hasErrors()) {
			return "member/memberModify";			
		}
		Integer result = memberModifyService.memberModify(memberCommand, model);
		if (result == 0) {
			errors.rejectValue("userPw", "badPw");
			return "/edit/memberModify?id=" + memberCommand.getUserId();
		} else {
			return "redirect:/edit/memberInfo/" + memberCommand.getUserId();
		}
	}
}
