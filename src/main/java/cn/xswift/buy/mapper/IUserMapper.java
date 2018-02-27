package cn.xswift.buy.mapper;

import cn.xswift.buy.entity.User;

public interface IUserMapper {
	public User selectUserById(Long userId);
	public User selectUserByIdForSeller(Long userId);
	public User selectUserByName(String userName);
	public String selectUserNameById(Long userId);
	public int insertUser(User user);
}
