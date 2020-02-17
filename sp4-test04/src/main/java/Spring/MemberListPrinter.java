package Spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDAO memberDAO;
	private MemberPrinter printer;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
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
