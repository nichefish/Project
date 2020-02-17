package Spring;

public class ChangePasswordService {
	private MemberDAO memberDAO = new MemberDAO();
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
