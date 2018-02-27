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
			mv = alertAndResponse.alertAndResponse(mv, "发布商品成功", "index.do");
		}
		else {
			mv = alertAndResponse.alertAndResponse(mv, "发布商品失败", "index.do");
		}
		return mv;
	}
	
	@Transactional
	public ModelAndView edit(int commodityId,long sellerIdInCookie,String ppath,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		long sellerId = commodityMapper.selectSellerIdByCommodityId(commodityId);
		//!!!!判断是否有操作权限
		if(sellerId != sellerIdInCookie) {
			alertAndResponse.alertAndResponse(mv, "你没有操作权限", "index.do");
			return mv;
		}
		//删除现有文件
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
		//生成新文件
		if(cn.xswift.buy.utils.PublishCommodity.publishCommodity(request) == false) {
			mv = alertAndResponse.alertAndResponse(mv, "编辑商品失败", "editlist.do");
			return mv;
		}
		//删除数据库中的数据
		commodityMapper.deleteCommodityById(commodityId);
		mv = alertAndResponse.alertAndResponse(mv, "编辑商品成功", "editlist.do");
		return mv;
	}
	
	@Transactional
	public ModelAndView cdown(int commodityId,long sellerIdInCookie,String ppath) {
		ModelAndView mv = new ModelAndView();
		long sellerId = commodityMapper.selectSellerIdByCommodityId(commodityId);
		if(sellerId != sellerIdInCookie) {
			alertAndResponse.alertAndResponse(mv, "你没有操作权限", "index.do");
			return mv;
		}
		//删除现有文件
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
		//删除数据库中的数据
		if(commodityMapper.deleteCommodityById(commodityId)==0) {
			return alertAndResponse.alertAndResponse(mv, "下架失败", "editlist.do");
		}
		return alertAndResponse.alertAndResponse(mv, "下架成功", "editlist.do");
	}
}
