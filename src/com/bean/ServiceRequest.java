package com.bean;

public class ServiceRequest {
	private String requestId;
	private String facilities;
	private String description;
	private String status;
	private int trackingId;
	private int parentAccNo;





	public int getParentAccNo() {
		return parentAccNo;
	}
    public void setParentAccNo(int parentAccNo) {
		this.parentAccNo = parentAccNo;
	}
	public int getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(int trackingId) {
		this.trackingId = trackingId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
