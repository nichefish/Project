package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.LoginCommand;
import Controller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

@Service
public class AuthService {
	@Autowired
	private MemberDAO memberDAO;
	private AuthInfo authInfo;			// 굳이 의존객체로 만들 필요 없을 거 같은데...
	
	public void authenticate(LoginCommand loginCommand, HttpSession session, Errors errors) {
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		member.setUserId(Encrypt.getEncryption(loginCommand.getPw()));
		member.setUserId(loginCommand.getId1());
		member = memberDAO.selectByUserId(member);
		try {	// member가 null일 때.. 즉 id가 존재하지 않을 때...
			authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), member.getUserName(), member.getUserPw());
			// 객체 만들고 setter 네 번 쓰는 대신. 객체 만들 때부터 생성자 이용해서 한 번에 초기화...
			if (authInfo.getPw().equals(Encrypt.getEncryption(loginCommand.getPw()))) {		// 비밀번호가 맞으면..
				session.setAttribute("authInfo",  authInfo);								// 로그인 정보 세션에 저장...
			} else {
				System.out.println("비밀번호가 틀립니다.");
				errors.rejectValue("pw", "wrong");
			}
		} catch (NullPointerException e) {
			System.out.println("아이디가 없습니다.");
			errors.rejectValue("id1", "notId");
		}
		
			
		
		
	}
	public void detailInfo(LoginCommand loginCommand) {
		
	}

}
