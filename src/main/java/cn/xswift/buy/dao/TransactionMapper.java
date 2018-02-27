package cn.xswift.buy.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.entity.Transaction;
import cn.xswift.buy.mapper.ICommodityMapper;
import cn.xswift.buy.mapper.ITransactionMapper;
import cn.xswift.buy.mapper.Session;

public class TransactionMapper extends Session{

	public int insertTransaction(Transaction tansaction){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ITransactionMapper mapper = session.getMapper(ITransactionMapper.class);
			i = mapper.insertTransaction(tansaction);
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
	
	public List<Transaction> selectTransactionByBuyerId(long buyerId){

		List<Transaction> transactionList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ITransactionMapper mapper = session.getMapper(ITransactionMapper.class);
			transactionList = mapper.selectTransactionByBuyerId(buyerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return transactionList;
	}
	
	public List<Transaction> selectTransactionBySellerId(long sellerId){

		List<Transaction> transactionList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ITransactionMapper mapper = session.getMapper(ITransactionMapper.class);
			transactionList = mapper.selectTransactionBySellerId(sellerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return transactionList;
	}
	public int updateFinishtimeById(Timestamp transactionFinishtime,int transactionId){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ITransactionMapper mapper = session.getMapper(ITransactionMapper.class);
			i = mapper.updateFinishtimeById(transactionFinishtime,transactionId);
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
