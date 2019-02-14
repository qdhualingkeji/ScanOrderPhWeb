package com.qdhualing.app.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.qdhualing.app.service.SumictAdminService;
import com.qdhualing.app.util.InputIdsReturnIdArray;
import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.vo.ApplicationRecord;
import com.qdhualing.app.vo.HospitalBaseInfo;
import com.qdhualing.app.vo.OrderHistory;
import com.qdhualing.app.vo.SumictAdmin;
import com.qdhualing.app.vo.UserFeedback;

public class SumictAdminAction extends BaseActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SumictAdminService sumictAdminService;
	public void setSumictAdminService(SumictAdminService sumictAdminService) {
		this.sumictAdminService = sumictAdminService;
	}
	
	private String pageNoc;

	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}
	
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	private String hospital;
	
	private String select;
	public void setSelect(String select) {
		this.select = select;
	}
	
	private Integer hospitalId;

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	private Integer isValidate;

	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}
	
	private String startTime;

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	private String stopTime;
	
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	private Integer senderId;
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
	private boolean isAlready;
	public void setIsAlready(boolean isAlready){
		this.isAlready = isAlready;
	}
	
	
	private Integer condition;
	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	private String hospitalName;
	
	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	private String applicationTime;

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}
	
	private String approvalTime;

	public String getApprovalTime() {
		return approvalTime;
	}

	public void setApprovalTime(String approvalTime) {
		this.approvalTime = approvalTime;
	}
	
	private String approvedName;
	private String time;
	private String chargeType;
	private String whetherPayment;

	public void setWhetherPayment(String whetherPayment) {
		this.whetherPayment = whetherPayment;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getApprovedName() {
		return approvedName;
	}

	public void setApprovedName(String approvedName) {
		this.approvedName = approvedName;
	}
	
	private File rsFile;

	public void setRsFile(File rsFile) {
		this.rsFile = rsFile;
	}

	/**
	 * 功能：根据管理员ID查找管理员姓名;
	 * 编辑：温明轩;
	 */
	public void findAdminNameById(){
		SumictAdmin sumictAdmin = sumictAdminService.findById(senderId);
		ServletActionContext.getRequest().setAttribute("sumictAdmin",sumictAdmin);
	}
	
	/**
	 * 功能：还原数据库里的所有数据
	 * 编辑：逄坤
	 * @throws IOException 
	 * **/
	public void restoreData() throws IOException {
		// TODO Auto-generated method stub
		InputStream is=new FileInputStream(rsFile);
		InputStreamReader rsIsr=new InputStreamReader(is,"utf-8");
		BufferedReader br=new BufferedReader(rsIsr);
		
		File reFile=new File("e:/restoreChc.sql");
		if(!reFile.exists()){
			reFile.createNewFile();
		}
		OutputStream os=new FileOutputStream(reFile);
		OutputStreamWriter osw=new OutputStreamWriter(os,"utf-8");
		StringBuilder sb=new StringBuilder();
		
		while (true) {
			String line = br.readLine();
			if(line==null)
				break;
			if(line.contains("\n")){
				line.replaceAll("\n", "\r\n");
			}
				sb.append(line+"\r\n");
		}
		String str = sb.toString();
		osw.write(str);
		osw.flush();
		osw.close();
		os.close();
		br.close();
		rsIsr.close();
		is.close();
		rsFile=null;
		
		try {

			Runtime rt = Runtime.getRuntime();

			//备份用如下命令即可，其它的保持不变

			//String cmd ="mysqldump -h localhost -uroot -proot spmanage > e:/mysql.sql"; //一定要加 -h localhost(或是服务器IP地址)

			//还原用如下命令

			String cmd ="mysql -h 127.0.0.1 -uroot -proot chc < e:/restoreChc.sql"; //一定要加 -h localhost(或是服务器IP地址)

			Process process =rt.exec("cmd /c " + cmd);

			InputStreamReader isr = new InputStreamReader(process.getErrorStream());

			LineNumberReader input = new LineNumberReader(isr);

			String line;

			isr.close();

			input.close();

			} catch (IOException e) {

			e.printStackTrace();

			}
		
		InputStream tmIs=new FileInputStream("e:/restoreChc.sql");
		InputStreamReader tmIsr=new InputStreamReader(tmIs, "utf-8");
		BufferedReader tmBr=new BufferedReader(tmIsr);
		
		OutputStream tmOs=new FileOutputStream("c:/Tomcat 6.0/webapps/CommunityHealth/web/RestoreFiles/chc.sql");
		OutputStreamWriter tmOsw=new OutputStreamWriter(tmOs, "utf-8");
		StringBuilder tmSb=new StringBuilder();
		
		while (true) {
			String line = tmBr.readLine();
			if(line==null)
				break;
			tmSb.append(line);
		}
		String tmStr = tmSb.toString();
		tmOsw.write(tmStr);
		tmOsw.flush();
		tmOsw.close();
		tmOs.close();
		tmBr.close();
		tmIsr.close();
		tmIs.close();

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect(request.getContextPath()+"/web/sumict/basicSettings/dataBackUp/list.jsp?userType=4&navi=4");
	}
}
