package com.med.market.bll.impl;

import com.med.market.dao.impl.AccountDAOImpl;

public class AccountServiceImpl {
	private AccountDAOImpl accountDao;

	public AccountDAOImpl getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAOImpl accountDao) {
		this.accountDao = accountDao;
	}
	
	
}
