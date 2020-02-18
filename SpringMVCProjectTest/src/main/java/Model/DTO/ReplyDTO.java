package Model.DTO;

import java.sql.Timestamp;

public class ReplyDTO {
	Integer boardNum;
	Integer replyNum;
	String userId;
	String replyName;
	String replyContent;
	String replyPass;
	Timestamp replydDate;
	String ipAddr;
	
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public Integer getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public String getReplyPass() {
		return replyPass;
	}
	public void setReplyPass(String replyPass) {
		this.replyPass = replyPass;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Timestamp getReplydDate() {
		return replydDate;
	}
	public void setReplydDate(Timestamp replydDate) {
		this.replydDate = replydDate;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	Integer readCount;
}
