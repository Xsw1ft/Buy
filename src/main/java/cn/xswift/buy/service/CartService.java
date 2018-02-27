package cn.xswift.buy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.dao.CartMapper;
import cn.xswift.buy.dao.CommodityMapper;
import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.utils.AlertAndResponse;
import cn.xswift.buy.utils.CheckLogin;
import cn.xswift.buy.utils.CookieC;

public class CartService {

	@Autowired
	private CookieC cookieC;
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private AlertAndResponse alertAndResponse;
	@Autowired
	private CommodityMapper commodityMapper;

	@Transactional
	public ModelAndView addToCart(long buyerId,int commodityId) {
		ModelAndView mv = new ModelAndView();
//		int commodityId = Integer.parseInt(request.getParameter("id"));
//		long buyerId = Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
		long sellerId = commodityMapper.selectSellerIdByCommodityId(commodityId);
		if(buyerId != sellerId) {
			if(cartMapper.selectHasAdded(buyerId, commodityId)==0) {
				if(cartMapper.insertCart(buyerId,commodityId)==1) {
					mv = alertAndResponse.alertAndResponse(mv, "加入购物车成功", "index.do");
				}
				else {
					mv = alertAndResponse.alertAndResponse(mv, "加入购物车失败", "index.do");
				}
			}else {
				mv = alertAndResponse.alertAndResponse(mv, "已加入购物车", "shoppingcart.do");
			}
		}else {
			mv = alertAndResponse.alertAndResponse(mv, "不能把自己的商品加入购物车", "index.do");
		}
		
		return mv;
	}

	@Transactional
	public ModelAndView selectCart(long buyerId) {
		ModelAndView mv = new ModelAndView("shoppingcart");
		List<Commodity> commodityList =  cartMapper.selectCartByBuyerId(buyerId);
		String cartIds = "";//用来计算购物车内有几件物品
		for(Commodity c :commodityList) {
			cartIds = cartIds + c.getCommodityId()+",";
		}
		mv.addObject("cart", commodityList);
		mv.addObject("cartIds", cartIds);
		return mv;
	}
}
