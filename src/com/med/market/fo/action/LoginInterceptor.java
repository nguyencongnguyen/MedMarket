package com.med.market.fo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {
	public static final String USER_ACCOUNT = "account";

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) context
				.get(ServletActionContext.HTTP_REQUEST);

		HttpSession session = request.getSession(true);

		// Is there a "user" object stored in the user's HttpSession?
		Object user = session.getAttribute(USER_ACCOUNT);
		if (user != null) {
			return invocation.invoke();
		} else {
			/*String username = request.getParameter("username");
			if (username != null && !"".equals(username)) {
				return invocation.invoke();
			} else {*/
				return "login";
			//}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		// TODO Auto-generated method stub

	}

}
