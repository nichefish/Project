package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class GoodsDTO implements Serializable {
	Long goodsSeq;
	String GoodsNum;
	String UserId;
	String GoodsName;
	Long GoodsPrice;
	Long GoodsQty;
	String GoodsContent;
	String GoodsImage;
	Timestamp GoodsRegister;
	Long goodsVisit;
	
	public GoodsDTO() {
	}
	public GoodsDTO(Long goodsSeq, String goodsNum, String userId, String goodsName, Long goodsPrice,
			Long goodsQty, String goodsContent, String goodsImage, Long goodsVisit) {
		this.goodsSeq = goodsSeq;
		this.GoodsNum = goodsNum;
		this.UserId = userId;
		this.GoodsName = goodsName;
		this.GoodsPrice = goodsPrice;
		this.GoodsQty = goodsQty;
		this.GoodsContent = goodsContent;
		this.GoodsImage = goodsImage;
		this.goodsVisit = goodsVisit;
	}
	
	public Long getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Long goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
	public String getGoodsNum() {
		return GoodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		GoodsNum = goodsNum;
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
	public String getGoodsContent() {
		return GoodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		GoodsContent = goodsContent;
	}
	public String getGoodsImage() {
		return GoodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		GoodsImage = goodsImage;
	}
	public Timestamp getGoodsRegister() {
		return GoodsRegister;
	}
	public void setGoodsRegister(Timestamp goodsRegister) {
		GoodsRegister = goodsRegister;
	}
	public Long getGoodsVisit() {
		return goodsVisit;
	}
	public void setGoodsVisit(Long goodsVisit) {
		this.goodsVisit = goodsVisit;
	}
}
