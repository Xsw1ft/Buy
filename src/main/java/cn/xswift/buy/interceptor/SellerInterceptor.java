package cn.xswift.buy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.xswift.buy.dao.UserMapper;
import cn.xswift.buy.entity.User;
import cn.xswift.buy.utils.CheckLogin;
import cn.xswift.buy.utils.CookieC;

public class SellerInterceptor extends HandlerInterceptorAdapter{

	CheckLogin cl = new CheckLogin();
	CookieC cookieC = new CookieC();
	UserMapper userMapper = new UserMapper();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(!cl.checkLogin(request)) {
			//未登录
			request.getRequestDispatcher("my.do").forward(request, response);
			return false;
		}else {
			//是否是商家
			long userId = Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
			User user = userMapper.selectUserById(userId);
			if(!user.isUserIsSeller()) {
				request.getRequestDispatcher("my.do").forward(request, response);
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
}
