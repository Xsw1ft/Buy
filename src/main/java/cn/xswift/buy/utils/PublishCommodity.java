package cn.xswift.buy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.xswift.buy.dao.CommodityMapper;
import cn.xswift.buy.dao.SellerMapper;
import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.entity.Seller;
import cn.xswift.buy.utils.CookieC;

public class PublishCommodity {

	/**
	 * 对发布商品的表单进行处理。
	 * 1、获取name price describe 实例化一个Commodity对象.
	 * 2、插入数据库并返回得到commodityId.
	 * 3、通过commodityId创建以commodityId为名字的文件夹，文件夹下放置商品html和img资源.
	 * 4、保存img到文件夹下.
	 * 5、创建html
	 * 6、更新commodity的htmlSrc和imgSrc
	 * @param request
	 * @return void
	 * */
	public static boolean publishCommodity(
			HttpServletRequest request) {
		String commodityName = "";
		double commodityPrice = 0;
		String commodityDescribe = "";
		String commodityKind = "";
		int commodityStock = 0;
		int createTimes = 0;
		CookieC c = new CookieC(); //用于获取cookie内的userId
		CommodityMapper cm = new CommodityMapper(); //dao
		String imgPath = "";
		String contentPath = request.getSession().getServletContext().getRealPath(""); //项目PATH
		String urlPath = request.getServerName()+":"+request.getLocalPort()+request.getContextPath();
		String contextPath = request.getContextPath();
		String imgSrc = "";
		String htmlSrc = "";
		String filename = "";
		Commodity commodity = null;
		Seller seller = null;
		SellerMapper sm = new SellerMapper();
		boolean status=false; //用于判断发布商品是否成功
		
		DiskFileItemFactory factory = new DiskFileItemFactory(); //1、创建一个DiskFileItemFactory工厂
		ServletFileUpload upload = new ServletFileUpload(factory); //2、创建一个文件上传解析器
		upload.setHeaderEncoding("UTF-8");//解决上传文件名的中文乱码
		if(!ServletFileUpload.isMultipartContent(request)){
			return false;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);//4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			for(FileItem item : list){
				//如果fileitem中封装的是普通输入项的数据
				if(item.isFormField()){
					String name = item.getFieldName();
					if(name.equals("cname")) {
						commodityName = XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(name.equals("cprice")) {
						commodityPrice = Double.parseDouble(item.getString("UTF-8"));
					}
					if(name.equals("cdescribe")) {
						commodityDescribe = XSSDefender.XSSDefenders(item.getString("UTF-8"));//HTML Entity编码
					}
					if(name.equals("cstock")) {
						commodityStock = Integer.parseInt((item.getString("UTF-8")));
					}
					if(name.equals("ckind")) {
						commodityKind = XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(commodityName!="" && commodityPrice >0 && commodityDescribe!="" && commodityStock !=0 && commodityKind!="" && createTimes==0) {
						commodity = new Commodity(Long.parseLong(c.selectCookieValueByName(request, "userId")), commodityName, commodityPrice, commodityDescribe, new Timestamp(System.currentTimeMillis()),commodityStock,commodityKind);
						if(cm.insertCommodity(commodity)==1) {
							//创建commodity文件夹
							File folder=new File(contentPath+File.separator+"commodity"+File.separator+commodity.getCommodityId());
							if(folder.exists()) {
							}else {
								folder.mkdir();
							}
							createTimes = 1;
						}
					}
					//value = new String(value.getBytes("iso8859-1"),"UTF-8");
				}else{//如果fileitem中封装的是上传文件
					//得到上传的文件名称，
					filename = item.getName();
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					//创建一个文件输出流
					imgPath = contentPath+File.separator+"commodity"+File.separator+commodity.getCommodityId();
					imgSrc = contextPath + File.separator + "commodity" + File.separator + commodity.getCommodityId() + File.separator + filename;
					FileOutputStream out = new FileOutputStream(imgPath + File.separator + filename);
					//创建一个缓冲区
					byte buffer[] = new byte[1024];
					//判断输入流中的数据是否已经读完的标识
					int len = 0;
					//循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while((len=in.read(buffer))>0){
						//使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						out.write(buffer, 0, len);
					}
					//关闭输入流
					in.close();
					//关闭输出流
					out.close();
					//删除处理文件上传时生成的临时文件
					item.delete();
					if(commodity!=null) {
						break;//仅读取一张图片
					}
				}
			}
			//读取表单完成
			
			htmlSrc = contextPath + File.separator + "commodity" + File.separator + commodity.getCommodityId() + File.separator + "commodity.html";
			commodity.setCommodityHtmlsrc(htmlSrc);
			commodity.setCommodityImgsrc(imgSrc);
			seller = sm.selectSellerById(commodity.getSellerId());
			String sellerName = seller.getSellerName();
			String sellerAddr = seller.getSellerAddr();
			String sellerContactInfo = seller.getSellerContactInfo();
			cn.xswift.buy.utils.CreateHTML.createHTML(contentPath, commodity, filename ,urlPath,sellerName,sellerAddr,sellerContactInfo);
			if(cm.updateCommodityById(commodity)==1) {
				status = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
