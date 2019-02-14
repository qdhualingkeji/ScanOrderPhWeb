package com.qdhualing.app.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qdhualing.app.vo.DoctorBaseInfo;

public class LoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
	         // TODO Auto-generated method stub
	 
	}
	 
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {
	    // 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
		// 登陆页面无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/login.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
	        return;
	    }
		// 登陆判断页面无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/loginError.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// 会员提示页面无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/RegAss.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// 健康会员注册页面无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/registration.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
	        return;
	    }
		// 医院注册页面无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/insert.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
	        return;
	    }
		// 医院注册页面无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/newInsert.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// CSS无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/css/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// JS无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/js/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// images无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/images/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// JS无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/js/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// JS无需过滤
		if(path.indexOf(servletRequest.getContextPath()+"/web/uploadImages/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
	    // 判断如果没有取到用户信息,就跳转到登陆页面
	    if (session.getAttribute("userLogin") == null || "".equals(session.getAttribute("userLogin"))) {
	    // 跳转到登陆页面
	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/index.jsp");
	    } else {
	    	int userType = (Integer) session.getAttribute("userType");
	    	//如果用户是健康会员
	    	if(userType==1)
	    	{
	    		//健康会员目录下的所有页面不需要过滤
	    		if(path.indexOf(servletRequest.getContextPath()+"/web/healthMembers/") > -1)
	    		{
	    			chain.doFilter(servletRequest, servletResponse);
	    			return;
	    		}
	    		else
	    		{
	    		    // 跳转到登陆页面
	    	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
	    		}
	    	}
	    	 if(userType==2)//如果是医生
	    	{
	    		 

			    		if(path.indexOf(servletRequest.getContextPath()+"/web/doctor/") > -1||path.indexOf(servletRequest.getContextPath()+"/web/healthMembers/personalCenter/messageCenter/") > -1)
			    		{
			    			chain.doFilter(servletRequest, servletResponse);
			    			return;
			    		}
			    		else
			    		{
			    		    // 跳转到登陆页面
			    	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
			    		}
	    		 
	    		 
	    	}
	    	 if(userType==3)//如果是医院管理
	    	 {
	    		 

	    			 if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/") > -1)
	    			 {
	    				 chain.doFilter(servletRequest, servletResponse);
	    				 return;
	    			 }
	    			 else
	    			 {
	    				 // 跳转到登陆页面
	    				 servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
	    			 }
	    		 
	    		 
	    	 }
	    	 if(userType==4)
	    	{
	    		//医院目录下的所有页面不需要过滤
	    		if(path.indexOf(servletRequest.getContextPath()+"/web/sumict/") > -1||path.indexOf(servletRequest.getContextPath()+"/web/hospital/treasuryManagement/ajaxPages/") > -1)
	    		{
	    			chain.doFilter(servletRequest, servletResponse);
	    			return;
	    		}
	    		else
	    		{
	    		    // 跳转到登陆页面
	    	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
	    		}
	    	}

	    }
	}
	 
	public void destroy() {
	 
	}
}
