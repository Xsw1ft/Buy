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

import cn.xswift.buy.dao.SellerMapper;
import cn.xswift.buy.dao.UserMapper;
import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.entity.Seller;
import cn.xswift.buy.entity.User;

public class SellerRegist {

	public boolean sellerRegist(HttpServletRequest request) {
		String sellerName = "",sellerPassword = "",sellerSellInfo = "",sellerAddr = "",sellerContactInfo = "";
		String contentPath = request.getSession().getServletContext().getRealPath(""); //项目PATH
		String contextPath = request.getContextPath();
		String filename = "";
		String imgPath = "";
		String imgSrc = "";
		User user = null;
		Seller seller = null;
		boolean status = false;
		UserMapper um = new UserMapper();
		SellerMapper sm = new SellerMapper();
		
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
					//没调jre1.7，不能switch T T
					if(name.equals("sname")) {
						sellerName = XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(name.equals("spwd")) {
						sellerPassword = XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(name.equals("ssell")) {
						sellerSellInfo = XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(name.equals("saddr")) {
						sellerAddr =XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(name.equals("scontact")) {
						sellerContactInfo =XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(sellerName.length()!=0 && sellerPassword.length()!=0 && sellerSellInfo.length()!=0 && sellerAddr.length()!=0 && sellerContactInfo.length()!=0) {
						user = new User(sellerName, sellerPassword, 0.0, true, sellerContactInfo);
						if(um.insertUser(user)==1)
							status = true;
					}else {
						status = false;
					}
					//value = new String(value.getBytes("iso8859-1"),"UTF-8");
				}else{//如果fileitem中封装的是上传文件
					//得到上传的文件名称，
//					filename = item.getName();
//					if(filename==null || filename.trim().equals("")){
//						continue;
//					}
//					//注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
//					//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
//					filename = filename.substring(filename.lastIndexOf("\\")+1);
					filename = user.getUserId()+".jpg";
					//获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					//创建一个文件输出流
					imgPath = contentPath + File.separator+"img"+File.separator+"sellerheadimg";//实际输出地址，即服务器的绝对地址
					imgSrc = contextPath + File.separator+"img"+File.separator+"sellerheadimg" + File.separator + filename;//项目的相对地址，用于读取图片数据的地址
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
					
					seller = new Seller(user.getUserId(), imgSrc, sellerAddr, sellerSellInfo, 2);
					sm.insertSeller(seller);
					if(seller!=null) {
						break;//仅读取一张图片
					}
				}
			}
			//读取表单完成
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
