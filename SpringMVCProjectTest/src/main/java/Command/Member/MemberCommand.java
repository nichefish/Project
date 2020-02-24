package Command.Member;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberCommand {
	private String userId;
	private String userPw;
	private String userPwCon;
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd")		// 요런식으로.. 간단하게 포맷 설정..
	private Date userBirth;
	private String userGender;
	private String userEmail;
	private String userAddr;
	private String userPh1;
	private String userPh2;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserPwCon() {
		return userPwCon;
	}
	public void setUserPwCon(String userPwCon) {
		this.userPwCon = userPwCon;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserPh1() {
		return userPh1;
	}
	public void setUserPh1(String userPh1) {
		this.userPh1 = userPh1;
	}
	public String getUserPh2() {
		return userPh2;
	}
	public void setUserPh2(String userPh2) {
		this.userPh2 = userPh2;
	}
	
	public boolean isUserPwEqualToUserPwCon() {
		if (userPw.equals(userPwCon)) {
			return true;
		}
		return false;
	}
	
	
	
	
}
