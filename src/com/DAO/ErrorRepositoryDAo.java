package com.DAO;

import java.util.List;

import com.bean.AddPayee;
import com.bean.Contact;
import com.bean.Login;
import com.bean.ServiceRequest;
import com.bean.TransactionHistory;
import com.bean.accountInfo;



public interface ErrorRepositoryDAo {
	public int varifyData(Login login) throws Exception;
	public int getAccountNumberForMatching(String username) throws Exception;
	public boolean validateSourceAccount(int sourceAccount) throws Exception;
	public boolean validateTargetAccount(int targetAccount) throws Exception;
	public boolean validateTargetAccounteeName(int targetAccount,String accounteeName) throws Exception;
	public boolean validateAccountBalance(double amountTransfer,int accNo) throws Exception;
	public String successfulTransaction(TransactionHistory th) throws Exception;
	public String successfulTransactionOutsideBank(TransactionHistory th) throws Exception;
	public List<TransactionHistory> accountStatement(int number) throws Exception;
	public List<Contact> contactDAO() throws Exception;
	public List<TransactionHistory> search(TransactionHistory th,int number) throws Exception;
	public List<Integer> allAccountList() throws Exception;
	public List<accountInfo> getPerticularAccInfo(String uname) throws Exception;
	public int addPayeeWithin(AddPayee ap) throws Exception;
	public String addPayeeOthersBnak(AddPayee ap) throws Exception;
	public List<String> allPayeeListWithin(int accno) throws Exception;
	public List<String> allPayeeListOthers(int accno) throws Exception;
	public int signupverify(accountInfo ai) throws Exception;
	public List<String> allRequestId(int accnum)throws Exception;
	public void RegisterWithbank(Login l) throws Exception;
	public int createRequestDao(ServiceRequest sr)throws Exception;
	public String trackReuestDao(int trackingId,int accnum) throws Exception;
}
