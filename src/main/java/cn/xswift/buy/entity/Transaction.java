package cn.xswift.buy.entity;

import java.sql.Timestamp;

public class Transaction {

	private int transactionId;
	private long transactionBuyerId;
	private long transactionSellerId;
	private int commodityId;
	private int transactionNum;
	private double transactionMoney;
	private Timestamp transactionPaytime;
	private Timestamp transactionFinishtime;
	private String transactionMode;
	private String transactionWords;
	private String transactionSellerName;
	private Commodity commodity;
	
	
	
	public double getTransactionMoney() {
		return transactionMoney;
	}
	public void setTransactionMoney(double transactionMoney) {
		this.transactionMoney = transactionMoney;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public String getTransactionSellerName() {
		return transactionSellerName;
	}
	public void setTransactionSellerName(String transactionSellerName) {
		this.transactionSellerName = transactionSellerName;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getTransactionWords() {
		return transactionWords;
	}
	public void setTransactionWords(String transactionWords) {
		this.transactionWords = transactionWords;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public long getTransactionBuyerId() {
		return transactionBuyerId;
	}
	public void setTransactionBuyerId(long transactionBuyerId) {
		this.transactionBuyerId = transactionBuyerId;
	}
	public long getTransactionSellerId() {
		return transactionSellerId;
	}
	public void setTransactionSellerId(long transactionSellerId) {
		this.transactionSellerId = transactionSellerId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public int getTransactionNum() {
		return transactionNum;
	}
	public void setTransactionNum(int transactionNum) {
		this.transactionNum = transactionNum;
	}
	public Timestamp getTransactionPaytime() {
		return transactionPaytime;
	}
	public void setTransactionPaytime(Timestamp transactionPaytime) {
		this.transactionPaytime = transactionPaytime;
	}
	public Timestamp getTransactionFinishtime() {
		return transactionFinishtime;
	}
	public void setTransactionFinishtime(Timestamp transactionFinishtime) {
		this.transactionFinishtime = transactionFinishtime;
	}
	public Transaction(int transactionId, long transactionBuyerId, long transactionSellerId, int commodityId,
			int transactionNum, Timestamp transactionPaytime, Timestamp transactionFinishtime) {
		super();
		this.transactionId = transactionId;
		this.transactionBuyerId = transactionBuyerId;
		this.transactionSellerId = transactionSellerId;
		this.commodityId = commodityId;
		this.transactionNum = transactionNum;
		this.transactionPaytime = transactionPaytime;
		this.transactionFinishtime = transactionFinishtime;
	}
	public Transaction(int transactionId, long transactionBuyerId, long transactionSellerId, int commodityId,
			int transactionNum, Timestamp transactionPaytime) {
		super();
		this.transactionId = transactionId;
		this.transactionBuyerId = transactionBuyerId;
		this.transactionSellerId = transactionSellerId;
		this.commodityId = commodityId;
		this.transactionNum = transactionNum;
		this.transactionPaytime = transactionPaytime;
	}
	
	
	public Transaction(long transactionBuyerId, long transactionSellerId, int commodityId, int transactionNum,
			Timestamp transactionPaytime,String transactionMode,String transactionWords) {
		super();
		this.transactionBuyerId = transactionBuyerId;
		this.transactionSellerId = transactionSellerId;
		this.commodityId = commodityId;
		this.transactionNum = transactionNum;
		this.transactionPaytime = transactionPaytime;
		this.transactionMode = transactionMode;
		this.transactionWords = transactionWords;
	}
	public Transaction() {
		super();
	}
	public Transaction(int transactionId, long transactionBuyerId, long transactionSellerId, int commodityId,
			int transactionNum, Timestamp transactionPaytime, Timestamp transactionFinishtime, String transactionMode,
			String transactionWords) {
		super();
		this.transactionId = transactionId;
		this.transactionBuyerId = transactionBuyerId;
		this.transactionSellerId = transactionSellerId;
		this.commodityId = commodityId;
		this.transactionNum = transactionNum;
		this.transactionPaytime = transactionPaytime;
		this.transactionFinishtime = transactionFinishtime;
		this.transactionMode = transactionMode;
		this.transactionWords = transactionWords;
	}
	
	
	
}
