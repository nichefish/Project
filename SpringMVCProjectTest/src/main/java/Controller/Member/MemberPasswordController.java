package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.MemberCommand;
import Model.DTO.MemberDTO;
import Service.Member.PwModifyService;

@Controller
@RequestMapping(value="/edit/changePassword")
public class MemberPasswordController {
	@Autowired
	PwModifyService pwModifyService;
// 주소 직접 쳐서 들어오는 게 GET방식.. 주소만 쳐서 들어오면 안 되게 막을 때 이런 식으로 한다... 딴 데로 바로 보내는 식으로...
//	public String memPw(@RequestParam(value="userId") String userId, Model model) {
//	이렇게 쓰는 대신 아랫줄처럼 바로 model로 받아오는 식으로 쓰는 방식.. Controller에서만 되고 Service에서는 안 된다고...
//	public String memPw(@ModelAttribute("userId") String userId) {
	@RequestMapping(method=RequestMethod.GET)
	public String memPw(MemberCommand memberCommand) {
//		model.addAttribute("userId", userId);		
		return "member/pwModify";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String changePw(MemberCommand memberCommand, Errors errors) {
		MemberDTO member = pwModifyService.execute(memberCommand);
		// id와 일치하는 member객체를 받아온 건데...
		if (member == null) {		// 비밀번호가 불일치하면. 처음pw입력창으로 돌려보내고...
			errors.rejectValue("userPw", "badPw");
			return "member/pwModify";
		}
		return "member/pwModify_1";		// 비밀번호가 일치하면. 두 번째 pw입력창(pw변경창)으로 이동하고...
		
	}
	
	
}
