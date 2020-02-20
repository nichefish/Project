package Service.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
	
	public void authenticate(LoginCommand loginCommand, HttpSession session, Errors errors, HttpServletResponse response) {
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
		member.setUserPw(Encrypt.getEncryption(loginCommand.getPw()));
		Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId1());
		// Cookie rememberCookie = new Cookie("id_" + loginCommand.getId1() + "_" + i, loginCommand.getId1()); 요런식으로도...
		// 상품코드 이름으로 쿠키를 할당할라면.. 이런 식으로 이름에 변수이름을 넣으면 되는 거고... 쿠키 이름 안겹치게 짓는게 중요하다...
		if (loginCommand.getIdStore()) {		// 쿠키추가..
			rememberCookie.setMaxAge(60*60*24*30);	// 여기서 시간조절.. 필요에 따라 바꿔주면 된다.. 초단위...
		} else {
			rememberCookie.setMaxAge(0);		// 수명을 0으로 주니까 바로 삭제된다...
		}
		response.addCookie(rememberCookie);		// 쿠키 퍼알 생성; 껐다켜도 파일로 남아있으니까 적용된다...
		
		member = memberDAO.selectByUserId(member);
		try {	// member가 null일 때.. 즉 id가 존재하지 않을 때...
			authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), member.getUserName(), member.getUserPw());
			// 객체 만들고 setter 네 번 쓰는 대신. 객체 만들 때부터 생성자 이용해서 한 번에 초기화...
			if (authInfo.getPw().equals(Encrypt.getEncryption(loginCommand.getPw()))) {		// 비밀번호가 맞으면..
				Cookie autoLoginCookie = new Cookie("AutoLogin", loginCommand.getId1());		// 자동로그인 쿠키...
				response.addCookie(autoLoginCookie);
				session.setAttribute("authInfo",  authInfo);
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
