package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;
import Service.Member.PwModifyService;

@Controller
@RequestMapping("/edit/changePassword")
public class MemberPasswordController {
	@Autowired
	private PwModifyService pwModifyService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String form(MemberCommand memberCommand) {
		return "member/pwModify";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(MemberCommand memberCommand, Errors errors, ChangePwdCommand changePwdCommand, Model model) {
		return pwModifyService.execute(memberCommand, changePwdCommand, model, errors);
	}
	
	
	
	
	
}
