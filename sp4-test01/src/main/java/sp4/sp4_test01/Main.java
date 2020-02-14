package sp4.sp4_test01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContxt.xml");
//		기존방식= 
//		Greeter gt = new Greeter();
//		gt.setFormat(format);
		Greeter gt = ctx.getBean("greeter", Greeter.class);
		String msg = gt.greet("이숭무");
		System.out.println(msg);
		System.out.println(String.format("%d %s 입니다.", 10, "이숭무"));
		ctx.close();
		
	}
}
