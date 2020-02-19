package Service.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberListService {
	@Autowired
	private MemberDAO memberDAO;
	
	public void memberList(Model model) {
		List<MemberDTO> members = memberDAO.selectList();
		if (members != null) {
			model.addAttribute("members", members);
			model.addAttribute("count", memberDAO.count());		// 코드를 이런 식으로 가자고- 필요없는 코드 자꾸 적지 말자고-
		}
	}
}
