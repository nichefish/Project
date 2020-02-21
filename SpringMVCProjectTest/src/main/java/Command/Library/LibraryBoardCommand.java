package Command.Library;

public class LibraryBoardCommand {
//	BoardCommand boardCommand;	요런식으로 할 수도 있다고- 이게 더 응용적인 방법- 요 객체애 대한 getter and setter 만들어주고-
//	스프링에서는 jsp에서 필드객체.. boardCommand.boardPass 요런식으로 써주면 들어간다고...
	String boardName;
	String boardPass;
	String boardSubject;
	String boardContent;
	
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
}
