package Spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {
	private MemberDAO memberDAO;
	private MemberPrinter printer;
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	@Autowired
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
