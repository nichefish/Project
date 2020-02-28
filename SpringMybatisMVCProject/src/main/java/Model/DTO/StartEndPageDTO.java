package Model.DTO;

public class StartEndPageDTO {
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