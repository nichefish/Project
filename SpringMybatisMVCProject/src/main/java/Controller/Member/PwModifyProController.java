package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Service.Member.PwModifyProService;

@Controller
public class PwModifyProController {
	@Autowired
	private PwModifyProService pwModifyProService;
	
	@RequestMapping(value="/edit/pwModifyPro", method=RequestMethod.POST)
	public String pwModifyPro(ChangePwdCommand changePwdCommand, Model model, Errors errors) {
		return pwModifyProService.execute(changePwdCommand, model, errors);
	}
}
