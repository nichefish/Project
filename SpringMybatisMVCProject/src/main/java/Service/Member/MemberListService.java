package Service.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

public class MemberListService {
	@Autowired
	MemberRepository memberRepository;
	
	public void memberList(Model model, Integer page) {
		int limit = 10;			// 한페이지 몇 행씩 출력한 건지-
		int limitPage = 10;			// 페이지주소를 몇 개씩 출력할 건지-
		int nowPage = 1;
		if (page != null) {
			nowPage = page;
		}
		List<MemberDTO> lists = memberRepository.getMemberList(nowPage, limit);
		model.addAttribute("lists", lists);
		int count = memberRepository.getListCount();
		int maxPage = (int)((double)count/limit + 0.95);	// 총 페이지.. ex.88.. 최소한 1부터 시작해야 되는 그런..
		int startPage = (int)(((double)nowPage/limitPage + 0.9)-1)*limitPage + 1;		// 밑에 열개 중에 첫번째꺼... 1, 11, 21.. 요런거...
		System.out.println(startPage);
		int endPage = startPage + limitPage - 1;		// 밑에 열개 중에 마지막꺼.. 10, 20, 30... 요런거...
		if (endPage > maxPage) {			// 총 페이지만큼만 표시하겠다.. 뭐 이런 얘기..
			endPage = maxPage;
		}
		model.addAttribute("lists", lists);
		model.addAttribute("count", count);		// 코드를 이런 식으로 가자고- 필요없는 코드 자꾸 적지 말자고-
		model.addAttribute("page", nowPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
	}
}
