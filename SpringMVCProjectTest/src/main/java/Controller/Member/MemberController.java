package Controller.Member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Service.Member.MemberJoinService;
import Validator.MemberCommandValidator;

@Controller
public class MemberController {
	@Autowired
	private MemberJoinService memberJoinService;
	// 자바에서는 setter나 생성자가 필요했었는데. 웹에서는 @Controller가 있을 경우에는 setter나 생성자가 필요없다... 암시적으로 만들어진다고...

	// if..else로 다 묶여있는 게 아니라. 각각의 매핑별로 따로따로... 따로따로 떼어놓을 수 있게 되는 거다.. 컨트롤러 여러개 생성가능...
	@RequestMapping("/register/agree")	// 회원가입 :: 약관동의
	public String agree() {
		return "member/agree";
		// ...결과적으로 보면 실제 member/agree.jsp를 register/agree 주소에 매핑한 셈이다.. 예전 Controller 쓰던거랑 원리는 똑같음...
	}
	@RequestMapping("/register/regist")	// 회원가입 :: form
//	public String memberForm(@RequestParam(value="agree", defaultValue="false") boolean agree, MemberCommand memberCommand) {
	public String memberForm(@RequestParam(value="agree", defaultValue="false") boolean agree, Model model) {
		// memberCommand 객체를 초기에 주는 방식이 두 가지가 있다... 아무거나 쓰면 됨...
		if (!agree) {
			return "member/agree";
		} else {
			model.addAttribute("memberCommand", new MemberCommand());
			return "member/memberForm";
		}
	}
	@RequestMapping(value="/register/memberJoinAction", method=RequestMethod.POST)	// 회원가입 :: submit
	// 주소는 같은데 get/post 방식이 다를 때. POST방식일 때만 이걸로 받겠다.. 뭐 이런 얘기...
	public String memberJoin(MemberCommand memberCommand, Errors errors) {
		// @RequestParam 대신 MemberCommand 객체로 받겠다.. 이런 얘기... 뷰 페이지하고 같아야 되는 게 커맨드 객체... parameter name이랑 같아야 되는...
		// MemberJoinService memberJoinService = new MemberJoinService(); 할 건데.. 의존객체 주입... 위에다가 멤버필드 선언하고 @Autowired....
		new MemberCommandValidator().validate(memberCommand, errors);	// 에러 검사...
		if (errors.hasErrors()) {		// 에러가 발생했다면...
			return "member/memberForm";		// 가입신청 form으로 돌려보냄...
		}
		Integer i = 0;
		try {
			i = memberJoinService.execute(memberCommand);		// DB에 insert시 row수가 반환되니까.. 그거 확인...
			System.out.println(i);
			return "member/memberWelcome";		// 커맨드객체는 이 페이지로 고스란히 전달이 된다...${} 식으로 받아올 수 있다...
		} catch(Exception e) {
			errors.rejectValue("userId", "duplicate");		// DB에 등록 안할 때 
			return "member/memberForm";
		}
	}
//	@RequestMapping(value="/register/memberJoinAction", method=RequestMethod.GET)	// 회원가입 :: submit
//	// 주소는 같은데 get/post 방식이 다를 때. GET방식일 때만 이걸로 받겠다.. 뭐 이런 얘기...
//	public String memberJoinGet() {
//		return "redirect:agree";
//	}
	
	
	
	
}
