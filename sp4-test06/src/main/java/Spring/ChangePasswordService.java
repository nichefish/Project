package Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
//	자동주입 받는 애가 아니면 전부 이 autowired 위에 있어야 된다..
	int i;
//	@Autowired
//	멤버필드 위에 주면. 요 밑에는 전부 다 적용된다...
	private MemberDAO memberDAO;
	@Autowired
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

//	setter위에다 줄려면. setter마다 전부 줘야 된다... setter만 있을 때면 저 위 멤버필드 위에 주는 게 낫고.. 생성자랑 섞여있으면 안됨...

	public void changePw(String email, String oldPw, String newPw) {
		MemberDTO dto = memberDAO.selectByEmail(email);
		if (dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDAO.update(dto);
		System.out.println("비밀번호가 변경되었습니다.");
	}
}
