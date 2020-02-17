package Spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	@Autowired
//	@Resource(name="MemberDAO")
	private MemberDAO memberDAO;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	@Autowired
	@Qualifier("sysout")	
	// 클래스 선언변수가 하나 이상 있어서. 싱글톤이 아닐때. 변수가 두 개일 때. 거기서 선언한 이름name으로 갖다쓰는 거...?
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printAll() {
		Collection<MemberDTO> lists = memberDAO.selectAll();
		System.out.println("총 사용자의 수: " + lists.size());
		for (MemberDTO dto : lists) {
			printer.print(dto);
		}
	}
}
