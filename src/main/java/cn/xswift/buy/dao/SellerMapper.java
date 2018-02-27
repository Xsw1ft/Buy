package cn.xswift.buy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.entity.Seller;
import cn.xswift.buy.mapper.ICommodityMapper;
import cn.xswift.buy.mapper.ISellerMapper;
import cn.xswift.buy.mapper.Session;

public class SellerMapper extends Session{

	public List<Seller> selectSellerOpen(){

		List<Seller> sellerList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			sellerList = mapper.selectSellerOpen();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return sellerList;
	}
	public List<Seller> selectSellerApply(){

		List<Seller> sellerList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			sellerList = mapper.selectSellerApply();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return sellerList;
	}
	public Seller selectSellerById(long sellerId){

		Seller seller = null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			seller = mapper.selectSellerById(sellerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return seller;
	}
	public int selectSellerStatus(long sellerId){

		int status=0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			status = mapper.selectSellerStatus(sellerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return status;
	}
	public String selectSellerImgsrc(long sellerId){

		String imgsrc=null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			imgsrc = mapper.selectSellerImgsrc(sellerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return imgsrc;
	}
	public int insertSeller(Seller seller){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			i = mapper.insertSeller(seller);
			session.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return i;
	}
	
	public int updateSellerStatusAgreeById(long sellerId){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			i = mapper.updateSellerStatusAgreeById(sellerId);
			session.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return i;
	}
	public int updateSellerStatusDisagreeById(long sellerId){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ISellerMapper mapper = session.getMapper(ISellerMapper.class);
			i = mapper.updateSellerStatusDisagreeById(sellerId);
			session.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return i;
	}
}
