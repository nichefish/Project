package Command.Goods;

import org.springframework.web.multipart.MultipartFile;

public class GoodsCommand {
	private String goodsNum;
	private String goodsName;
	private Integer goodsPrice;
	private Integer goodsQty;
	private String goodsContent;
	private MultipartFile [] goodsImage;
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getGoodsQty() {
		return goodsQty;
	}
	public void setGoodsQty(Integer goodsQty) {
		this.goodsQty = goodsQty;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public MultipartFile[] getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(MultipartFile[] goodsImage) {
		this.goodsImage = goodsImage;
	}
}