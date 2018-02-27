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
		String contentPath = request.getSession().getServletContext().getRealPath(""); //��ĿPATH
		String contextPath = request.getContextPath();
		String filename = "";
		String imgPath = "";
		String imgSrc = "";
		User user = null;
		Seller seller = null;
		boolean status = false;
		UserMapper um = new UserMapper();
		SellerMapper sm = new SellerMapper();
		
		DiskFileItemFactory factory = new DiskFileItemFactory(); //1������һ��DiskFileItemFactory����
		ServletFileUpload upload = new ServletFileUpload(factory); //2������һ���ļ��ϴ�������
		upload.setHeaderEncoding("UTF-8");//����ϴ��ļ�������������
		if(!ServletFileUpload.isMultipartContent(request)){
			return false;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);//4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
			for(FileItem item : list){
				//���fileitem�з�װ������ͨ�����������
				if(item.isFormField()){
					String name = item.getFieldName();
					//û��jre1.7������switch T T
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
				}else{//���fileitem�з�װ�����ϴ��ļ�
					//�õ��ϴ����ļ����ƣ�
//					filename = item.getName();
//					if(filename==null || filename.trim().equals("")){
//						continue;
//					}
//					//ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
//					//�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
//					filename = filename.substring(filename.lastIndexOf("\\")+1);
					filename = user.getUserId()+".jpg";
					//��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					//����һ���ļ������
					imgPath = contentPath + File.separator+"img"+File.separator+"sellerheadimg";//ʵ�������ַ�����������ľ��Ե�ַ
					imgSrc = contextPath + File.separator+"img"+File.separator+"sellerheadimg" + File.separator + filename;//��Ŀ����Ե�ַ�����ڶ�ȡͼƬ���ݵĵ�ַ
					FileOutputStream out = new FileOutputStream(imgPath + File.separator + filename);
					//����һ��������
					byte buffer[] = new byte[1024];
					//�ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					//ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
					while((len=in.read(buffer))>0){
						//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
						out.write(buffer, 0, len);
					}
					//�ر�������
					in.close();
					//�ر������
					out.close();
					//ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					item.delete();
					
					seller = new Seller(user.getUserId(), imgSrc, sellerAddr, sellerSellInfo, 2);
					sm.insertSeller(seller);
					if(seller!=null) {
						break;//����ȡһ��ͼƬ
					}
				}
			}
			//��ȡ�����
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
