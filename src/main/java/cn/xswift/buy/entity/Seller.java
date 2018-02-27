package cn.xswift.buy.entity;

public class Seller {
	private Long sellerId;
	private String sellerName;
	private String sellerImgsrc;
	private String sellerContactInfo;
	private String sellerAddr;
	private String sellerSellInfo;
	private int sellerStatus;//0:注销 ,1:暂停 ,2:申请中 ,3:营业
	
	
	public int getSellerStatus() {
		return sellerStatus;
	}
	public void setSellerStatus(int sellerStatus) {
		this.sellerStatus = sellerStatus;
	}
	public String getSellerImgsrc() {
		return sellerImgsrc;
	}
	public void setSellerImgsrc(String sellerImgsrc) {
		this.sellerImgsrc = sellerImgsrc;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerContactInfo() {
		return sellerContactInfo;
	}
	public void setSellerContactInfo(String sellerContactInfo) {
		this.sellerContactInfo = sellerContactInfo;
	}
	public String getSellerAddr() {
		return sellerAddr;
	}
	public void setSellerAddr(String sellerAddr) {
		this.sellerAddr = sellerAddr;
	}
	public String getSellerSellInfo() {
		return sellerSellInfo;
	}
	public void setSellerSellInfo(String sellerSellInfo) {
		this.sellerSellInfo = sellerSellInfo;
	}
	public Seller(Long sellerId, String sellerName, String sellerContactInfo, String sellerAddr,
			String sellerSellInfo) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerContactInfo = sellerContactInfo;
		this.sellerAddr = sellerAddr;
		this.sellerSellInfo = sellerSellInfo;
	}
	public Seller() {
		super();
	}
	public Seller(Long sellerId, String sellerImgsrc, String sellerAddr, String sellerSellInfo, int sellerStatus) {
		super();
		this.sellerId = sellerId;
		this.sellerImgsrc = sellerImgsrc;
		this.sellerAddr = sellerAddr;
		this.sellerSellInfo = sellerSellInfo;
		this.sellerStatus = sellerStatus;
	}
	public Seller(Long sellerId, String sellerName, String sellerImgsrc, String sellerContactInfo, String sellerAddr,
			String sellerSellInfo, int sellerStatus) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerImgsrc = sellerImgsrc;
		this.sellerContactInfo = sellerContactInfo;
		this.sellerAddr = sellerAddr;
		this.sellerSellInfo = sellerSellInfo;
		this.sellerStatus = sellerStatus;
	}
	public Seller(Long sellerId, String sellerName, String sellerImgsrc, String sellerContactInfo, String sellerAddr,
			String sellerSellInfo) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerImgsrc = sellerImgsrc;
		this.sellerContactInfo = sellerContactInfo;
		this.sellerAddr = sellerAddr;
		this.sellerSellInfo = sellerSellInfo;
	}
	
	
	
}
