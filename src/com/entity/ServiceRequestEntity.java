package com.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ServiceRequest1")
@SequenceGenerator(name = "id_generat1", sequenceName = "RTDS_ADSINPUT_SEQ" )
public class ServiceRequestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generat1")
    private int requestId;
	@Column(name="requestarea")
	private String Facilities;
	private String Description;
	private String Status;
	private int parentAccNo;





	public int getParentAccNo() {
		return parentAccNo;
	}
    public void setParentAccNo(int parentAccNo) {
		this.parentAccNo = parentAccNo;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	
	public String getFacilities() {
		return Facilities;
	}
	public void setFacilities(String facilities) {
		Facilities = facilities;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
}
