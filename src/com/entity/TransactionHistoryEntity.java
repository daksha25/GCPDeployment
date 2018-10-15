package com.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="TransactionData")
@SequenceGenerator(name = "id_generat", sequenceName = "RTDS_ADSINPUT_SEQ" )
public class TransactionHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generat")
	private int transactionId;
	
	private Date transactionDate; 
	private String transactionType; 
	private double amountTransferred;
	private int sourceAccountNo;
	private int targetAccountNo;
	private Timestamp transactionTimeStamp;
    private String ifsc;

    private String type;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	
	
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
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
