package cn.xswift.buy.entity;

public class User {
	private long userId;
	private String userName;
	private String userPassword;
	private Double userMoney;
	private boolean userIsSeller;
	private String userContactInfo;
	private String userAddr;
	
	
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public boolean isUserIsSeller() {
		return userIsSeller;
	}
	public void setUserIsSeller(boolean userIsSeller) {
		this.userIsSeller = userIsSeller;
	}
	
	public String getUserContactInfo() {
		return userContactInfo;
	}
	public void setUserContactInfo(String userContactInfo) {
		this.userContactInfo = userContactInfo;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Double getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}
	
	public User(long userId, String userName, String userPassword, Double userMoney, boolean userIsSeller,
			String userContactInfo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMoney = userMoney;
		this.userIsSeller = userIsSeller;
		this.userContactInfo = userContactInfo;
	}
	public User() {
		super();
	}
	public User(String userName, String userPassword, Double userMoney, boolean userIsSeller, String userContactInfo) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMoney = userMoney;
		this.userIsSeller = userIsSeller;
		this.userContactInfo = userContactInfo;
	}
	public User(long userId, String userName, String userPassword, Double userMoney, boolean userIsSeller,
			String userContactInfo, String userAddr) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userMoney = userMoney;
		this.userIsSeller = userIsSeller;
		this.userContactInfo = userContactInfo;
		this.userAddr = userAddr;
	}
	
	
}
