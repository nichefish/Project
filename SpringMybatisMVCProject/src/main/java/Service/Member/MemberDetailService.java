package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;
import Repository.Member.MemberRepository;

@Service
public class MemberDetailService {
	@Autowired
	private MemberRepository memberRepository;
	
	public MemberDTO memberDetail(String userId, Model model) {
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		member = memberRepository.selectByUserId(member);
		model.addAttribute("memberCommand", member);
		return member;
	}
}
