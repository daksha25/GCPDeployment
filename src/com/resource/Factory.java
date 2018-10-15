package com.resource;

import com.DAO.ErrorRepositoryDAo;
import com.DAO.ErrorRepositoryDAoImpl;
import com.service.ErrorRepositoryServiceImpl;
import com.service.ErrorRepositoryService;


public class Factory {
	public static ErrorRepositoryService createErrorRepositoryService()	{
		return  new ErrorRepositoryServiceImpl();
	}
	public static ErrorRepositoryDAo createErrorRepositoryDAo(){
		return new ErrorRepositoryDAoImpl();
		
	}

}