package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

@Service
public class MainService {
	@Autowired
	private MemberDAO memberDAO;
	
	public void autoLogin(String userId, HttpSession session) {
		MemberDTO member = new MemberDTO();
		member.setUserId(userId);
		memberDAO.selectByUserId(member);
		AuthInfo authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), member.getUserName(), member.getUserPw());
		session.setAttribute("authInfo",  authInfo);
		
	}
}
