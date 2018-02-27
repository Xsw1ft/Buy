package cn.xswift.buy.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.dao.CommodityMapper;
import cn.xswift.buy.dao.SellerMapper;
import cn.xswift.buy.dao.UserMapper;
import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.entity.Seller;
import cn.xswift.buy.entity.User;
import cn.xswift.buy.utils.AlertAndResponse;
import cn.xswift.buy.utils.CookieC;
import cn.xswift.buy.utils.SellerRegist;

public class SellerService {

	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private SellerMapper sellerMapper;
	@Autowired
	private AlertAndResponse alertAndResponse;
	@Autowired
	private SellerRegist sellerRegist;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CookieC cookieC;
	
	
	/**
	 * 进入商家详情页（包含商家信息和商家上架的商品）
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView goIntoShop(long sellerId) {
		ModelAndView mv = new ModelAndView("shopdetail");
		mv.addObject("sellerInfo", sellerMapper.selectSellerById(sellerId));
		mv.addObject("commodityList", commodityMapper.selectCommodityBySellerIdNotZero(sellerId));
		return mv;
	}
	
	/**
	 * 商家登录（操作） 
	 * @param sellerName
	 * @param sellerPassword
	 * @param response
	 * @return
	 */
	@Transactional
	public ModelAndView sellerLogin(String sellerName,String sellerPassword,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		User user = userMapper.selectUserByName(sellerName);
		if(user!=null &&user.getUserPassword().equals(sellerPassword)) {
			if(sellerMapper.selectSellerStatus(user.getUserId())==3) {
				Object userId = user.getUserId();
				cookieC.addCookie(response, "userId", userId.toString(), 60*60);
				cookieC.addCookie(response, "status", "true", 60*60);
				cookieC.addCookie(response, "isSeller", "true", 60*60);
				mv.setViewName("refresh");
			}
			else {
				alertAndResponse.alertAndResponse(mv, "账户审核中", "my.do");
			}
		}else {
			alertAndResponse.alertAndResponse(mv, "用户名或密码错误！", "my.do");
		}
		return mv;
	}
	
	/**
	 * 跳转至发布商品页面
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView publishCommodity() {
		return new ModelAndView("putOnSale");
	}
	
	/**
	 * 商家注册（操作）
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView sellerRegist(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("my");
		if(sellerRegist.sellerRegist(request)) {
			return alertAndResponse.alertAndResponse(mv, "申请信息提交成功，请耐心等待审核", "index.do");
		}else{
			return alertAndResponse.alertAndResponse(mv, "申请失败,可能是提交的信息不完整", "my.do");
		}
	}
	
	/**
	 * 获取申请注册的商家列表
	 * @return
	 */
	@Transactional
	public ModelAndView getApplyerList() {
		ModelAndView mv = new ModelAndView("applyerlist");
		List<Seller> applyerList = sellerMapper.selectSellerApply();
		mv.addObject("applyerList", applyerList);
		return mv;
	}
	
	/**
	 * 审核商家（操作）
	 * @param sellerId
	 * @param sellerStatus
	 * @return
	 */
	@Transactional
	public ModelAndView agreeSeller(long sellerId,String sellerStatus) {
		ModelAndView mv = new ModelAndView();
		String status = "";
		if (sellerStatus.equals("true")) {
			//同意注册
			if(sellerMapper.updateSellerStatusAgreeById(sellerId)==1) {
				status = "审核成功";
			}else {
				status = "审核失败";
			}
		}else if(sellerStatus.equals("false")){
			//不同意注册
			if(sellerMapper.updateSellerStatusDisagreeById(sellerId)==1) {
				status = "审核成功";
			}else {
				status = "审核失败";
			}
		}
		return alertAndResponse.alertAndResponse(mv, status, "sellerapplylist.do");
	}
	
	/**
	 * 跳转到编辑列表页面
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView getEditList(long sellerId) {
		ModelAndView mv = new ModelAndView();
		List<Commodity> commodityList = commodityMapper.selectCommodityBySellerId(sellerId);
		mv.addObject("commodityList", commodityList);
		mv.setViewName("editlist");
		return mv;
	}
	
	/**
	 * 跳转到编辑页面
	 * @param commodityId
	 * @return
	 */
	@Transactional
	public ModelAndView editPage(int commodityId) {
		ModelAndView mv = new ModelAndView();
		Commodity commodity = commodityMapper.selectCommodityById(commodityId);
		mv.addObject("commodity", commodity);
		mv.setViewName("edit");
		return mv;
	}
	
	@Transactional
	public Seller getSellerApplyInfoJSON(Long sellerId) {
		return sellerMapper.selectSellerById(sellerId);
	}
}
