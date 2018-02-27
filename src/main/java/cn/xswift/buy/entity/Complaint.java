package cn.xswift.buy.entity;

public class Complaint {

	private int complaintId;
	private int commodityId;
	private String content;
	private String complaintHandle;
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public int getCommodityId() {
		return commodityId;
	}
	public void setCommodityId(int commodityId) {
		this.commodityId = commodityId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getComplaintHandle() {
		return complaintHandle;
	}
	public void setComplaintHandle(String complaintHandle) {
		this.complaintHandle = complaintHandle;
	}
	public Complaint(int complaintId, int commodityId, String content, String complaintHandle) {
		super();
		this.complaintId = complaintId;
		this.commodityId = commodityId;
		this.content = content;
		this.complaintHandle = complaintHandle;
	}
	public Complaint(int complaintId, int commodityId, String content) {
		super();
		this.complaintId = complaintId;
		this.commodityId = commodityId;
		this.content = content;
	}
	public Complaint() {
		super();
	}
	public Complaint(int commodityId, String content) {
		super();
		this.commodityId = commodityId;
		this.content = content;
	}
	
	
}
