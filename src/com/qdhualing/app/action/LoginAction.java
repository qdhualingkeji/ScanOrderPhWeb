package com.qdhualing.app.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.qdhualing.app.service.SumictAdminService;
import com.qdhualing.app.util.Escape;
import com.qdhualing.app.util.MD5;
import com.qdhualing.app.util.SenderMail;
import com.qdhualing.app.vo.ApplicationRecord;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.HospitalBaseInfo;
import com.qdhualing.app.vo.PatientBaseInfo;
import com.qdhualing.app.vo.SumictAdmin;

public class LoginAction extends BaseActionSupport {

	private static final long serialVersionUID = 1L;

	private SumictAdminService sumictAdminService;
	public void setSumictAdminService(SumictAdminService sumictAdminService) {
		this.sumictAdminService = sumictAdminService;
	}

	private String realName;
	private boolean sex;
	private short docsex;
	public void setDocsex(short docsex) {
		this.docsex = docsex;
	}

	private Timestamp birthday;//��������
	private String maritalStatus;//����״��
	private String idCard;
	private String tel;
	private String email;
	private String password;
	private int loginUserType;
	public void setLoginUserType(int loginUserType) {
		this.loginUserType = loginUserType;
	}

	private String card;
	private String loginName;
	private String passWord;
	private String hospitalName;// ҽԺ����
	private String legalName;// ����
	private String licenseNumber; // Ӫҵִ�պ���
	private String hospitalTel;// ҽԺ�绰
	private String headName;// ����������
	private Integer hospitalId;
	private String doctorName;
	private String qualificationNumber;
	private String roleIds;
	private File pic;
	private String picFileName;
	private String savePath;
	private int picEnable;
	public void setPicEnable(int picEnable) {
		this.picEnable = picEnable;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public void setQualificationNumber(String qualificationNumber) {
		this.qualificationNumber = qualificationNumber;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	private Integer doctorId;

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setHospitalTel(String hospitalTel) {
		this.hospitalTel = hospitalTel;
	}

	public void setHeadName(String headName) {
		this.headName = headName;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	private String phoneNumer;// �ֻ�����

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	//����˻���״��
    public void setMaritalStatus(String maritalStatus){
    	this.maritalStatus = maritalStatus;
    }
	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public void setLoginName(String loginName) {
		this.loginName = Escape.unescape(loginName);
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	private Integer userType;

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	
	private Integer patientId;

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	/**
	 * �༭�������� ���ܣ���ī��̨��¼
	 * 
	 * @throws IOException
	 */
	public void sumictLogin() throws IOException {

		ServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();

		if (loginName == "" || password == "") {
			out.print(0);
		}
		MD5 md5 = new MD5();
		String pwd = md5.encrypt(passWord);
		SumictAdmin userLogin = sumictAdminService.login(loginName, pwd);
		if (userLogin == null) {
			out.print(0);
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("userLogin", userLogin);
			ServletActionContext.getRequest().getSession()
			.setAttribute("userType", 4);
			ServletActionContext.getRequest().getSession().setMaxInactiveInterval(30 * 60);
			out.print(1);
		}
	}

	/**
	 * ���ܣ�ע���� �༭��������
	 * 
	 * @return
	 * @throws IOException 
	 */
	public void cancellation() throws IOException {

		ServletActionContext.getRequest().getSession().invalidate();
		ServletActionContext.getResponse().sendRedirect(ServletActionContext.getRequest().getContextPath()+"");
//		ServletActionContext.getResponse().sendRedirect(ServletActionContext.getRequest().getContextPath()
//						+ "/web/index/login.jsp?userid="+userType);
	}

	/**
	 * ���ܣ����ܾ����룻
	 * �༭����������
	 * @throws IOException
	 */
	public void encryptionOldPw() throws IOException {

		MD5 md5 = new MD5();
		String pwd = md5.encrypt(password);
		ServletActionContext.getResponse().setContentType(
				"text/html;charset=UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		out.print(pwd);
	}

	/**
	 * ���ܣ���֤�룻 �༭��������
	 * 
	 * @throws IOException
	 */

	public void checkCheckCode() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// ����ύ����ֵ
		String myCheckCode = request.getParameter("code");
		// ���session�д�ŵ�ʵ����֤��
		HttpSession session = request.getSession();
		String checkCode = (String) session.getAttribute("code");
		// �Ƚ�,��ȷ����1,����ȷ����0
		PrintWriter out = response.getWriter();
		if (checkCode.equals(myCheckCode)) {
			out.print(1);
		} else {
			out.print(0);
		}
		out.close();
	}

	public void createCheckCode() throws IOException {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// ����ҳ�治����
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// ���ڴ��д���ͼ��,����������ɵ���֤��ͼƬ�Ĵ�С
		int width = 60, height = 20;
		// �����ڴ��е�ͼ��
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// ���������
		Random random = new Random();
		// ��ȡͼ��������
		Graphics g = image.getGraphics();
		// �趨����ɫ
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("����", Font.ITALIC + Font.BOLD, 18));
		// �趨�������
		// ���߿�
		g.setColor(new Color(33, 66, 99));
		g.drawRect(0, 0, width - 1, height - 1);
		// �������50�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
		g.setColor(getRandColor(100, 150));
		for (int i = 0; i < 50; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// ȡ�����������֤��(4λ����)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;

			// ����֤����ʾ��ͼ����
			// ����������ɫ
			g.setColor(this.getRandColor(40, 60));
			g.drawString(rand, 13 * i + 6, 16);
		}
		// ����֤�����SESSION
		HttpSession session = request.getSession();
		session.setAttribute("code", sRand);
		// �ͷ�ͼ��������
		g.dispose();
		// ���ͼ��ҳ��
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	// ������Χ��������ɫ
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
