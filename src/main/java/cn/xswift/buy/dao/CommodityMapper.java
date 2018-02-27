package cn.xswift.buy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cn.xswift.buy.entity.Commodity;
import cn.xswift.buy.mapper.ICommodityMapper;
import cn.xswift.buy.mapper.Session;

@Repository
public class CommodityMapper extends Session{

	public List<Commodity> selectCommodityNewPublish(){

		List<Commodity> commodityList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodityList = mapper.selectCommodityNewPublish();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityList;
	}
	public List<Commodity> selectCommodityByKind(String commodityKind){

		List<Commodity> commodityList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodityList = mapper.selectCommodityByKind(commodityKind);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityList;
	}
	public List<Commodity> selectCommodityBySellerIdNotZero(long sellerId){

		List<Commodity> commodityList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodityList = mapper.selectCommodityBySellerIdNotZero(sellerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityList;
	}
	public List<Commodity> selectCommodityBySellerId(long sellerId){

		List<Commodity> commodityList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodityList = mapper.selectCommodityBySellerIdNotZero(sellerId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityList;
	}
	public List<Commodity> selectForSearch(String commodityName){

		List<Commodity> commodityList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodityList = mapper.selectForSearch(commodityName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityList;
	}
	public int selectForSearchNum(String commodityName){

		int num = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			num = mapper.selectForSearchNum(commodityName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return num;
	}
	public int deleteCommodityById(int commodityId){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			i = mapper.deleteCommodityById(commodityId);
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
	public long selectSellerIdByCommodityId(int commodityId){

		long sellerId = 0L;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			sellerId = mapper.selectSellerIdByCommodityId(commodityId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return sellerId;
	}
	public int selectStockById(int commodityId){

		int stock = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			stock = mapper.selectStockById(commodityId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return stock;
	}
	public String selectCommodityNameById(int commodityId){

		String commodityName = "";
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodityName = mapper.selectCommodityNameById(commodityId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodityName;
	}
	
	public Commodity selectCommodityById(int commodityId){

		Commodity commodity=null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			commodity = mapper.selectCommodityById(commodityId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return commodity;
	}
	public int insertCommodity(Commodity commodity){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			i = mapper.insertCommodity(commodity);
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

	public int updateCommodityById(Commodity commodity){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			i = mapper.updateCommodityById(commodity);
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
	
	public int updateStockMinusOneById(int commodityId){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			i = mapper.updateStockMinusOneById(commodityId);
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
	
	public int updateStockAnyNum(int commodityId,int tranNum){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			ICommodityMapper mapper = session.getMapper(ICommodityMapper.class);
			i = mapper.updateStockAnyNum(commodityId,tranNum);
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
