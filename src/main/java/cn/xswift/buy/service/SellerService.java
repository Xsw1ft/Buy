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
	 * �����̼�����ҳ�������̼���Ϣ���̼��ϼܵ���Ʒ��
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
	 * �̼ҵ�¼�������� 
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
				alertAndResponse.alertAndResponse(mv, "�˻������", "my.do");
			}
		}else {
			alertAndResponse.alertAndResponse(mv, "�û������������", "my.do");
		}
		return mv;
	}
	
	/**
	 * ��ת��������Ʒҳ��
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView publishCommodity() {
		return new ModelAndView("putOnSale");
	}
	
	/**
	 * �̼�ע�ᣨ������
	 * @param request
	 * @return
	 */
	@Transactional
	public ModelAndView sellerRegist(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("my");
		if(sellerRegist.sellerRegist(request)) {
			return alertAndResponse.alertAndResponse(mv, "������Ϣ�ύ�ɹ��������ĵȴ����", "index.do");
		}else{
			return alertAndResponse.alertAndResponse(mv, "����ʧ��,�������ύ����Ϣ������", "my.do");
		}
	}
	
	/**
	 * ��ȡ����ע����̼��б�
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
	 * ����̼ң�������
	 * @param sellerId
	 * @param sellerStatus
	 * @return
	 */
	@Transactional
	public ModelAndView agreeSeller(long sellerId,String sellerStatus) {
		ModelAndView mv = new ModelAndView();
		String status = "";
		if (sellerStatus.equals("true")) {
			//ͬ��ע��
			if(sellerMapper.updateSellerStatusAgreeById(sellerId)==1) {
				status = "��˳ɹ�";
			}else {
				status = "���ʧ��";
			}
		}else if(sellerStatus.equals("false")){
			//��ͬ��ע��
			if(sellerMapper.updateSellerStatusDisagreeById(sellerId)==1) {
				status = "��˳ɹ�";
			}else {
				status = "���ʧ��";
			}
		}
		return alertAndResponse.alertAndResponse(mv, status, "sellerapplylist.do");
	}
	
	/**
	 * ��ת���༭�б�ҳ��
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
	 * ��ת���༭ҳ��
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
