package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Member.MemberDeleteService;

@Controller
public class MemberDeleteController {
	@Autowired
	private MemberDeleteService memberDeleteService;
	
	@RequestMapping("/edit/memberInfoDel")
	public String memberDelete(@RequestParam(value="id") String userId) {
		memberDeleteService.memberDelete(userId);
		return "redirect:/member/list";
	}
}
