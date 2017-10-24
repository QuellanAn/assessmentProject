package com.action;

import com.dto.UserDto;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1434120416293149698L;

	@Override
	protected String doIntercept(ActionInvocation invoker) throws Exception {
		// TODO Auto-generated method stub
		UserDto userDto = (UserDto) ActionContext.getContext().getSession()
				.get("userDto");
		if (null == userDto) {
			return "error1"; // 这里返回用户登录页面视图
		}
		return invoker.invoke();
	}

}
