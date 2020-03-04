package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;

@Service
public class PwModifyService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public String execute(MemberCommand memberCommand, ChangePwdCommand changePwdCommand, Model model, Errors errors) {
		MemberDTO member = new MemberDTO();
		member.setUserId(memberCommand.getUserId());
		member = loginRepository.selectByUserId(member);
		if (bcryptPasswordEncoder.matches(memberCommand.getUserPw(), member.getUserPw())) {
			 changePwdCommand.setUserId(memberCommand.getUserId());
			 model.addAttribute("ChangePwdCommand", changePwdCommand);
			return "member/pwModify_1";
		} else {
			errors.rejectValue("userPw", "badPw");
			return "member/pwModify";
		}
	}
}
