package cn.xswift.buy.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

public class CookieC {
	
	/**
	 * 添加cookie
	 * */
	public void addCookie(HttpServletResponse response,String name,String value,int maxAge) {
		byte[] valuebyte  = Base64.encodeBase64(value.getBytes());
		Cookie cookie = new Cookie(name, new String(valuebyte));
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}
	
	/**
	 * 删除cookie
	 * */
	public void deleteCookieByName(HttpServletRequest request,HttpServletResponse response,String name) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals(name)) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				break;
			}
		}
	}
	
	/**
	 * 更新cookie
	 * */
	public void updateCookieValueByName(HttpServletRequest request,HttpServletResponse response,String name,String value) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals(name)) {
				cookie.setValue(new String(Base64.encodeBase64(value.getBytes())));
				response.addCookie(cookie);
				break;
			}
		}
	}
	
	/**
	 * 查询cookie
	 * */
	public String selectCookieValueByName(HttpServletRequest request,String name) {
		Cookie[] cookies = request.getCookies();
		String value = "NotFound";
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals(name)) {
					value = new String(Base64.decodeBase64(cookie.getValue().getBytes()));
					break;
				}
			}
		}
		return value;
	}
}
