package com.bean;

import java.sql.Timestamp;
import java.util.Date;

public class TransactionHistory {
	private int transactionId;
	private Date transactionDate; 
	private String transactionType; 
	private double amountTransferred;
	private int sourceAccountNo;
	private int targetAccountNo;
	private Timestamp transactionTimeStamp;
	private String ifsc;
	private String targetAccounteeName;
	private Date startDate;
	private Date endDate;
	private String type;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getTargetAccounteeName() {
		return targetAccounteeName;
	}
	public void setTargetAccounteeName(String targetAccounteeName) {
		this.targetAccounteeName = targetAccounteeName;
	}
	public int getSourceAccountNo() {
		return sourceAccountNo;
	}
	public void setSourceAccountNo(int sourceAccountNo) {
		this.sourceAccountNo = sourceAccountNo;
	}
	public int getTargetAccountNo() {
		return targetAccountNo;
	}
	public void setTargetAccountNo(int targetAccountNo) {
		this.targetAccountNo = targetAccountNo;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(double amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	public Timestamp getTransactionTimeStamp() {
		return transactionTimeStamp;
	}
	public void setTransactionTimeStamp(Timestamp transactionTimeStamp) {
		this.transactionTimeStamp = transactionTimeStamp;
	}
}
