package cn.xswift.buy.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLogin {
	
	private CookieC cc = new CookieC();
	
	/**
	 * ����û��Ƿ��Ѿ���¼
	 * */
	public boolean checkLogin(HttpServletRequest request) {
		boolean result = false;
		if(cc.selectCookieValueByName(request, "status").equals("true")) {
			result = true;
		}
		return result;
	}
	
	/**
	 * ��ȡ�ѵ�¼�û���Ϣ
	 * */
	public String getLoginInfo(HttpServletRequest request) {
		return new String(cc.selectCookieValueByName(request, "userName"));
	}
	
	/**
	 * �����û���¼��Ϣ
	 * */
	public void setLoginInfo(HttpServletResponse response ,String userInfo,int maxAge) {
		cc.addCookie(response, "userName", userInfo, maxAge);
		cc.addCookie(response, "status", "true", maxAge);
	}
	/**
	 * ɾ���û���¼��Ϣ
	 * */
	public void deleteLoginInfo(HttpServletRequest request, HttpServletResponse response) {
		cc.deleteCookieByName(request, response, "userName");
		cc.deleteCookieByName(request, response, "status");
	}
}
