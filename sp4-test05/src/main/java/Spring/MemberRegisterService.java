package Spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDAO memberDAO;
	public MemberRegisterService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void regist(RegisterRequest req) {
		MemberDTO dto = memberDAO.selectByEmail(req.getEmail());
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterDate(new Date());
			memberDAO.insert(dto);;
			System.out.println("가입이 완료되었습니다.");
		} else {
			System.out.println("이미 가입된 이메일이 존재합니다.");
		}
	}
}
