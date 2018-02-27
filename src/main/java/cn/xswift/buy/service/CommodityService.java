package cn.xswift.buy.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.xswift.buy.dao.CommodityMapper;
import cn.xswift.buy.utils.AlertAndResponse;
import cn.xswift.buy.utils.CookieC;

public class CommodityService {

	@Autowired
	private CookieC cookieC;
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private AlertAndResponse alertAndResponse;
	
	
	@Transactional
	public ModelAndView putOnSale(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if(cn.xswift.buy.utils.PublishCommodity.publishCommodity(request)) {
			mv = alertAndResponse.alertAndResponse(mv, "������Ʒ�ɹ�", "index.do");
		}
		else {
			mv = alertAndResponse.alertAndResponse(mv, "������Ʒʧ��", "index.do");
		}
		return mv;
	}
	
	@Transactional
	public ModelAndView edit(int commodityId,long sellerIdInCookie,String ppath,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		long sellerId = commodityMapper.selectSellerIdByCommodityId(commodityId);
		//!!!!�ж��Ƿ��в���Ȩ��
		if(sellerId != sellerIdInCookie) {
			alertAndResponse.alertAndResponse(mv, "��û�в���Ȩ��", "index.do");
			return mv;
		}
		//ɾ�������ļ�
		File f = new File(ppath+File.separator+"commodity"+File.separator+commodityId+File.separator);
		File[]fs = f.listFiles();
		if(fs!=null && fs.length>0) {
			for(File c:fs) {
				if(c.exists()) {
					c.delete();
				}
			}
		}
		if(f.exists()) {
			f.delete();
		}
		//�������ļ�
		if(cn.xswift.buy.utils.PublishCommodity.publishCommodity(request) == false) {
			mv = alertAndResponse.alertAndResponse(mv, "�༭��Ʒʧ��", "editlist.do");
			return mv;
		}
		//ɾ�����ݿ��е�����
		commodityMapper.deleteCommodityById(commodityId);
		mv = alertAndResponse.alertAndResponse(mv, "�༭��Ʒ�ɹ�", "editlist.do");
		return mv;
	}
	
	@Transactional
	public ModelAndView cdown(int commodityId,long sellerIdInCookie,String ppath) {
		ModelAndView mv = new ModelAndView();
		long sellerId = commodityMapper.selectSellerIdByCommodityId(commodityId);
		if(sellerId != sellerIdInCookie) {
			alertAndResponse.alertAndResponse(mv, "��û�в���Ȩ��", "index.do");
			return mv;
		}
		//ɾ�������ļ�
		File f = new File(ppath+File.separator+"commodity"+File.separator+commodityId+File.separator);
		File[]fs = f.listFiles();
		if(fs!=null && fs.length>0) {
			for(File c:fs) {
				if(c.exists()) {
					c.delete();
				}
			}
		}
		if(f.exists()) {
			f.delete();
		}
		//ɾ�����ݿ��е�����
		if(commodityMapper.deleteCommodityById(commodityId)==0) {
			return alertAndResponse.alertAndResponse(mv, "�¼�ʧ��", "editlist.do");
		}
		return alertAndResponse.alertAndResponse(mv, "�¼ܳɹ�", "editlist.do");
	}
}
