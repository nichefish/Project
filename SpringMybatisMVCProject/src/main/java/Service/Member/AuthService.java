package Service.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.LoginCommand;
import Controller.Encrypt;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Repository.Member.LoginRepository;

@Service
public class AuthService {
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	
	public void authenticate(LoginCommand loginCommand, HttpSession session, Errors errors, HttpServletResponse response) {
		MemberDTO member = new MemberDTO();
		member.setUserId(loginCommand.getId1());
//		member.setUserPw(Encrypt.getEncryption(loginCommand.getPw()));	// 같은 111이면 같은 암호화..
//		member.setUserPw(bcryptPasswordEncoder.encode(loginCommand.getPw()));	// 같은 111이라도 다른 암호로 바꿈...
		Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId1());
		// Cookie rememberCookie = new Cookie("id_" + loginCommand.getId1() + "_" + i, loginCommand.getId1()); 요런식으로도...
		// 상품코드 이름으로 쿠키를 할당할라면.. 이런 식으로 이름에 변수이름을 넣으면 되는 거고... 쿠키 이름 안겹치게 짓는게 중요하다...
		if (loginCommand.getIdStore()) {		// 쿠키추가..
			rememberCookie.setMaxAge(60*60*24*30);	// 여기서 시간조절.. 필요에 따라 바꿔주면 된다.. 초단위...
		} else {
			rememberCookie.setMaxAge(0);		// 수명을 0으로 주니까 바로 삭제된다...
		}
		response.addCookie(rememberCookie);		// 쿠키 퍼알 생성; 껐다켜도 파일로 남아있으니까 적용된다...
		System.out.println("!@#!@# 이 로그인리포지토리가 문제구만...");
		member=loginRepository.selectByUserId(member);
		if (member == null) {
			errors.rejectValue("id1","notId");	
		} else {
			if (bcryptPasswordEncoder.matches(loginCommand.getPw() , member.getUserPw())) {
				AuthInfo authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), member.getUserName(), member.getUserPw());
				Cookie autoLoginCookie = new Cookie("AutoLogin", loginCommand.getId1());		// 자동로그인 쿠키...
				response.addCookie(autoLoginCookie);
				session.setAttribute("authInfo",authInfo);
			} else {
				errors.rejectValue("pw","wrong");
			}
		}
	}
	public void detailInfo(LoginCommand loginCommand) {
		
	}

}
