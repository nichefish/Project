package Model.DTO;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Question implements Serializable {
	private String title;
	private List<String> options;		// 설문조사 질문들의 리스트... 길이가 다 다르니깐 배열로는 불가능...
	
	public Question() {}
	public Question(String title) {
		this.title = title;
	}
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
