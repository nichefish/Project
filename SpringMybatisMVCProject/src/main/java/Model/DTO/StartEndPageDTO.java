package Model.DTO;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StartEndPageDTO implements Serializable {
	Integer startPage;
	Integer endPage;
	
	public StartEndPageDTO(Integer startPage, Integer endPage) {
		this.startPage = startPage;
		this.endPage = endPage;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
}