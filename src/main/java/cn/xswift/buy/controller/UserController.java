package cn.xswift.buy.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.service.UserService;
import cn.xswift.buy.utils.CookieC;
@Controller
public class UserController{

	@Autowired
	private UserService userService;
	@Autowired
	private CookieC cookieC;
	
	private long getID(HttpServletRequest request) {
		return Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
	}
	/**
	 * ��ת��my
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/my")
	public ModelAndView my(HttpServletRequest request) {
		return userService.goMy(request);
	}
	
	/**
	 * ��ת��my
	 * @return
	 */
	@RequestMapping(value="/index")
	public ModelAndView index() {
		return userService.goIndex();
	}
	
	/**
	 * ��ת��my
	 * @return
	 */
	@RequestMapping(value="/shop")
	public ModelAndView shop() {
		return userService.goShop();
	}
	
	/**
	 * �û���¼��������
	 * @param response
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(
			HttpServletResponse response,
			@RequestParam(value="uid",required=false) Long userId,
			@RequestParam(value="upw",required=false) String userPassword
			) {
		return userService.userLogin(response,userId,userPassword);
	}

	/**
	 * �û��˳���������
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(
			HttpServletResponse response,
			HttpServletRequest request) {
		return userService.userLogout(request,response);
	}

	/**
	 * �û�����Ʒ����ҳ��������
	 * @param request
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value="/payment")
	public ModelAndView payment(
			HttpServletRequest request,
			@RequestParam(value="commodityid") int commodityId) {
		return userService.payment(getID(request),commodityId);
	}

	/**
	 * ��ȡ�����б�
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/transactionlist")
	public ModelAndView gettransactionlist(HttpServletRequest request) {
		return userService.getTransactionlist(request);
	}

	/**
	 * ��ȡ����ɵĶ������б�
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/finishtranlist")
	public ModelAndView finishtranlist(HttpServletRequest request) {
		return userService.getFinishtranlist(getID(request));
	}

	/**
	 * �û��������ɶ�������������
	 * @param transactionId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/finishtran")
	public ModelAndView finishtran(@RequestParam(value="tid",required=false) int transactionId) {
		return userService.userFinishtran(transactionId);
	}

	/**
	 * �ӹ��ﳵ�Ƴ���Ʒ��������
	 * @param commodityId
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/removeFromCart")
	public ModelAndView removeFromCart(
			@RequestParam(value="cid",required=false) int commodityId,
			HttpServletRequest request) {
		return userService.removeCommodity(commodityId,getID(request));
	}
	
	/**
	 * ������Ʒ
	 * @param commodityName
	 * @return
	 */
	@RequestMapping(value="/search")
	public ModelAndView searchCommodity(
			@RequestParam(value="cname",required=false) String commodityName) {
		return userService.searchCommodity(commodityName);
	}
	
	/**
	 * ��ת�� ȷ�϶��� ҳ��
	 * @param j
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/payconfirm")
	public ModelAndView payConfirm(
			@RequestParam(value="params",required=false) String j,
			HttpServletRequest request
			) {
		return userService.payConfirm(j,getID(request));
	}
	
	/**
	 * ȷ�϶���ҳ���� ����ɶ�����
	 * @param j
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/payfinish")
	public ModelAndView payFinish(
			@RequestParam(value="json",required=false) String j,
			HttpServletRequest request
			) {
		return userService.payFinish(j,getID(request));
	}
	
	/**
	 * ��ҳ�ķ���ѡ�����
	 * @param kind
	 * @return
	 */
	@RequestMapping(value="/kind")
	public ModelAndView getKind(
			@RequestParam(value="kind",required=false) int kind
			) {
		return userService.getKind(kind);
	}
	
	/**
	 * �ύͶ����Ϣ��������
	 * @param commodityId
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/complaint")
	public ModelAndView getComplaint(
			@RequestParam(value="cid",required=false) int commodityId,
			@RequestParam(value="content",required=false) String content
			) {
		return userService.complaint(commodityId,content);
	}
	
	
	/**
	 * ��ת�� Ͷ����Ϣ ҳ�� 
	 * @param commodityId
	 * @return
	 */
	@RequestMapping(value="/complaintpage")
	public ModelAndView getComplaint(
			@RequestParam(value="cid",required=false) int commodityId
			) {
		return userService.complaintpage(commodityId);
	}
}
