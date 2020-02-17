package Main;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import Spring.ChangePasswordService;
import Spring.MemberInfoPrinter;
import Spring.MemberListPrinter;
import Spring.MemberRegisterService;
import Spring.RegisterRequest;
import Spring.VersionPrinter;

public class MainForSpring2 {
//	static Assembler assembler = new Assembler();  // 요거를 xml에 매핑한 게 밑에 꺼...
	private static GenericXmlApplicationContext ctx;
	
	public static void main(String[] args) {
		String [] conf = {"classpath:appCtx1.xml", "classpath:appCtx2.xml"};
		ctx = new GenericXmlApplicationContext(conf);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("명령어를 입력하세요.");
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
				MemberRegisterService mrs = ctx.getBean("mrs", MemberRegisterService.class);
				mrs.regist(req);
			} else if (command.equals("list")) {
				MemberListPrinter listPrint = ctx.getBean("listPrint", MemberListPrinter.class);
				listPrint.printAll();
			} else if (command.startsWith("change ")) {
				String [] arg = command.split(" ");
				if (arg.length != 4) {
					printHelp();
					continue;
				}
				ChangePasswordService changePwSvc = ctx.getBean("changePwSvc", ChangePasswordService.class);
				changePwSvc.changePw(arg[1], arg[2], arg[3]);	
			} else if (command.startsWith("info ")) {
				String [] arg = command.split(" ");
				if (arg.length != 2) {
					printHelp();
					continue;
				}
				MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
				infoPrinter.printMemberInfo(arg[1]);
			} else if (command.equals("version")) {
				VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
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
		System.out.println("version");
	}
}
