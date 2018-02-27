package cn.xswift.buy.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xswift.buy.entity.Commodity;

public interface ICommodityMapper {
	public int insertCommodity(Commodity commodity);
	public int updateCommodityById(Commodity commodity);
	public int updateStockMinusOneById(int commodityId);
	public int updateStockAnyNum(@Param(value="commodityId") int commodityId,@Param(value="tranNum") int tranNum);
	public int deleteCommodityById(int commodityId);
	public int selectForSearchNum(String commodityName);
	public List<Commodity> selectCommodityNewPublish();
	public List<Commodity> selectCommodityByKind(String commodityKind);
	public List<Commodity> selectForSearch(String commodityName);
	public List<Commodity> selectCommodityBySellerIdNotZero(long sellerId);
	public List<Commodity> selectCommodityBySellerId(long sellerId);
	public long selectSellerIdByCommodityId(int commodityId);
	public int selectStockById(int commodityId);
	public String selectCommodityNameById(int commodityId);
	public Commodity selectCommodityById(int commodityId);
}
