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
	
}
