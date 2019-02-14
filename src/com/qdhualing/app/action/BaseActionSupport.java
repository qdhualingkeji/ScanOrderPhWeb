package com.qdhualing.app.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��װһЩ������Action����.
 * 
 * @author BeanSoft
 * 
 */
public abstract class BaseActionSupport extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;// ���ص���Ϣ
	private String title;// ҳ����ʾ����

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * ������URL�����ϲ���һ��URL�ַ���(page��������), �ṩ��ҳʱ��ʾ.
	 * 
	 * @return �ַ���, ��: para1=11&para2=bb
	 */
	public String mergeParamsAsURI() {
		Map<String, String[]> params = getRequest().getParameterMap();
		StringBuffer out = new StringBuffer();
		Set<String> keys = params.keySet();// �г����б�����
		for (String key : keys) {
			if (!"page".equals(key)) {
				String[] values = params.get(key);// ���Ի�ȡ�������
				// ���ܵ����������Ƕ������ͳһת��������
				if (values.length > 1) {
					values = getRequest().getParameterValues(key);
				} else {
					values = new String[] { getParameter(key) };
				}
				
				try {
					for (String value : values) {
						
						out.append(java.net.URLEncoder.encode(key, "UTF-8")
								+ "=");
						out.append(java.net.URLEncoder.encode(value, "UTF-8")
								+ "&");
						// key=value&
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		// ɾ��ĩβ����� & �ַ�
		if (out.toString().endsWith("&")) {
			out.deleteCharAt(out.length() - 1);
		}
		return out.toString();
	}

	/**
	 * ���ú�ҳ����ʾ�йصĲ���, title��message���Զ�����Ϊ��. Struts 2 ����Ҫ�������, ÿ��Action�����µĶ���.
	 */
	void resetMessages() {
		setMessage("");
		setTitle("");
	}

	/**
	 * ��ȡ��ǰ�Ự�ĵ�¼�û���Ϣ
	 * 
	 * @return User
	 */

	/**
	 * ��ȡ������
	 * 
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		return ServletActionContext.getRequest().getParameter(name);
	}

	/**
	 * ����������Ϊ��������.
	 * 
	 * @param name
	 *            ��������
	 * @return
	 */
	public int getParameterInt(String name) {
		String s = getParameter(name);
		if (s == null) {
			return 0;
		} else {
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * ����������Ϊ����������.
	 * 
	 * @param name
	 *            ��������
	 * @return
	 */
	public long getParameterLong(String name) {
		String s = getParameter(name);
		if (s == null) {
			return 0L;
		} else {
			try {
				return Long.parseLong(s);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return 0L;
	}

	/**
	 * ���� request ������.
	 * 
	 * @param name
	 *            ������
	 * @param value
	 *            ����ֵ
	 */
	public void setAttribute(String name, Object value) {
		ServletActionContext.getRequest().setAttribute(name, value);
	}

	/**
	 * ��ȡ request ������.
	 * 
	 * @param name
	 *            ������
	 */
	public Object getAttribute(String name) {
		return ServletActionContext.getRequest().getAttribute(name);
	}

	/**
	 * ��ȡ session �е�����ֵ
	 * 
	 * @param name
	 * @return
	 */
	public static Object getSession(String name) {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		return session.get(name);
	}

	/**
	 * �� session ��������ֵ
	 * 
	 * @param name
	 * @param value
	 */
	public static void setSession(Object name, Object value) {
		ActionContext ctx = ActionContext.getContext();
		Map session = ctx.getSession();
		session.put(name, value);
	}

	/**
	 * ��ȡ application ����.
	 * 
	 * @return
	 */
	public static ServletContext getApplication() {
		return ServletActionContext.getServletContext();
	}

	/**
	 * ��ȡ�������.
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	/**
	 * �༭��������
	 * ���ܣ�ʵ�ֶ�������������
	 */
	
    public static String addDay(String s, int n) {   
        try {   
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
                 Calendar cd = Calendar.getInstance();   
                 cd.setTime(sdf.parse(s));   
                 cd.add(Calendar.DATE, n);//����һ��   
                 //cd.add(Calendar.MONTH, n);//����һ����   
                 return sdf.format(cd.getTime());   
             } catch (Exception e) {   
                 return null;   
             }   
     }  
	 

}