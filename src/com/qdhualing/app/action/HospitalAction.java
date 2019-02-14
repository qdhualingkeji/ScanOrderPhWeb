package com.qdhualing.app.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.vo.ApplicationRecord;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.HospitalBaseInfo;
import com.qdhualing.app.vo.OrderHistory;
import com.qdhualing.app.vo.SumictCharge;

public class HospitalAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private Integer hospitalId;
	private String hospitalName;//医院名称
	private String legal;//医院法人
	private String license;//营业执照
	private String licenseNumber;//执照号码
	private String hospitalTel;//医院电话
	private Date foundTime;//成立时间
	private String departmentsVal;//主要科室
	private String about;//医院简介
	private String remark;//医院备注
	private Integer isValidate;
	private File pic;
	private Integer Aprovince;
	private Integer Acity;
	private String address;
	private Integer chargeId;
	
	public Integer getChargeId() {
		return chargeId;
	}
	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}
	private String searchTxt;
	private String charge;
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private Integer condition;
	public Integer getCondition() {
		return condition;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	private String pageNoc;
	
	public String getPageNoc() {
		return pageNoc;
	}
	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}
	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}
	private int picEnable;
	public void setPicEnable(int picEnable) {
		this.picEnable = picEnable;
	}
	public void setAprovince(Integer aprovince) {
		Aprovince = aprovince;
	}

	public void setAcity(Integer acity) {
		Acity = acity;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}
	private String picFileName;

	public String getPicFileName() {
		return picFileName;
	}
	private String savePath;


	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}
	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public void setHospitalTel(String hospitalTel) {
		this.hospitalTel = hospitalTel;
	}


	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}

	public void setDepartmentsVal(String departmentsVal) {
		this.departmentsVal = departmentsVal;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	private Integer oh_id;
	
	public void setOh_id(Integer oh_id) {
		this.oh_id = oh_id;
	}
	private String select;
	
	public void setSelect(String select) {
		this.select = select;
	}
	
	private String startTime;
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	private String endTime;
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getParameter(String param){
		return ServletActionContext.getRequest().getParameter(param);
	}
	
}
