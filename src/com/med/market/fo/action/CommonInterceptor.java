package com.med.market.fo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.med.market.util.ConfigurationManager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CommonInterceptor implements Interceptor {
	public static final String OB_URL = "obUrl";

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(ServletActionContext.HTTP_REQUEST);

		HttpSession session = request.getSession(true);

		Object url = session.getAttribute(OB_URL);
		if (url == null) {
			url = ConfigurationManager.getAsString("ob.site.domain");
			session.setAttribute(OB_URL, url);
		}
		return invocation.invoke();
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

}
