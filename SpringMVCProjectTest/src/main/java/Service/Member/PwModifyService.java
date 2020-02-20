package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.MemberCommand;
import Controller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

@Service
public class PwModifyService {
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberDTO execute(MemberCommand memberCommand) {
		MemberDTO member = new MemberDTO();		// DTO는 의존객체로 잘 사용 안한다고...
		member.setUserId(memberCommand.getUserId());
		member.setUserPw(Encrypt.getEncryption(memberCommand.getUserPw()));
		member = memberDAO.selectByUserId(member);
		// 여기 서비스에서 에러처리 못함.. 에러처리는 (페이지지에 변경사항을 주는 거니까..) 콘트롤러 가서 해야 된다...
		return member;
	}
	
}
