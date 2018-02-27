package cn.xswift.buy.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xswift.buy.entity.Transaction;

public interface ITransactionMapper {
	public List<Transaction> selectTransactionByBuyerId(Long buyerId);
	public List<Transaction> selectTransactionBySellerId(Long sellerId);
	public int insertTransaction(Transaction tansaction);
	public int updateFinishtimeById(@Param("transactionFinishtime")Timestamp transactionFinishtime,@Param("transactionId") int transactionId);
}
