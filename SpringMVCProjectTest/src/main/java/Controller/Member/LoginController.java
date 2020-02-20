package Controller.Member;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;
import Service.Member.AuthService;
import Validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")	// 위에다 이렇게 선언하면, 밑에다가 value 갑을 써줄 필요가 없다고...
public class LoginController {
	@Autowired
	private AuthService authService;
	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		// GET방식으로 들어온다는 거는 걍 주소쳐서 들어온다는 얘기니까.. 그렇게 들어오면 안 되니까.. 메인으로 리다이렉트시키면 된다..
		// 근데 메인페이지가 열릴 떄 커맨드객체가 필요하니까- 익셉션이 떠버리니까- 안 뜰라면 커맨드객체를 생성해줘야 된다...
		return "redirect:/main";	// 요런 식으로 하면  커맨드객체는 리퀘스트에 담겨서 가는 거라. 리다이렉트하면 못 받고...
//		return "main";	// 요런 식으로 jsp 파일로 명시해주면. 인자로 받은 커맨드객체도 들어간다고.... 요럴때는 context에 컨트롤러만으로도 충분하고...
	}
	@RequestMapping(method=RequestMethod.POST)	// 
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		authService.authenticate(loginCommand, session, errors, response);
		if (errors.hasErrors()) {
			return "main";
		}
		return "main";
	}
}
