package cn.xswift.buy.entity;

public class TransactionSimple {
	private String commodityName;
	private String sellerName;
	private String status;
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TransactionSimple(String commodityName, String sellerName, String status) {
		super();
		this.commodityName = commodityName;
		this.sellerName = sellerName;
		this.status = status;
	}
	public TransactionSimple() {
		super();
	}
	
}
