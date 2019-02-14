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
	    // ��������������Ҫ�õ�request,response,session����
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		// ����û������URI
		String path = servletRequest.getRequestURI();
		// ��½ҳ���������
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/login.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
	        return;
	    }
		// ��½�ж�ҳ���������
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/loginError.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// ��Ա��ʾҳ���������
		if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/RegAss.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// ������Աע��ҳ���������
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/registration.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
	        return;
	    }
		// ҽԺע��ҳ���������
		if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/insert.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
	        return;
	    }
		// ҽԺע��ҳ���������
		if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/newInsert.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// CSS�������
		if(path.indexOf(servletRequest.getContextPath()+"/web/css/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// JS�������
		if(path.indexOf(servletRequest.getContextPath()+"/web/js/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// images�������
		if(path.indexOf(servletRequest.getContextPath()+"/web/images/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// JS�������
		if(path.indexOf(servletRequest.getContextPath()+"/web/index/js/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
		// JS�������
		if(path.indexOf(servletRequest.getContextPath()+"/web/uploadImages/") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}
	    // �ж����û��ȡ���û���Ϣ,����ת����½ҳ��
	    if (session.getAttribute("userLogin") == null || "".equals(session.getAttribute("userLogin"))) {
	    // ��ת����½ҳ��
	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/index.jsp");
	    } else {
	    	int userType = (Integer) session.getAttribute("userType");
	    	//����û��ǽ�����Ա
	    	if(userType==1)
	    	{
	    		//������ԱĿ¼�µ�����ҳ�治��Ҫ����
	    		if(path.indexOf(servletRequest.getContextPath()+"/web/healthMembers/") > -1)
	    		{
	    			chain.doFilter(servletRequest, servletResponse);
	    			return;
	    		}
	    		else
	    		{
	    		    // ��ת����½ҳ��
	    	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
	    		}
	    	}
	    	 if(userType==2)//�����ҽ��
	    	{
	    		 

			    		if(path.indexOf(servletRequest.getContextPath()+"/web/doctor/") > -1||path.indexOf(servletRequest.getContextPath()+"/web/healthMembers/personalCenter/messageCenter/") > -1)
			    		{
			    			chain.doFilter(servletRequest, servletResponse);
			    			return;
			    		}
			    		else
			    		{
			    		    // ��ת����½ҳ��
			    	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
			    		}
	    		 
	    		 
	    	}
	    	 if(userType==3)//�����ҽԺ����
	    	 {
	    		 

	    			 if(path.indexOf(servletRequest.getContextPath()+"/web/hospital/") > -1)
	    			 {
	    				 chain.doFilter(servletRequest, servletResponse);
	    				 return;
	    			 }
	    			 else
	    			 {
	    				 // ��ת����½ҳ��
	    				 servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
	    			 }
	    		 
	    		 
	    	 }
	    	 if(userType==4)
	    	{
	    		//ҽԺĿ¼�µ�����ҳ�治��Ҫ����
	    		if(path.indexOf(servletRequest.getContextPath()+"/web/sumict/") > -1||path.indexOf(servletRequest.getContextPath()+"/web/hospital/treasuryManagement/ajaxPages/") > -1)
	    		{
	    			chain.doFilter(servletRequest, servletResponse);
	    			return;
	    		}
	    		else
	    		{
	    		    // ��ת����½ҳ��
	    	        servletResponse.sendRedirect(servletRequest.getContextPath()+"/healthMembersToOther.jsp?userType="+userType);	
	    		}
	    	}

	    }
	}
	 
	public void destroy() {
	 
	}
}
