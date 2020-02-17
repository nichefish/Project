package Spring;

public class Assembler {		// 객체조립기...
	private MemberDAO memberDAO;
	private MemberPrinter printer;
	private MemberRegisterService mrs;
	private MemberListPrinter listPrint;
	private ChangePasswordService changePwSvc;
	private MemberInfoPrinter infoPrinter;
	
	public Assembler() {
		this.memberDAO = new MemberDAO();
		this.printer = new MemberPrinter();
		this.mrs = new MemberRegisterService(memberDAO);
		this.listPrint = new MemberListPrinter();
		this.changePwSvc = new ChangePasswordService();
		this.infoPrinter = new MemberInfoPrinter(memberDAO, printer);
	}
	
	// 생성자로 초기화하니까 setter는 필요없고. getter만 있으면 된다고-
	public MemberDAO getMemberDAO() {
		return memberDAO;
	}
	public MemberPrinter getPrinter() {
		return printer;
	}
	public MemberRegisterService getMrs() {
		return mrs;
	}
	public MemberListPrinter getListPrint() {
		listPrint.setMemberDAO(memberDAO);
		listPrint.setPrinter(printer);
		return listPrint;
	}
	public ChangePasswordService getChangePwSvc() {
		changePwSvc.setMemberDAO(memberDAO);
		return changePwSvc;
	}
	public MemberInfoPrinter getInfoPrinter() {
		return infoPrinter;
	}
}
