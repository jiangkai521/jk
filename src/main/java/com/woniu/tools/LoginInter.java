package com.woniu.tools;

import java.awt.event.InvocationEvent;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import com.woniu.pojo.User;

public class LoginInter implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
	ActionContext ac=ActionContext.getContext();
	Map<String,Object> session=ac.getSession();
	User luser=(User) session.get("user");
	
	String result="login";
		if(luser!=null){
			result=invocation.invoke();
			
		}
//		System.out.println("!!!!!!!!!!1");
		return result;
	}

}
