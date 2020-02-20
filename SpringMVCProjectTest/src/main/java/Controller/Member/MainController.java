package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;
import Service.Member.MainService;
	
@Controller
@RequestMapping("/main")
public class MainController {
	@Autowired
	private MainService mainService;
	
	@RequestMapping(method=RequestMethod.GET)	// GET 방식일 때만 오는 페이지..
//	public String form() {
	public String form(LoginCommand loginCommand, @CookieValue(value="AutoLogin", required=false) Cookie autoLoginCookie, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie, HttpSession session) {
		if (rememberCookie != null) {
			loginCommand.setId1(rememberCookie.getValue());
			loginCommand.setIdStore(true);
		}
		if (autoLoginCookie != null) {
			mainService.autoLogin(autoLoginCookie.getValue(), session);
		}
		return "main";
	}
}
