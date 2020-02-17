package Spring;

public class MemberInfoPrinter {
	private MemberDAO memberDAO = new MemberDAO();
	private MemberPrinter printer = new MemberPrinter();
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDAO.selectByEmail(email);
		if (dto == null) {
			System.out.println("데이터가 없습니다.\n");
			return;
		}
		printer.print(dto);
	}
}