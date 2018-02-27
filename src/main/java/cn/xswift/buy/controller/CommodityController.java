package cn.xswift.buy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.service.CommodityService;
import cn.xswift.buy.utils.CookieC;

@Controller
public class CommodityController{
	
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private CookieC cookieC;
	
	private long getID(HttpServletRequest request) {
		return Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
	}
	
	/**
	 * 商品上架（操作）
	 * @param commodityName
	 * @param commodityPrice
	 * @param commodityDescribe
	 * @param commodityStock
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/putOnSale")
	public ModelAndView putOnSale(HttpServletRequest request) {
		return commodityService.putOnSale(request);
	}
	
	/**
	 * 商品编辑（操作）
	 * @param commodityId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit(
			@RequestParam(value="cid",required=false) int commodityId,
			HttpServletRequest request
			) {
		String ppath = request.getSession().getServletContext().getRealPath("");
		return commodityService.edit(commodityId,getID(request),ppath,request);
	}
	
	/**
	 * 商品下架（操作）
	 * @param commodityId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cdown")
	public ModelAndView cdown(
			@RequestParam(value="cid",required=false) int commodityId,
			HttpServletRequest request
			) {
		String ppath = request.getSession().getServletContext().getRealPath("");
		return commodityService.cdown(commodityId,getID(request),ppath);
	}
}
