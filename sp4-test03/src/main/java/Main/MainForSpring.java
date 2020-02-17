package Main;

import java.util.Scanner;

import Spring.ChangePasswordService;
import Spring.MemberDAO;
import Spring.CachedMemberDAO;
import Spring.MemberInfoPrinter;
import Spring.MemberListPrinter;
import Spring.MemberPrinter;
import Spring.MemberRegisterService;
import Spring.RegisterRequest;

public class MainForSpring {
	private static MemberDAO memberDAO = new MemberDAO();
//	private static MemberDAO memberDAO = new CachedMemberDAO(); // 요런식으로.. 콘트롤러(메인) 한 군데에서 의존객체를 다 주면.. 유지보수가 쉬워진단 얘기...
	// 그래서 의존객체를 모아놓는 데가 따로 있고.. 그걸 DI.. 라고 한다는 듯..
	private static MemberPrinter printer = new MemberPrinter();
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("명령어를 입력하세요.");
			Scanner sc = new Scanner(System.in);
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			} else if (command.startsWith("new ")) {
				String [] arg = command.split(" ");
				if (arg.length != 5) {
					printHelp();
					continue;
				}
				RegisterRequest req = new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if (!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				MemberRegisterService mrs = new MemberRegisterService(memberDAO);	// Main에서 서비스로 의존객체(DAO) 주입... (생성자..)
				mrs.regist(req);
			} else if (command.equals("list")) {
				MemberListPrinter listPrint = new MemberListPrinter();
				listPrint.setPrinter(printer);								// Main에서 서비스로 의존객체(MemberPrinter) 주입... (Setter...)
				listPrint.printAll();
			} else if (command.startsWith("change ")) {
				String [] arg = command.split(" ");
				if (arg.length != 4) {
					printHelp();
					continue;
				}
				ChangePasswordService changePwSvc = new ChangePasswordService();
				changePwSvc.changePw(arg[1], arg[2], arg[3]);	
			} else if (command.startsWith("info ")) {
				String [] arg = command.split(" ");
				if (arg.length != 2) {
					printHelp();
					continue;
				}
				MemberInfoPrinter infoPrinter = new MemberInfoPrinter(memberDAO, printer);	// Main에서 서비스로 의존객체(DAO, MemberPrinter) 주입... (생성자..)
				infoPrinter.printMemberInfo(arg[1]);
				
			} else {
				printHelp();
			}
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
	}
}
