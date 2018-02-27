package cn.xswift.buy.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import cn.xswift.buy.entity.User;
import cn.xswift.buy.mapper.IUserMapper;
import cn.xswift.buy.mapper.Session;


public class UserMapper extends Session{
	
	public int insertUser(User user){
			
			int i = 0;
			SqlSession session = null;
			try {
				session = getSqlSessionFactory().openSession();
				IUserMapper mapper = session.getMapper(IUserMapper.class);
				i = mapper.insertUser(user);
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

	
	public User selectUserById(Long userId){
		User u = null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IUserMapper mapper = session.getMapper(IUserMapper.class);
			u = mapper.selectUserById(userId);
		}
		catch(Exception e){
		}
		finally{
			session.close();
		}
		return u;
	}
	public User selectUserByIdForSeller(Long userId){
		User u = null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IUserMapper mapper = session.getMapper(IUserMapper.class);
			u = mapper.selectUserByIdForSeller(userId);
		}
		catch(Exception e){
		}
		finally{
			session.close();
		}
		return u;
	}
	public User selectUserByName(String userName){
		User u = null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IUserMapper mapper = session.getMapper(IUserMapper.class);
			u = mapper.selectUserByName(userName);
		}
		catch(Exception e){
		}
		finally{
			session.close();
		}
		return u;
	}
	public String selectUserNameById(long userId){
		String userName = "";
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IUserMapper mapper = session.getMapper(IUserMapper.class);
			userName = mapper.selectUserNameById(userId);
		}
		catch(Exception e){
		}
		finally{
			session.close();
		}
		return userName;
	}
}
