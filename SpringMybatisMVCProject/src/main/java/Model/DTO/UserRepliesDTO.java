package Model.DTO;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class UserRepliesDTO implements Serializable {
	private MemberDTO memberDTO;
	List<ReplyDTO> replies;
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public List<ReplyDTO> getReplies() {
		return replies;
	}
	public void setReplies(List<ReplyDTO> replies) {
		this.replies = replies;
	}
}
