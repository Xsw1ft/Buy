package cn.xswift.buy.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.dao.CartMapper;
import cn.xswift.buy.dao.CommodityMapper;
import cn.xswift.buy.dao.ComplaintMapper;
import cn.xswift.buy.dao.SellerMapper;
import cn.xswift.buy.dao.TransactionMapper;
import cn.xswift.buy.dao.UserMapper;
import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.entity.Complaint;
import cn.xswift.buy.entity.Seller;
import cn.xswift.buy.entity.Transaction;
import cn.xswift.buy.entity.TransactionSimple;
import cn.xswift.buy.entity.User;
import cn.xswift.buy.utils.AlertAndResponse;
import cn.xswift.buy.utils.CheckLogin;
import cn.xswift.buy.utils.CookieC;
import cn.xswift.buy.utils.LoginList;
import cn.xswift.buy.utils.Strings;

@Service
public class UserService {

	@Autowired
	private CheckLogin checkLogin;
	@Autowired
	private CookieC cookieC;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private SellerMapper sellerMapper;
	@Autowired
	private AlertAndResponse alertAndResponse;
	@Autowired
	private LoginList loginList;
	@Autowired
	private TransactionMapper transactionMapper;
	@Autowired
	private CartMapper cartMapper;
	
	private ComplaintMapper complaintMapper = new ComplaintMapper();
	/**
	 * 跳转至my
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView goMy(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("my");
		User u =null;
		if(checkLogin.checkLogin(request)) {
			if(cookieC.selectCookieValueByName(request, "isSeller").equals("true")) {
				u = userMapper.selectUserByIdForSeller(Long.parseLong(cookieC.selectCookieValueByName(request, "userId")));
				mv.addObject("userInfo", loginList.getSellerLoginList(u.getUserName(), u.getUserMoney(), u.isUserIsSeller(),sellerMapper.selectSellerImgsrc(u.getUserId())));
			}else {
				u = userMapper.selectUserById(Long.parseLong(cookieC.selectCookieValueByName(request, "userId")));
				mv.addObject("userInfo", loginList.getLoginList(u.getUserName(), u.getUserMoney(), u.isUserIsSeller()));
			}
		}
		else {
			mv.addObject("userInfo", Strings.USER_LOGIN_DIV);
		}
		return mv;
	}
	
	/**
	 * 跳至首页
	 * @return
	 */
	@Transactional
	public ModelAndView goIndex() {
		ModelAndView mv = new ModelAndView("main");
		List<Commodity> commodityList = commodityMapper.selectCommodityNewPublish();
		mv.addObject("commodityList", commodityList);
		return mv;
	}
	
	/**
	 * 跳至商家列表
	 * @return
	 */
	@Transactional
	public ModelAndView goShop() {
		ModelAndView mv = new ModelAndView("shop");
		List<Seller> sellerList = sellerMapper.selectSellerOpen();
		if(sellerList != null) {
			mv.addObject("sellerList", sellerList);
		}
		else {
			System.out.println("cucuo!");//-------------------------------
		}
		return mv;
	}
	
	/**
	 * 用户登录
	 * @param response
	 * @param userId
	 * @param userPassword
	 * @return
	 */
	@Transactional
	public ModelAndView userLogin(HttpServletResponse response,Long userId,String userPassword) {
		ModelAndView mv = new ModelAndView("refresh");
		User u = userMapper.selectUserById(userId);
		if(u!=null && u.getUserPassword().equals(userPassword)) {
			cookieC.addCookie(response, "userId", userId.toString(), 60*60);
			cookieC.addCookie(response, "status", "true", 60*60);
		}else {
			alertAndResponse.alertAndResponse(mv, "学号或密码错误！", "my.do");
		}
		return mv;
	}
	
