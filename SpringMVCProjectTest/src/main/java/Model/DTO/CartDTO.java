package Model.DTO;

import java.sql.Timestamp;

public class CartDTO {
	Integer goodsSeq;
	String UserId;
	String GoodsName;
	Integer GoodsPrice;
	Integer GoodsQty;
	String GoodsImage;
	
	public Integer getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Integer goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public Integer getGoodsPrice() {
		return GoodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	public Integer getGoodsQty() {
		return GoodsQty;
	}
	public void setGoodsQty(Integer goodsQty) {
		GoodsQty = goodsQty;
	}
	public String getGoodsImage() {
		return GoodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		GoodsImage = goodsImage;
	}
}
