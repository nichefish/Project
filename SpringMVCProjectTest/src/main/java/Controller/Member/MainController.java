package Controller.Member;

import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;
import Command.Member.MemberCommand;
	
@Controller
@RequestMapping("/main")
public class MainController {
	@RequestMapping(method=RequestMethod.GET)	// GET 방식일 때만 오는 페이지..
//	public String form() {
	public String form(LoginCommand loginCommand, @CookieValue(value="REMEMBER", required=false) Cookie rememberCookie) {
		if (rememberCookie != null) {
			loginCommand.setId1(rememberCookie.getValue());
			loginCommand.setIdStore(true);
		}
		return "main";
	}
}