	/**
	 * 用户退出
	 * @param request
	 * @param response
	 * @return
	 */
	@Transactional
	public ModelAndView userLogout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("refresh");
		cookieC.deleteCookieByName(request, response, "userId");
		cookieC.deleteCookieByName(request, response, "status");
		cookieC.deleteCookieByName(request, response, "isSeller");
		return mv;
	}
	
	/**
	 * 用户在商品详情页面点击购买
	 * @param request
	 * @param commodityId
	 * @return
	 */
	@Transactional
	public ModelAndView payment(long buyerId,int commodityId) {
		ModelAndView mv = new ModelAndView("refresh");
		long sellerId = commodityMapper.selectSellerIdByCommodityId(commodityId);
		if(buyerId != sellerId) {
			if(transactionMapper.insertTransaction(
					new Transaction(buyerId, sellerId, commodityId, 1, new Timestamp(System.currentTimeMillis()),"面提","无"))==1
					&& commodityMapper.updateStockMinusOneById(commodityId)==1
					) {
				alertAndResponse.alertAndResponse(mv, "购买成功", "index.do");
			}else {
				alertAndResponse.alertAndResponse(mv, "购买失败,可能库存不足", "index.do");
			}
		}else {
			alertAndResponse.alertAndResponse(mv, "你不能购买自己的商品", "index.do");
		}
		return mv;
	}
	
	/**
	 * 获取交易列表
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView getTransactionlist(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("transaction");
		long userId = Long.parseLong(cookieC.selectCookieValueByName(request, "userId"));
		List<Transaction> transactionList = new ArrayList<Transaction>();
		List<TransactionSimple> transactionSimpleList = new ArrayList<TransactionSimple>();
		
		String who = "";
		if(cookieC.selectCookieValueByName(request, "isSeller").equals("true")) {
			who = "卖家";
		}else {
			who = "买家";
		}
		
		transactionList = transactionMapper.selectTransactionByBuyerId(userId);
		if(transactionList==null) {
			alertAndResponse.alertAndResponse(mv, "交易记录为空", "my.do");
		}else {
			for(Transaction t:transactionList) {
				String commodityName = commodityMapper.selectCommodityNameById(t.getCommodityId());
				String sellerName = userMapper.selectUserNameById(t.getTransactionSellerId());
				String status = t.getTransactionFinishtime()==null?"已付款":"已完成";
				TransactionSimple ts =new TransactionSimple(commodityName, sellerName, status);
				transactionSimpleList.add(ts);
			}
			mv.addObject("who", who);
			mv.addObject("transactionSimpleList", transactionSimpleList);
		}
		return mv;
	}
	
	/**
	 * 获取已完成的订单的列表
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView getFinishtranlist(long userId) {
		ModelAndView mv = new ModelAndView("tranfinish");
		List<Transaction> transactionList = new ArrayList<Transaction>();
		transactionList = transactionMapper.selectTransactionByBuyerId(userId);
		if(transactionList==null) {
			alertAndResponse.alertAndResponse(mv, "交易记录为空", "my.do");
		}else {
			//不用foreach，且反向遍历
			if(transactionList.size()<1) {
				alertAndResponse.alertAndResponse(mv, "交易记录为空", "my.do");
				return mv;
			}
			for(int i = transactionList.size()-1 ; i>=0 ;i--) {
				Transaction t = transactionList.get(i);
				if(t.getTransactionFinishtime()!=null) {
					transactionList.remove(i);
					continue;
				}
				t.setCommodity(commodityMapper.selectCommodityById(t.getCommodityId()));
				t.setTransactionSellerName(userMapper.selectUserNameById(t.getTransactionSellerId()));
				t.setTransactionMoney(t.getCommodity().getCommodityPrice()*t.getTransactionNum());
			}
			mv.addObject("transactionList", transactionList);
		}
		return mv;
	}
	
	/**
	 * 用户点击‘完成订单’（操作）
	 * @param transactionId
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView userFinishtran(int transactionId) {
		ModelAndView mv = new ModelAndView("transaction");
		if(transactionMapper.updateFinishtimeById(new Timestamp(System.currentTimeMillis()), transactionId)==1) {
			return alertAndResponse.alertAndResponse(mv, "确认交易成功", "finishtranlist.do");
		}else {
			return alertAndResponse.alertAndResponse(mv, "确认交易失败", "finishtranlist.do");
		}
	}
	
	/**
	 * 从购物车移除商品（操作）
	 * @param commodityId
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView removeCommodity(int commodityId,long buyerId) {
		ModelAndView mv = new ModelAndView();
		if(cartMapper.deleteCart(commodityId,buyerId)==1) {
			return alertAndResponse.alertAndResponse(mv, "移除成功！", "shoppingcart.do");
		}else {
			return alertAndResponse.alertAndResponse(mv, "移除失败！", "shoppingcart.do");
		}
	}
	
	/**
	 * 搜索商品
	 * @param commodityName
	 * @return
	 */
	@Transactional
	public ModelAndView searchCommodity(String commodityName) {
		ModelAndView mv = new ModelAndView("searchlist");
		mv.addObject("cname", commodityName)
		  .addObject("clist", commodityMapper.selectForSearch(commodityName))
		  .addObject("num", commodityMapper.selectForSearchNum(commodityName));
		return mv;
	}
	
	/**
	 * 跳转至 确认订单 页面
	 * @param j
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView payConfirm(String j,long buyerId) {
		ModelAndView mv = new ModelAndView();
		//JSONObject jsonObj = new JSONObject(j);
			JSONArray json = new JSONArray(j);
			int commodityId = 0;
			int selectNum  = 0;
			double alltotal = 0;
			String cArr="";
			Map<Integer,Integer> carts = new HashMap<Integer,Integer>();
			if(json.length()>0){
				for(int i=0;i<json.length();i++){
					JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
					commodityId = Integer.parseInt(job.get("id")+"") ;  // 得到 每个对象中的属性值
					selectNum = Integer.parseInt(job.get("select")+"");
					carts.put(commodityId, selectNum);
				}
			}
			
			List<Commodity> commodityList = cartMapper.selectCartByBuyerId(buyerId);
			Commodity c = new Commodity();
			//这里不用foreach是为了对应list的顺序,而且是反向遍历。
			for( int i=(commodityList.size()-1) ; i >=0 ; i--) {
				c = commodityList.get(i);
				if((int)carts.get(c.getCommodityId()) == 0) {
					//如果用户选择个数为0，则直接移除。
					commodityList.remove(i);
					continue;
				}
				if(c.getCommodityStock()!=0) {
					c.setSelected(carts.get(c.getCommodityId())); //已选择个数
					c.setTotal( c.getCommodityPrice() * carts.get(c.getCommodityId()));//小计
					cArr = cArr + c.getCommodityId()+",";
					alltotal = alltotal + c.getTotal();
				}else {
					return alertAndResponse.alertAndResponse(mv, "可能某一件商品库存不足，请重新提交订单！", "shoppingcart.do");
				}
			}
			if(commodityList.size()==0) {
				return alertAndResponse.alertAndResponse(mv, "购物车为空或提交的订单为空！", "shoppingcart.do");
			}
			mv.addObject("userInfo", userMapper.selectUserById(buyerId));
			mv.addObject("alltotal", alltotal);
			mv.addObject("commodityList", commodityList);
			mv.addObject("cArr", cArr);
			mv.setViewName("pay");
		return mv;
	}
	
	/**
	 * 确认订单页面点击 ‘完成订单’
	 * @param j
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView payFinish(String j,long buyerId) {
		ModelAndView mv = new ModelAndView();
		//JSONObject jsonObj = new JSONObject(j);
			JSONArray json = new JSONArray(j);
			if(json.length()>0){
				for(int i=0;i<json.length();i++){
					JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
					Transaction tran = new Transaction();
					String mode = "";
					// 得到 每个对象中的属性值
					tran.setCommodityId(Integer.parseInt(job.get("id")+""));
					tran.setTransactionBuyerId(buyerId);
					tran.setTransactionSellerId(commodityMapper.selectSellerIdByCommodityId(Integer.parseInt(job.get("id")+"")));
					tran.setTransactionWords((String)job.get("words"));
					tran.setTransactionNum(Integer.parseInt(job.get("selected")+""));
					if(tran.getTransactionNum() > commodityMapper.selectStockById(tran.getCommodityId()) || tran.getTransactionNum()<=0) {
						//if 选择的数量>库存| 选择的数量<=0 ,都不行
						alertAndResponse.alertAndResponse(mv, "选择的数量有误", "shoppingcart.do");
						return mv;
					}
					tran.setTransactionPaytime(new Timestamp(System.currentTimeMillis()));
					switch (Integer.parseInt(job.get("mode")+"")) {
					case 1:
						mode="面提";
						break;
					case 2:
						mode="邮寄";
						break;
					case 3:
						mode="面提";
						break;
					default:
						return alertAndResponse.alertAndResponse(mv, "购买时出了点问题", "shoppingcart.do");
					}
					tran.setTransactionMode(mode);
					if(transactionMapper.insertTransaction(tran)==1) {
						commodityMapper.updateStockAnyNum(tran.getCommodityId(), tran.getTransactionNum());
						continue;
					}else {
						alertAndResponse.alertAndResponse(mv, "购买时出了点问题", "shoppingcart.do");
						return mv;
					}
				}
			}
			mv = alertAndResponse.alertAndResponse(mv, "完成付款", "finishtranlist.do");
		return mv;
	}
	
	/**
	 * 首页的分类选项进入
	 * @param kind
	 * @return
	 */
	@Transactional
	public ModelAndView getKind(int kind) {
		ModelAndView mv = new ModelAndView();
		String kindStr = "";
		switch (kind) {
		case 1: kindStr = "日用"; break;
		case 2: kindStr = "运动"; break;
		case 3: kindStr = "外卖"; break;
		case 4: kindStr = "数码"; break;
		case 5: kindStr = "图书"; break;
		case 6: kindStr = "其他"; break;
		default: alertAndResponse.alertAndResponse(mv, "出错", "index.do"); return mv;
		}
		List<Commodity> commodityList = commodityMapper.selectCommodityByKind(kindStr);
		mv.setViewName("kind");
		mv.addObject("title", kindStr);
		mv.addObject("commodityList", commodityList);
		return mv;
	}

	/**
	 * 获取投诉信息
	 * @return
	 */
	@Transactional
	public ModelAndView getComplaint() {
		ModelAndView mv = new ModelAndView();
		List<Complaint> complaintList = complaintMapper.selectComplaintUnhandle();
		mv.addObject("complaintList", complaintList);
		return mv;
	}
	
	/**
	 * 提交投诉信息（操作）
	 * @param commodityId
	 * @param content
	 * @return
	 */
	@Transactional
	public ModelAndView complaint(int commodityId,String content) {
		ModelAndView mv = new ModelAndView();
		Complaint complaint = new Complaint(commodityId, content);
		if(complaintMapper.insertComplaints(complaint)==1){
			return alertAndResponse.alertAndResponse(mv, "投诉信息提交成功", "index.do");
		}else {
			return alertAndResponse.alertAndResponse(mv, "投诉信息提交失败", "index.do");
		}
	}
	
	/**
	 * 跳转至 投诉信息 页面 
	 * @param commodityId
	 * @return
	 */
	@Transactional
	public ModelAndView complaintpage(int commodityId) {
		ModelAndView mv = new ModelAndView("complaint");
		Commodity commodity = commodityMapper.selectCommodityById(commodityId);
		Seller seller = sellerMapper.selectSellerById(commodity.getSellerId());
		mv.addObject("commodity", commodity);
		mv.addObject("seller", seller);
		return mv;
	}
}
