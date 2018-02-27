package cn.xswift.buy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.dao.CommodityMapper;
import cn.xswift.buy.dao.SellerMapper;
import cn.xswift.buy.dao.UserMapper;
import cn.xswift.buy.entity.Seller;
import cn.xswift.buy.service.SellerService;
import cn.xswift.buy.utils.AlertAndResponse;
import cn.xswift.buy.utils.CheckLogin;
import cn.xswift.buy.utils.CookieC;
import cn.xswift.buy.utils.SellerRegist;

@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	@Autowired
	private CookieC cookieC;
	
	private long getID(HttpServletRequest request) {
		return Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
	}
	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/intoshop")
	public ModelAndView intoShop(@RequestParam(value="id") long sellerId) {
		return sellerService.goIntoShop(sellerId);
	}
	
	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @param sellerName
	 * @param sellerPassword
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/sellerlogin")
	public ModelAndView sellerLogin(
			@RequestParam(value="sn",required=false) String sellerName,
			@RequestParam(value="spwd",required=false) String sellerPassword,
			HttpServletResponse response){
		return sellerService.sellerLogin(sellerName,sellerPassword,response);
	}
	
	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/publishcommodity")
	public ModelAndView publishCommodity() {
		return sellerService.publishCommodity();
	}

	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sellerregist")
	public ModelAndView sellerRegist(HttpServletRequest request) {
		return sellerService.sellerRegist(request);
	}

	/**
	 * ��ȡ����ע����̼ҵ���Ϣ
	 * @param sellerId
	 * @return
	 */
	@RequestMapping(value="/getSellerApplyInfo")
	public @ResponseBody Seller getSellerApplyInfoJSON(
			@RequestParam(value="sellerId") Long sellerId
			) {
		return sellerService.getSellerApplyInfoJSON(sellerId);
	}

	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @return
	 */
	@RequestMapping(value="/sellerapplylist")
	public ModelAndView getApplyerList() {
		return sellerService.getApplyerList();
	}
	@RequestMapping(value="/agreeSeller")
	public ModelAndView agreeSeller(
			@RequestParam(value="sellerid",required=false) long sellerId,
			@RequestParam(value="agree",required=false) String sellerStatus
			) {
		return sellerService.agreeSeller(sellerId, sellerStatus);
	}
	
	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/editlist")
	public ModelAndView getEditList(
			HttpServletRequest request
			) {
		return sellerService.getEditList(getID(request));
	}
	
	/**
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value="/editpage")
	public ModelAndView editPage(
			@RequestParam(value="cid",required=false) int commodityId
			) {
		return sellerService.editPage(commodityId);
	}
	

}
