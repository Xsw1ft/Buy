package cn.xswift.buy.utils;

public class LoginList {

	public String getLoginList(String userName,double userMoney,boolean isSeller) {
		String userInfoStr = "<div class=\"quan_main_my\"><div class=\"quan_my_list\"><div class=\"quan_my_userinfo row-fluid\">\r\n" + 
				"								<div class=\"col-xs-3 quan_my_userinfo_headimg\">\r\n" + 
				"									<��װ��ͷ��>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-xs-9 quan_my_userinfo_detail\">\r\n" + 
				"									<span class=\"quan_my_userinfo_username\">\r\n" + 
				"										��ӭ��"+ userName + "\r\n" + 
				"									</span>\r\n" + 
				"								</div>\r\n" + 
				"							</div>";
		String userMoneyStr = "</div>\r\n" + 
				"							<div class=\"quan_my_usermoney\">\r\n" + 
				"								<span>��"+ userMoney +"</span>\r\n" + 
				"							</div>";
		String userTransactionsStr = "<div class=\"quan_my_transactions row-fluid\">\r\n" + 
				"								<a href=\"finishtranlist.do\" class=\" col-xs-6 btn btn-default\">\r\n" + 
				"									��ȷ�Ͻ��׼�¼\r\n" + 
				"								</a><a href=\"transactionlist.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
				"									�鿴���׼�¼\r\n" + 
				"								</a></div>";
		String userLogoutStr = "<div class=\"quan_my_logout row-fluid\">\r\n" + 
				"								<a href=\"logout.do\" class=\"btn btn-danger btn-block\">\r\n" + 
				"									�˳���¼\r\n" + 
				"								</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div></div>";
		String userMessageBox = "<div class=\"quan_my_messagebox\">\r\n" + 
				"								<a href=\"\" class=\"btn-block btn btn-default\">\r\n" + 
				"									��Ϣ���ӣ������У�\r\n" + 
				"								</a>\r\n" + 
				"							</div>";
		if(isSeller) {
			String userPublishStr = "<div class=\"quan_my_publish row-fluid\">\r\n" + 
					"								<a href=\"publishcommodity.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									��������Ʒ\r\n" + 
					"								</a>\r\n" + 
					"								<a href=\"editlist.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									�༭�ѷ�����Ʒ\r\n" + 
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
				"										��ӭ��"+ userName + "\r\n" + 
				"									</span>\r\n" + 
				"								</div>\r\n" + 
				"							</div>";
		String userMoneyStr = "</div>\r\n" + 
				"							<div class=\"quan_my_usermoney\">\r\n" + 
				"								<span>��"+ userMoney +"</span>\r\n" + 
				"							</div>";
		String userTransactionsStr = "<div class=\"quan_my_transactions\">\r\n" + 
				"								<a href=\"transactionlist.do\" class=\"btn-block btn btn-default\">\r\n" + 
				"									�鿴���׼�¼\r\n" + 
				"								</a></div>";
		String userLogoutStr = "<div class=\"quan_my_logout row-fluid\">\r\n" + 
				"								<a href=\"logout.do\" class=\"btn btn-danger btn-block\">\r\n" + 
				"									�˳���¼\r\n" + 
				"								</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div></div>";
		String userMessageBox = "<div class=\"quan_my_messagebox\">\r\n" + 
				"								<a href=\"\" class=\"btn-block btn btn-default\">\r\n" + 
				"									��Ϣ���ӣ������У�\r\n" + 
				"								</a>\r\n" + 
				"							</div>";
		
		String userPublishStr = "<div class=\"quan_my_publish row-fluid\">\r\n" + 
					"								<a href=\"publishcommodity.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									��������Ʒ\r\n" + 
					"								</a>\r\n" + 
					"								<a href=\"editlist.do\" class=\"col-xs-6 btn btn-default\">\r\n" + 
					"									�༭�ѷ�����Ʒ\r\n" + 
					"								</a>\r\n" + 
					"							</div>";
		return userInfoStr + userMoneyStr + userTransactionsStr + userMessageBox +userPublishStr + userLogoutStr;
		
	}
}
