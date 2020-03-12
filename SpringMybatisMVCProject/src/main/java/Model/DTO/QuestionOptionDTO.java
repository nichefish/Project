package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QuestionOptionDTO implements Serializable {
	private String question;
	private String option;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
}
