package com.med.market.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.med.market.dao.model.Account;

public class AccountDAOImpl extends HibernateDaoSupport {

	public void add(Account entity) {
	 	getHibernateTemplate().save(entity);
	}

	public Account get(String username) {
		return (Account) getHibernateTemplate().get(Account.class, username);
	}

	//public Account getByEmail(String email) {
	//	return (Account) getHibernateTemplate().find("from " + Account.class.getName() + " a where a.email='" + email + "'").get(0);
	//}

}
