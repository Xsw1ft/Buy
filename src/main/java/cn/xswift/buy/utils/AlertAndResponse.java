package cn.xswift.buy.utils;

import org.springframework.web.servlet.ModelAndView;

public class AlertAndResponse {

	/**
	 * mv:模型视图，content：需要alert的内容，url：点击确定后跳转至的页面。
	 * */
	public ModelAndView alertAndResponse(ModelAndView mv,String content,String url) {
		mv.setViewName("alert");
		mv.addObject("content", "\""+content+"\"");
		mv.addObject("url", "\""+url+"\"");
		return mv;
	}
}
