package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class CartDTO implements Serializable {
	Long cartNum;
	Long goodsSeq;
	String UserId;
	String GoodsName;
	Long GoodsPrice;
	Long GoodsQty;
	String GoodsImage;
	
	public Long getCartNum() {
		return cartNum;
	}
	public void setCartNum(Long cartNum) {
		this.cartNum = cartNum;
	}
	public Long getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Long goodsSeq) {
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
	public Long getGoodsPrice() {
		return GoodsPrice;
	}
	public void setGoodsPrice(Long goodsPrice) {
		GoodsPrice = goodsPrice;
	}
	public Long getGoodsQty() {
		return GoodsQty;
	}
	public void setGoodsQty(Long goodsQty) {
		GoodsQty = goodsQty;
	}
	public String getGoodsImage() {
		return GoodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		GoodsImage = goodsImage;
	}
}
