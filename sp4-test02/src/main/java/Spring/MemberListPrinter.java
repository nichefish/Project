package Spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDAO memberDAO = new MemberDAO();
	private MemberPrinter printer = new MemberPrinter();
	public void printAll() {
		Collection<MemberDTO> lists = memberDAO.selectAll();
		System.out.println("총 사용자의 수: " + lists.size());
		for (MemberDTO dto : lists) {
			printer.print(dto);
		}
	}
}
