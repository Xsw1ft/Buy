package cn.xswift.buy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.mapper.ICartMapper;
import cn.xswift.buy.mapper.Session;

@Repository
public class CartMapper extends Session{

	
	public int insertCart(long buyerId,int commodityId){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICartMapper mapper = session.getMapper(ICartMapper.class);
			i = mapper.insertCart(buyerId, commodityId);
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
	
	public List<Commodity> selectCartByBuyerId(long buyerId){

		SqlSession session = null;
		List<Commodity> commodityList = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICartMapper mapper = session.getMapper(ICartMapper.class);
			commodityList = mapper.selectCartByBuyerId(buyerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityList;
	}
	
	public int selectHasAdded(long buyerId,int commodityId){

		SqlSession session = null;
		int i = 0;
		try {
			session = getSqlSessionFactory().openSession();
			ICartMapper mapper = session.getMapper(ICartMapper.class);
			i = mapper.selectHasAdded(buyerId, commodityId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return i;
	}
	
	public int deleteCart(int commodityId,long buyerId){

		SqlSession session = null;
		int i = 0;
		try {
			session = getSqlSessionFactory().openSession();
			ICartMapper mapper = session.getMapper(ICartMapper.class);
			i = mapper.deleteCart(buyerId, commodityId);
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
