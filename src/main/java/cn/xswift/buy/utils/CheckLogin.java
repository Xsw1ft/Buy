package cn.xswift.buy.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckLogin {
	
	private CookieC cc = new CookieC();
	
	/**
	 * 检测用户是否已经登录
	 * */
	public boolean checkLogin(HttpServletRequest request) {
		boolean result = false;
		if(cc.selectCookieValueByName(request, "status").equals("true")) {
			result = true;
		}
		return result;
	}
	
	/**
	 * 获取已登录用户信息
	 * */
	public String getLoginInfo(HttpServletRequest request) {
		return new String(cc.selectCookieValueByName(request, "userName"));
	}
	
	/**
	 * 保存用户登录信息
	 * */
	public void setLoginInfo(HttpServletResponse response ,String userInfo,int maxAge) {
		cc.addCookie(response, "userName", userInfo, maxAge);
		cc.addCookie(response, "status", "true", maxAge);
	}
	/**
	 * 删除用户登录信息
	 * */
	public void deleteLoginInfo(HttpServletRequest request, HttpServletResponse response) {
		cc.deleteCookieByName(request, response, "userName");
		cc.deleteCookieByName(request, response, "status");
	}
}
