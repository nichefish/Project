package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Service.Member.MemberJoinService;
import Service.Member.MemberRegMailService;
import Validator.MemberCommandValidator;

@Controller
public class MemberController {
	@Autowired
	private MemberJoinService memberJoinService;

	// 자바에서는 setter나 생성자가 필요했었는데. 웹에서는 @Controller가 있을 경우에는 setter나 생성자가 필요없다... 암시적으로 만들어진다고...

	@RequestMapping("/register/agree")
	public String agree() {
		return "member/agree";
	}
	
	@RequestMapping(value="/register/regist", method=RequestMethod.POST)
	public String memberForm(@RequestParam(value="agree", defaultValue="false") Boolean agree, MemberCommand memberCommand) {
		if (!agree) {
			return "member/agree";
		}
		return "member/memberForm";
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
		String i = null;
		try {
			i = memberJoinService.execute(memberCommand, errors);		// DB에 insert시 row수가 반환되니까.. 그거 확인...
		} catch(Exception e) {
			errors.rejectValue("userId", "duplicate");		// DB에 등록 안할 때 
		}
		return i;
	}
	
	@RequestMapping("/memberMail")
	public String memberMail(@RequestParam(value="num") String num, @RequestParam(value="receiver") String receiver, @RequestParam(value="userId") String userId) {
		Integer result = memberJoinService.numUpdate(num, receiver, userId);
		if (result > 0) {
			return "member/success";
		} else {
			return "member/fail";
		}
	}
}
