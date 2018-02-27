package cn.xswift.buy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import cn.xswift.buy.entity.Commodity;

@Component
public class CreateHTML {
	
	
	public static void createHTML(String contentPath,Commodity commodity , String filename ,String urlPath,String sellerName,String sellerAddr,String sellerContactInfo) {
		StringBuffer html = new StringBuffer();
		
		html.append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width,initial-scale=0.0,user-scalable=no,minimum-scale=1.0,maximum-scale=1.0\" />\r\n" + 
				"		<meta name=\"keywords\" content=\"\" />\r\n" + 
				"		<meta name=\"description\" content=\"\" />\r\n" + 
				"		<meta name=\"author\" content=\"\" />\r\n" + 
				"		<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n" + 
				"		<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\" />\r\n" + 
				"		<meta name=\"format-detection\" content=\"telephone=no\" />\r\n" + 
				"		<link href=\"../../css/detail.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
				"		<title>商品详情</title>\r\n" + 
				"	</head>\r\n" + 
				"\r\n" + 
				"	<body style=\"overflow:-Scroll;overflow-x:hidden\">\r\n" + 
				"		<div class=\"container\">\r\n" + 
				"			<div class=\"header\">\r\n" + 
				"				");
		html.append("\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"detail_photo\">\r\n" + 
				"				<img src=\""+filename+"\" class=\"detail_photo\" height=\"300\" width=\"300\">\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"detail_text\">\r\n" + 
				"				<span class=\"detail_text_1\"><font color=\"#000000\" size=\"3px\">");
		html.append(commodity.getCommodityName());
		html.append("</font></span>\r\n" + 
				"				<span class=\"detail_text_3\"><font color=\"#FF0000\" size=\"2px\">");
		html.append("￥"+commodity.getCommodityPrice());
		html.append("</font></span>\r\n" + "\r\n" + 
				"				<span class=\"detail_text_4\"><font color=\"#000000\" size=\"2px\">卖家："+ sellerName +"</font></span>\r\n" + 
				"				<span class=\"detail_text_5\"><font color=\"#000000\" size=\"2px\">地址：" + sellerAddr + "</font></span>\r\n" + 
				"				<span class=\"detail_text_6\"><font color=\"#000000\" size=\"2px\">联系方式：" + sellerContactInfo + "</font></span>" +
				"			<a href=\"/buy/complaintpage.do?cid="+commodity.getCommodityId()+"\" class=\"detail_text_7\"><font color=\"#1E90FF\" size=\"2px\">不良信息？点击举报</font></a>"
				+ "</div>\r\n" + 
				"			<div class=\"detail_detpho\">\r\n" + 
				"				<div class=\"content\">\r\n") ; 
		html.append(commodity.getCommodityDescribe());		 
		html.append("				<br><br><br><br>\r\n" + 
				"				</div>\r\n" + 
				"					\r\n" + 
				"			</div>");
		html.append(
				"			<div class=\"footer\">\r\n<a href=\"/buy/index.do\" class=\"goindex\"><去首页</a>" + 
				"				<a href=\"http://"+urlPath+"/payment.do?commodityid="+commodity.getCommodityId()+"\" class=\"goumai\">\r\n" + 
				"					购买\r\n" + 
				"				</a>\r\n" + 
				"				<a href=\"http://" + urlPath +"/addCart.do?id="+ commodity.getCommodityId() +"\" class=\"shoucang\">\r\n" + 
				"					加入购物车\r\n" + 
				"				</a>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</body>\r\n" + 
				"\r\n" + 
				"</html>");
		
		OutputStream os = null;
		File htmlFile = new File(contentPath+File.separator+"commodity"+File.separator+commodity.getCommodityId()+File.separator+"commodity.html");
		try {
			os = new FileOutputStream(htmlFile);
			byte b[] = html.toString().getBytes();
		    os.write(b);
		    os.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	  	
	}
}
