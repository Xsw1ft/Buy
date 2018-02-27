package cn.xswift.buy.mapper;

import java.util.List;

import cn.xswift.buy.entity.Seller;

public interface ISellerMapper {
	public List<Seller> selectSellerOpen();
	public List<Seller> selectSellerApply();
	public Seller selectSellerById(long sellerId);
	public int selectSellerStatus(long sellerId);
	public String selectSellerImgsrc(long sellerId);
	public int insertSeller(Seller seller);
	public int updateSellerStatusAgreeById(long ellerId);
	public int updateSellerStatusDisagreeById(long ellerId);
}
