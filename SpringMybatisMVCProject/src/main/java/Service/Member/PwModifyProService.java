package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import Command.Member.ChangePwdCommand;
import Model.DTO.MemberDTO;
import Model.DTO.UserPwChangeDTO;
import Repository.Member.MemberDMLRepository;
import Repository.Member.MemberRepository;

@Service
public class PwModifyProService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@Autowired
	private MemberDMLRepository memberDMLRepository;
	
	public String execute(ChangePwdCommand changePwdCommand, Model model, Errors errors) {
		MemberDTO member = new MemberDTO();
		member.setUserId(changePwdCommand.getUserId());
		member = memberRepository.selectByUserId(member);
		if (bcryptPasswordEncoder.matches(changePwdCommand.getPw(), member.getUserPw())) {
			UserPwChangeDTO dto = new UserPwChangeDTO(changePwdCommand.getUserId(), changePwdCommand.getPw(), bcryptPasswordEncoder.encode(changePwdCommand.getNewPw()));
			memberDMLRepository.changePw(member);	// 마이바티스를 쓸라면.. 한개 덩어리밖에 못 날리니까. 결국 DTO를 한개 만들 수밖에 없다는.. 그런 느낌...
			return "redirect:/member/list";
		} else {
			errors.rejectValue("pw", "notCurrent");
			return "member/pwModify_1";
		}
	}
}
