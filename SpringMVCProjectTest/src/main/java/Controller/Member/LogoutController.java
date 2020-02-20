package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/logout")		// 이렇게 위에다가 썼을 때는 무조건 메소드(GET/POST)가 나뉘는게 있어야 된다...
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		Cookie autoLoginCookie = new Cookie("AutoLogin", "1111");		// 세션 지우기 전에 해야된다..
		autoLoginCookie.setMaxAge(0);								// 자동로그인 쿠키 삭제... 안하면 로그아웃 안됨.. 
		response.addCookie(autoLoginCookie);
		session.invalidate();
		return "redirect:/main";
	}
}
