package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Service.Member.PasswordModifyService;
import Validator.ChangePwdCommandValidator;

@Controller
public class PwModifyProController {
	@Autowired
	private PasswordModifyService passwordModifyService;
	
	@RequestMapping(value="/edit/pwModifyPro", method=RequestMethod.POST)
	public String pwModifyPro(ChangePwdCommand changePwdCommand, Errors errors) {
		System.out.println(changePwdCommand.getUserId());
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		if (errors.hasErrors()) {
			return "member/pwModify_1";
		}
		System.out.println("userId: " + changePwdCommand.getUserId());
		Integer result = passwordModifyService.updatePassword(changePwdCommand);
		if (result == 0) {
			errors.rejectValue("pw", "notCurrent");		// 이런식으로 바로 오류문구를 입력해줄 수도 있다...
			return "member/pwModify_1";
		}
		return "redirect:/member/list";
	}
}
