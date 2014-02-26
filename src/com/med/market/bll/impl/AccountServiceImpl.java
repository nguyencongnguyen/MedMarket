package com.med.market.bll.impl;

import com.med.market.dao.impl.AccountDAOImpl;
import com.med.market.dao.model.Account;

public class AccountServiceImpl {
	private AccountDAOImpl accountDao;

	public Account get(String username) {
	    return accountDao.get(username);
	}

	public AccountDAOImpl getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDAOImpl accountDao) {
		this.accountDao = accountDao;
	}


}
