package Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	private MemberDAO memberDAO;
	private MemberPrinter printer;
	
//	생성자일 경우 무조건 생성자 위에 적어야 된다.
	@Autowired
	public MemberInfoPrinter(MemberDAO memberDAO, MemberPrinter printer) {
		this.memberDAO = memberDAO;
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		MemberDTO dto = memberDAO.selectByEmail(email);
		if (dto == null) {
			System.out.println("데이터가 없습니다.\n");
			return;
		}
		printer.print(dto);
	}
}