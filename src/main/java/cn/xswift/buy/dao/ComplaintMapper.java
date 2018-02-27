package cn.xswift.buy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.xswift.buy.entity.Complaint;
import cn.xswift.buy.mapper.IComplaintMapper;
import cn.xswift.buy.mapper.Session;

public class ComplaintMapper extends Session{

	public List<Complaint> selectComplaintHandle(){

		List<Complaint> complantList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IComplaintMapper mapper = session.getMapper(IComplaintMapper.class);
			complantList = mapper.selectComplaintHandle();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return complantList;
	}
	
	public List<Complaint> selectComplaintUnhandle(){

		List<Complaint> complantList= null;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IComplaintMapper mapper = session.getMapper(IComplaintMapper.class);
			complantList = mapper.selectComplaintUnhandle();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		return complantList;
	}
	
	public int insertComplaints(Complaint complaint){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IComplaintMapper mapper = session.getMapper(IComplaintMapper.class);
			i = mapper.insertComplaint(complaint);
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
	
	public int updateHandle(Complaint complaint){

		int i = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			IComplaintMapper mapper = session.getMapper(IComplaintMapper.class);
			i = mapper.updateHandle(complaint);
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
