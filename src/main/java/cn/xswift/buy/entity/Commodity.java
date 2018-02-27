package cn.xswift.buy.entity;

import java.sql.Timestamp;

public class Commodity {
	private int commodityId;
	private Long sellerId;
	private String sellerName;
	private String commodityName;
	private double commodityPrice;
	private String commodityDescribe;
	private String commodityKind;
	private Timestamp commodityPublishtime;
	private String commodityHtmlsrc;
	private String commodityImgsrc;
	private int commodityStock;
	
	//-
	private int selected;
	private double total;
	
	
	
	public String getCommodityKind() {
		return commodityKind;
	}

	public void setCommodityKind(String commodityKind) {
		this.commodityKind = commodityKind;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Commodity(int commodityId, Long sellerId, String commodityName, double commodityPrice,
			String commodityDescribe, Timestamp commodityPublishtime, String commodityHtmlsrc, String commodityImgsrc) {
		super();
		this.commodityId = commodityId;
		this.sellerId = sellerId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
	}
	
	public Commodity(int commodityId, Long sellerId, String sellerName, String commodityName, double commodityPrice,
			String commodityDescribe, Timestamp commodityPublishtime, String commodityHtmlsrc, String commodityImgsrc,
			int commodityStock) {
		super();
		this.commodityId = commodityId;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
		this.commodityStock = commodityStock;
	}

	public Commodity() {
		super();
	}
	
	public Commodity(int commodityId, Long sellerId, String sellerName, String commodityName, double commodityPrice,
			String commodityDescribe, Timestamp commodityPublishtime, String commodityHtmlsrc, String commodityImgsrc) {
		super();
		this.commodityId = commodityId;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public double getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
	public String getCommodityDescribe() {
		return commodityDescribe;
	}
	public void setCommodityDescribe(String commodityDescribe) {
		this.commodityDescribe = commodityDescribe;
	}
	public Timestamp getCommodityPublishtime() {
		return commodityPublishtime;
	}
	public void setCommodityPublishtime(Timestamp commodityPublishtime) {
		this.commodityPublishtime = commodityPublishtime;
	}
	public String getCommodityHtmlsrc() {
		return commodityHtmlsrc;
	}
	public void setCommodityHtmlsrc(String commodityHtmlsrc) {
		this.commodityHtmlsrc = commodityHtmlsrc;
	}
	public String getCommodityImgsrc() {
		return commodityImgsrc;
	}
	public void setCommodityImgsrc(String commodityImgsrc) {
		this.commodityImgsrc = commodityImgsrc;
	}
	
	public int getCommodityStock() {
		return commodityStock;
	}

	public void setCommodityStock(int commodityStock) {
		this.commodityStock = commodityStock;
	}

	
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public Commodity(Long sellerId, String commodityName, double commodityPrice, String commodityDescribe,
			Timestamp commodityPublishtime, String commodityHtmlsrc, String commodityImgsrc) {
		super();
		this.sellerId = sellerId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
	}
	public Commodity(Long sellerId, String commodityName, double commodityPrice, String commodityDescribe,
			Timestamp commodityPublishtime,int commodityStock,String commodityKind) {
		super();
		this.sellerId = sellerId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityStock = commodityStock;
		this.commodityKind = commodityKind;
	}
	public Commodity(int commodityId, String commodityName, double commodityPrice, String commodityDescribe,
			String commodityHtmlsrc, String commodityImgsrc) {
		super();
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
	}

	public Commodity(int commodityId, Long sellerId, String sellerName, String commodityName, double commodityPrice,
			String commodityDescribe, Timestamp commodityPublishtime, String commodityHtmlsrc, String commodityImgsrc,
			int commodityStock, int selected) {
		super();
		this.commodityId = commodityId;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
		this.commodityStock = commodityStock;
		this.selected = selected;
	}

	public Commodity(int commodityId, Long sellerId, String sellerName, String commodityName, double commodityPrice,
			String commodityDescribe, String commodityKind, Timestamp commodityPublishtime, String commodityHtmlsrc,
			String commodityImgsrc, int commodityStock) {
		super();
		this.commodityId = commodityId;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityKind = commodityKind;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
		this.commodityStock = commodityStock;
	}

	public Commodity(int commodityId, Long sellerId, String sellerName, String commodityName, double commodityPrice,
			String commodityDescribe, String commodityKind, Timestamp commodityPublishtime, String commodityHtmlsrc,
			String commodityImgsrc, int commodityStock, int selected, double total) {
		super();
		this.commodityId = commodityId;
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.commodityDescribe = commodityDescribe;
		this.commodityKind = commodityKind;
		this.commodityPublishtime = commodityPublishtime;
		this.commodityHtmlsrc = commodityHtmlsrc;
		this.commodityImgsrc = commodityImgsrc;
		this.commodityStock = commodityStock;
		this.selected = selected;
		this.total = total;
	}
	
	
}
