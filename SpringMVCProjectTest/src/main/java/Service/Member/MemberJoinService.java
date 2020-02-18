package Service.Member;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Controller.Encrypt;
import Controller.Member.MemberCommand;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

@Service
public class MemberJoinService {
	@Autowired
	private MemberDAO memberDAO;
	// 얘도 주입객체인데. 웹에서는 @Service가 있을 경우에 또 setter나 생성자가 필요없다... 이것도.. 암시적으로 만들어진다고...
	
	
	public Integer execute(MemberCommand memberCommand) {
		Integer result = 0;
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserPw(Encrypt.getEncryption(memberCommand.getUserPw()));
		memberDTO.setUserName(memberCommand.getUserName());
		Date date = null;
		try {
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
			date = dt.parse(memberCommand.getUserBirth());
			Timestamp userBirth = new Timestamp(date.getTime());
			memberDTO.setUserBirth(userBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		result = memberDAO.insertMember(memberDTO);
		return result;
	}
}