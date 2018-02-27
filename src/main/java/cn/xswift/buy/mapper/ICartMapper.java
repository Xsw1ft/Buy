package cn.xswift.buy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xswift.buy.entity.Commodity;

public interface ICartMapper {
	public int insertCart(@Param("buyerId") long buyerId,@Param("commodityId") int commodityId);
	public int selectHasAdded(@Param("buyerId") long buyerId,@Param("commodityId") int commodityId);
	public List<Commodity> selectCartByBuyerId(@Param("buyerId") long buyerId);
	public int deleteCart(@Param("buyerId") long buyerId,@Param("commodityId") int commodityId);
}
