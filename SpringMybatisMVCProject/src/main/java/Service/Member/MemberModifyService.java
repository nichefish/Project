package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;
import Repository.Member.MemberDMLRepository;
import Repository.Member.MemberRepository;

@Service
public class MemberModifyService {
	@Autowired
	private MemberDMLRepository memberDMLRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	public Integer memberModify(MemberCommand memberCommand, Model model) {
		MemberDTO dto = new MemberDTO();
		System.out.println(memberCommand.getUserId());
		dto.setUserId(memberCommand.getUserId());
		System.out.println("original pw..:" + dto.getUserId());
		MemberDTO member = memberRepository.selectByUserId(dto);
		if (bcryptPasswordEncoder.matches(memberCommand.getUserPw(), member.getUserPw())) {
			System.out.println("!!@#!@#");
			dto.setUserName(memberCommand.getUserName());
			dto.setUserGender(memberCommand.getUserGender());
//			dto.setUserBirth(new Timestamp(memberCommand.getUserBirth().getTime()));	// 요런식으로 쓰는 거... 좀 외워놓기... 볼때마다 헷갈..
			dto.setUserEmail(memberCommand.getUserEmail());
			dto.setUserAddr(memberCommand.getUserAddr());
			dto.setUserPh1(memberCommand.getUserPh1());
			dto.setUserPh2(memberCommand.getUserPh2());
			return memberDMLRepository.memberUpdate(dto);
		}
		return 0;
	}
}
