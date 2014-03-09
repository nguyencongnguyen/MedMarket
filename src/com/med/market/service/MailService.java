package com.med.market.service;

public interface MailService {
	public void sendMail(String address, String subject, String body) throws Exception;
}
