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
	 * �Է�����Ʒ�ı����д���
	 * 1����ȡname price describe ʵ����һ��Commodity����.
	 * 2���������ݿⲢ���صõ�commodityId.
	 * 3��ͨ��commodityId������commodityIdΪ���ֵ��ļ��У��ļ����·�����Ʒhtml��img��Դ.
	 * 4������img���ļ�����.
	 * 5������html
	 * 6������commodity��htmlSrc��imgSrc
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
		CookieC c = new CookieC(); //���ڻ�ȡcookie�ڵ�userId
		CommodityMapper cm = new CommodityMapper(); //dao
		String imgPath = "";
		String contentPath = request.getSession().getServletContext().getRealPath(""); //��ĿPATH
		String urlPath = request.getServerName()+":"+request.getLocalPort()+request.getContextPath();
		String contextPath = request.getContextPath();
		String imgSrc = "";
		String htmlSrc = "";
		String filename = "";
		Commodity commodity = null;
		Seller seller = null;
		SellerMapper sm = new SellerMapper();
		boolean status=false; //�����жϷ�����Ʒ�Ƿ�ɹ�
		
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
					if(name.equals("cname")) {
						commodityName = XSSDefender.XSSDefenders(item.getString("UTF-8"));
					}
					if(name.equals("cprice")) {
						commodityPrice = Double.parseDouble(item.getString("UTF-8"));
					}
					if(name.equals("cdescribe")) {
						commodityDescribe = XSSDefender.XSSDefenders(item.getString("UTF-8"));//HTML Entity����
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
							//����commodity�ļ���
							File folder=new File(contentPath+File.separator+"commodity"+File.separator+commodity.getCommodityId());
							if(folder.exists()) {
							}else {
								folder.mkdir();
							}
							createTimes = 1;
						}
					}
					//value = new String(value.getBytes("iso8859-1"),"UTF-8");
				}else{//���fileitem�з�װ�����ϴ��ļ�
					//�õ��ϴ����ļ����ƣ�
					filename = item.getName();
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					//ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·���ģ��磺  c:\a\b\1.txt������Щֻ�ǵ������ļ������磺1.txt
					//�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//��ȡitem�е��ϴ��ļ���������
					InputStream in = item.getInputStream();
					//����һ���ļ������
					imgPath = contentPath+File.separator+"commodity"+File.separator+commodity.getCommodityId();
					imgSrc = contextPath + File.separator + "commodity" + File.separator + commodity.getCommodityId() + File.separator + filename;
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
					if(commodity!=null) {
						break;//����ȡһ��ͼƬ
					}
				}
			}
			//��ȡ�����
			
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
