package Service.Member;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Controller.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

@Service
public class MemberModifyService {
	@Autowired
	private MemberDAO memberDAO;
	
	public Integer memberModify(MemberCommand memberCommand, Model model) {
		MemberDTO member = new MemberDTO();		// DTO는 의존객체로 잘 사용 안한다고...
		member.setUserId(memberCommand.getUserId());
		member.setUserPw(Encrypt.getEncryption(memberCommand.getUserPw()));
		member.setUserEmail(memberCommand.getUserEmail());
		member.setUserAddr(memberCommand.getUserAddr());
		member.setUserPh1(memberCommand.getUserPh1());
		member.setUserPh2(memberCommand.getUserPh2());
		Integer result = memberDAO.modifyMember(member);
		System.out.println(result);
		return result;
	}

}
