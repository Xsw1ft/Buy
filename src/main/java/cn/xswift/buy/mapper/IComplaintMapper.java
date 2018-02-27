package cn.xswift.buy.mapper;

import java.util.List;

import cn.xswift.buy.entity.Complaint;

public interface IComplaintMapper {

	public int insertComplaint(Complaint complaint);
	public List<Complaint> selectComplaintUnhandle();
	public List<Complaint> selectComplaintHandle();
	public int updateHandle(Complaint complaint);
}
