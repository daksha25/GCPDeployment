package com.service;

import java.util.ArrayList;
import java.util.List;
import com.DAO.ErrorRepositoryDAo;
import com.bean.AddPayee;
import com.bean.Contact;
import com.bean.Login;
import com.bean.ServiceRequest;
import com.bean.TransactionHistory;

import com.bean.accountInfo;
import com.resource.Factory;
// Service class
public class ErrorRepositoryServiceImpl implements ErrorRepositoryService{
    
	
	 
	public int varifyData(Login login) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		int number=erDao.varifyData(login);
		return number;
	}
	
	public int getAccountNumberForMatching(String username) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		int number=erDao.getAccountNumberForMatching(username);
		return number;
	}
	
	public boolean validateSourceAccount(int sourceAccount) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		boolean flag=erDao.validateSourceAccount(sourceAccount);
		return flag;
	}
	public boolean validateTargetAccount(int targetAccount) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		boolean flag=erDao.validateTargetAccount(targetAccount);
		return flag;
	}
	
	public boolean validateTargetAccounteeName(int targetAccount,String accounteeName) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		boolean flag=erDao.validateTargetAccounteeName(targetAccount, accounteeName);
		return flag;
	}
	
	public boolean validateAccountBalance(double amountTransfer,int accNo) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		boolean flag=erDao.validateAccountBalance(amountTransfer, accNo);
		return flag;
	}
	
	public String successfulTransaction(TransactionHistory th) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		String message=erDao.successfulTransaction(th);
		return message;
		
	}
	
	public String successfulTransactionOutsideBank(TransactionHistory th) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		String message=erDao.successfulTransactionOutsideBank(th);
		return message;
	}
	
	
	public List<TransactionHistory> accountStatement(int number) throws Exception{
		List<TransactionHistory> list=new ArrayList<TransactionHistory>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list=erDao.accountStatement(number);
		return list;		
	}
	
	public List<TransactionHistory> search(TransactionHistory th,int number) throws Exception{
		List<TransactionHistory> list=new ArrayList<TransactionHistory>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list=erDao.search(th,number);
		System.out.println(list.size());
		return list;
	}
	
	
	
	
	public List<Contact> contact() throws Exception{
		List<Contact> list=new ArrayList<>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list=erDao.contactDAO();
		return list;
	}
	
	public List<Integer> allAccountList() throws Exception{
		List<Integer> list=new ArrayList<>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list=erDao.allAccountList();
		return list;
	}
	
	public List<accountInfo> getPerticularAccInfo(String uname) throws Exception{
		List<accountInfo> list=new ArrayList<>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list=erDao.getPerticularAccInfo(uname);
		return list;
	}


	public int addPayeeWithin(AddPayee ap) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		int number=erDao.addPayeeWithin(ap);
		return number;
	}

	public String addPayeeOthersBnak(AddPayee ap) throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		erDao.addPayeeOthersBnak(ap);
		return "";
	}
	
	public List<String> allPayeeListWithin(int accno) throws Exception{
		List<String> list1=new ArrayList<>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list1=erDao.allPayeeListWithin(accno);
		return list1;
	}
	
	public List<String> allPayeeListOthers(int accno) throws Exception{
		List<String> list1=new ArrayList<>();
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		list1=erDao.allPayeeListOthers(accno);
		return list1;
	}
	
	public int signupverify(accountInfo ai) throws Exception {
		ErrorRepositoryDAo erdao=Factory.createErrorRepositoryDAo();
		int signupnum=erdao.signupverify(ai);
		return signupnum;
		
	}

	
	public void RegisterWithbank(Login l) throws Exception {
		try{
		ErrorRepositoryDAo edao=Factory.createErrorRepositoryDAo();
		edao.RegisterWithbank(l);
		}catch (Exception e) {
			e.getMessage();
		}
	}
	
	public int Request(ServiceRequest sr) throws Exception {
		
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		int id=erDao.createRequestDao(sr);
		return id;
	}
	public List<String> allRequestId(int accnum)throws Exception{
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		List<String> list1=new ArrayList<>();
		list1=erDao.allRequestId(accnum);
		return list1;
	}
	
	public String trackRequest(int trackingId,int accnum) throws Exception{
	
		ErrorRepositoryDAo erDao=Factory.createErrorRepositoryDAo();
		String status=erDao.trackReuestDao(trackingId,accnum);
		return status;
	}
}
