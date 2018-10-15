package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddPayee12")
public class AddPayeeEntity {
	 private String payeeName;
	 @Id
     private int payeeAccNum;
     private String payeeNickName;
     private String ifsc;
     private int parentAccNo;
     
     
 	public int getParentAccNo() {
 		return parentAccNo;
 	}
 	public void setParentAccNo(int parentAccNo) {
 		this.parentAccNo = parentAccNo;
 	}
     
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getPayeeAccNum() {
		return payeeAccNum;
	}
	public void setPayeeAccNum(int payeeAccNum) {
		this.payeeAccNum = payeeAccNum;
	}
	public String getPayeeNickName() {
		return payeeNickName;
	}
	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
     
}
