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

	private Timestamp birthday;//出生日期
	private String maritalStatus;//婚姻状况
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
	private String hospitalName;// 医院名称
	private String legalName;// 法人
	private String licenseNumber; // 营业执照号码
	private String hospitalTel;// 医院电话
	private String headName;// 负责人姓名
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

	private String phoneNumer;// 手机号码

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
	//添加了婚姻状况
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
	 * 编辑：温明轩 功能：三墨后台登录
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
	 * 功能：注销； 编辑：温明轩
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
	 * 功能：加密旧密码；
	 * 编辑：温明轩；
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
	 * 功能：验证码； 编辑：温明轩
	 * 
	 * @throws IOException
	 */

	public void checkCheckCode() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		// 获得提交参数值
		String myCheckCode = request.getParameter("code");
		// 获得session中存放的实际验证码
		HttpSession session = request.getSession();
		String checkCode = (String) session.getAttribute("code");
		// 比较,正确返回1,不正确返回0
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
		// 设置页面不缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 在内存中创建图象,设置最后生成的验证码图片的大小
		int width = 60, height = 20;
		// 生成内存中的图像
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 生成随机类
		Random random = new Random();
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("隶书", Font.ITALIC + Font.BOLD, 18));
		// 设定随机字体
		// 画边框
		g.setColor(new Color(33, 66, 99));
		g.drawRect(0, 0, width - 1, height - 1);
		// 随机产生50条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(100, 150));
		for (int i = 0; i < 50; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;

			// 将认证码显示到图象中
			// 设置字体颜色
			g.setColor(this.getRandColor(40, 60));
			g.drawString(rand, 13 * i + 6, 16);
		}
		// 将认证码存入SESSION
		HttpSession session = request.getSession();
		session.setAttribute("code", sRand);
		// 释放图形上下文
		g.dispose();
		// 输出图象到页面
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	// 给定范围获得随机颜色
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
