package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserPwChangeDTO implements Serializable {
	private String userId;
	private String pw;
	private String newPw;
	
	public UserPwChangeDTO(String userId, String pw, String newPw) {
		this.userId = userId;
		this.pw = pw;
		this.newPw = newPw;
	}
}
