package com.med.market.util;

import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;

import org.apache.struts2.ServletActionContext;

public class CommonUtil {
	
	public static boolean checkCaptcha(HttpSession session, String captcha) {
		HttpSession ss = ServletActionContext.getRequest().getSession();
		if (ss != null) {
			Captcha capt = (Captcha) ss.getAttribute(Captcha.NAME);
			if (capt != null && captcha != null) {
				if (capt.isCorrect(captcha)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
	
	public static String genKeyword(String keyword) {
		String[] keywords = keyword.split(" ");
		StringBuffer result = new StringBuffer();
		for (int i=0; i< keywords.length; i++ ) {
			result.append(keywords[i] + ",");
		}
		return result.substring(0, result.length() - 1);
	}
}
