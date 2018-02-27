package cn.xswift.buy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.service.CartService;
import cn.xswift.buy.utils.CookieC;


@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private CookieC cookieC;
	
	private long getID(HttpServletRequest request) {
		return Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
	}
	
	/**
	 * 将商品添加到购物车
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addCart")
	public ModelAndView addToCart(HttpServletRequest request,
			@RequestParam(value="id",required=false) int commodityId) {
		return cartService.addToCart(getID(request),commodityId);
	}

	/**
	 * 打开（查看）购物车
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/shoppingcart")
	public ModelAndView selectCart(HttpServletRequest request) {
		return cartService.selectCart(getID(request));
	}
}
