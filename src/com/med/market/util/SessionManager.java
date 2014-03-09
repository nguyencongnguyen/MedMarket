package com.med.market.util;

import javax.servlet.http.HttpServletRequest;


public class SessionManager {
	private static final String PASSWORD = "PASSWORD";
	
	public void addPassword(String password, HttpServletRequest request) {
		request.getSession().setAttribute(PASSWORD, password);
	}
	
	public boolean checkPassword(String password, HttpServletRequest request) {
		String pass = (String) request.getSession().getAttribute(PASSWORD);
		if (pass == null || !pass.equals(password)) {
			return false;
		}
		return true;
	}
	
	public void removePassword(String password, HttpServletRequest request) {
		request.getSession().setAttribute(PASSWORD, null);
	}
}
