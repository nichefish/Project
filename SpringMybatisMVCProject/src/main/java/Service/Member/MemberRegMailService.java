package Service.Member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MemberRegMailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String receiver, String userId) {
		MimeMessage msg = mailSender.createMimeMessage();	// 메세지를 차곡차곡 쌓아서 보내는 거라고...
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		String content = "<html><body>안녕하세요. '" + userId + "'님 가입을 환영합니다.<br />아래 링크를 눌러야 가입이 완료됩니다.<br />"
				+ "<a href='http://192.168.4.113:8080/SpringMybatisMVCProject/memberMail?num= " + num + "&receiver=" + receiver + "&userId=" + userId + "'>"
				+ "<strong><b>가입을 완료하시려면 여기를 눌러주세요.</b></strong></body></html>";
		String subject = "가입환영인사";
		try {
			msg.setHeader("content-type", "text/html; charset=UTF-8");
			msg.setContent(content, "text/html; charset=UTF-8");
			msg.setSubject(subject);
			msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiver));
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
