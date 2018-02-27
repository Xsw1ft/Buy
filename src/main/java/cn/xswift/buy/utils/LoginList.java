package cn.xswift.buy.utils;

public class LoginList {

	public String getLoginList(String userName,double userMoney,boolean isSeller) {
		String userInfoStr = "<div class=\"quan_main_my\"><div class=\"quan_my_list\"><div class=\"quan_my_userinfo row-fluid\">\r\n" + 
				"								<div class=\"col-xs-3 quan_my_userinfo_headimg\">\r\n" + 
				"									<假装有头像>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-xs-9 quan_my_userinfo_detail\">\r\n" + 
				"									<span class=\"quan_my_userinfo_username\">\r\n" + 
				"										欢迎："+ userName + "\r\n" + 
				"									</span>\r\n" + 
				"								</div>\r\n" + 
				"							</div>";
		String userMoneyStr = "</div>\r\n" + 
				"							<div class=\"quan_my_usermoney\">\r\n" + 
				"								<span>余额："+ userMoney +"</span>\r\n" + 
				"							</div>";
		String userTransactionsStr = "<div class=\"quan_my_transactions row-fluid\">\r\n" + 
				"								<a href=\"finishtranlist.do\" class=\" col-xs-6 btn btn-default\">\r\n" + 
				"									待确认交易记录\r\n" + 
				"								</a><a href=\"transactionlist.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
				"									查看交易记录\r\n" + 
				"								</a></div>";
		String userLogoutStr = "<div class=\"quan_my_logout row-fluid\">\r\n" + 
				"								<a href=\"logout.do\" class=\"btn btn-danger btn-block\">\r\n" + 
				"									退出登录\r\n" + 
				"								</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div></div>";
		String userMessageBox = "<div class=\"quan_my_messagebox\">\r\n" + 
				"								<a href=\"\" class=\"btn-block btn btn-default\">\r\n" + 
				"									消息盒子（建设中）\r\n" + 
				"								</a>\r\n" + 
				"							</div>";
		if(isSeller) {
			String userPublishStr = "<div class=\"quan_my_publish row-fluid\">\r\n" + 
					"								<a href=\"publishcommodity.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									发布新商品\r\n" + 
					"								</a>\r\n" + 
					"								<a href=\"editlist.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									编辑已发布商品\r\n" + 
					"								</a>\r\n" + 
					"							</div>";
			return userInfoStr + userMoneyStr + userTransactionsStr + userMessageBox +userPublishStr + userLogoutStr;
		}
		else {
			return userInfoStr + userMoneyStr + userTransactionsStr + userMessageBox + userLogoutStr;
		}
	}
	public String getSellerLoginList(String userName,double userMoney,boolean isSeller,String imgsrc) {
		String userInfoStr = "<div class=\"quan_main_my\"><div class=\"quan_my_list\"><div class=\"quan_my_userinfo row-fluid\">\r\n" + 
				"								<div class=\"col-xs-3 quan_my_userinfo_headimg\">\r\n" + 
				"									<img src=\""+imgsrc+"\" id=\"headimg\" width=\"75px\" height=\"75px\"/>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-xs-9 quan_my_userinfo_detail\">\r\n" + 
				"									<span class=\"quan_my_userinfo_username\">\r\n" + 
				"										欢迎："+ userName + "\r\n" + 
				"									</span>\r\n" + 
				"								</div>\r\n" + 
				"							</div>";
		String userMoneyStr = "</div>\r\n" + 
				"							<div class=\"quan_my_usermoney\">\r\n" + 
				"								<span>余额："+ userMoney +"</span>\r\n" + 
				"							</div>";
		String userTransactionsStr = "<div class=\"quan_my_transactions\">\r\n" + 
				"								<a href=\"transactionlist.do\" class=\"btn-block btn btn-default\">\r\n" + 
				"									查看交易记录\r\n" + 
				"								</a></div>";
		String userLogoutStr = "<div class=\"quan_my_logout row-fluid\">\r\n" + 
				"								<a href=\"logout.do\" class=\"btn btn-danger btn-block\">\r\n" + 
				"									退出登录\r\n" + 
				"								</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div></div>";
		String userMessageBox = "<div class=\"quan_my_messagebox\">\r\n" + 
				"								<a href=\"\" class=\"btn-block btn btn-default\">\r\n" + 
				"									消息盒子（建设中）\r\n" + 
				"								</a>\r\n" + 
				"							</div>";
		
		String userPublishStr = "<div class=\"quan_my_publish row-fluid\">\r\n" + 
					"								<a href=\"publishcommodity.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									发布新商品\r\n" + 
					"								</a>\r\n" + 
					"								<a href=\"editlist.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									编辑已发布商品\r\n" + 
					"								</a>\r\n" + 
					"							</div>";
		return userInfoStr + userMoneyStr + userTransactionsStr + userMessageBox +userPublishStr + userLogoutStr;
		
	}
}
