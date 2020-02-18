package Model.DTO;

import java.sql.Timestamp;

public class GoodsDTO {
	Integer goodsSeq;
	String GoodsNum;
	String UserId;
	String GoodsName;
	Integer GoodsPrice;
	Integer GoodsQty;
	String GoodsContent;
	String GoodsImage;
	Timestamp GoodsRegister;
	Integer goodsVisit;
	
	public GoodsDTO() {
	}
	public GoodsDTO(Integer goodsSeq, String goodsNum, String userId, String goodsName, Integer goodsPrice,
			Integer goodsQty, String goodsContent, String goodsImage, Integer goodsVisit) {
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
	
	public Integer getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Integer goodsSeq) {
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
	public Integer getGoodsVisit() {
		return goodsVisit;
	}
	public void setGoodsVisit(Integer goodsVisit) {
		this.goodsVisit = goodsVisit;
	}
	
	
}
