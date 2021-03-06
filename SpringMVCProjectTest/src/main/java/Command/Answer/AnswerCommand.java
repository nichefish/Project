package Command.Answer;

import org.springframework.web.multipart.MultipartFile;

public class AnswerCommand {
	private Integer boardNum;
	private String boardName;
	private String boardPass;
	private String boardSubject;
	private String boardContent;
//	private MultipartFile report;	//	하나만 저장될 수도 있고. jsp에서 multiple="multiple" 줬으면. 배열이 된다...
	private MultipartFile[] boardFile;
	
	private Integer boardReRef;
	private Integer boardReLev;
	private Integer boardReSeq;
	
	public Integer getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardPass() {
		return boardPass;
	}
	public void setBoardPass(String boardPass) {
		this.boardPass = boardPass;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public MultipartFile[] getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile[] boardFile) {
		this.boardFile = boardFile;
	}
	public Integer getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(Integer boardReRef) {
		this.boardReRef = boardReRef;
	}
	public Integer getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(Integer boardReLev) {
		this.boardReLev = boardReLev;
	}
	public Integer getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(Integer boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
}
