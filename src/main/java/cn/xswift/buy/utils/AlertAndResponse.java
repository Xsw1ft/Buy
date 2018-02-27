package cn.xswift.buy.utils;

import org.springframework.web.servlet.ModelAndView;

public class AlertAndResponse {

	/**
	 * mv:ģ����ͼ��content����Ҫalert�����ݣ�url�����ȷ������ת����ҳ�档
	 * */
	public ModelAndView alertAndResponse(ModelAndView mv,String content,String url) {
		mv.setViewName("alert");
		mv.addObject("content", "\""+content+"\"");
		mv.addObject("url", "\""+url+"\"");
		return mv;
	}
}
