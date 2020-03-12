package Model.DTO;

public class CartRemove {
	private Long [] goodsSeqs;
	private String userId;
	
	public Long[] getGoodsSeqs() {
		return goodsSeqs;
	}
	public void setGoodsSeqs(Long[] goodsSeqs) {
		this.goodsSeqs = goodsSeqs;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
