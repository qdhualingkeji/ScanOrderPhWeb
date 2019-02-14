package com.qdhualing.app.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.HospitalFeeList;

public class DoctorAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer doctorId;
	private String qualificationNumber;
	private String doctorName;
	private String avatar;
	private Short sex;
	private Integer education;
	private String idCard;
	private Integer nation;
	private Timestamp birthday;
	private Integer department;
	private Integer title;
	private String directions;
	private String tel;
	private String email;
	private String about;
	private Integer hospital;
	private String password;
	private String roleIds;
	private String searchTxt;
	private String pageNoc;
	private String select;
	private String address;
	private String hometown;
	private String url;
	public void setUrl(String url) {
		this.url = url;
	}

	private int picEnable;
	public void setPicEnable(int picEnable) {
		this.picEnable = picEnable;
	}

	private String staffName;
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	private Integer itemID;
	private Integer treatmentId;
	private Float money;
	public void setMoney(Float money) {
		this.money = money;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private Integer count;

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}

	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public void setQualificationNumber(String qualificationNumber) {
		this.qualificationNumber = qualificationNumber;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setSex(Short sex) {
		this.sex = sex;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setHospital(Integer hospital) {
		this.hospital = hospital;
	}

	private File pic;

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	private String savePath;

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	private String picFileName;

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	private String picContentType;

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	private Integer Aprovince;
	private Integer Hprovince;
	private Integer Acity;
	private Integer Hcity;

	public void setAprovince(Integer aprovince) {
		Aprovince = aprovince;
	}

	public void setHprovince(Integer hprovince) {
		Hprovince = hprovince;
	}

	public void setAcity(Integer acity) {
		Acity = acity;
	}

	public void setHcity(Integer hcity) {
		Hcity = hcity;
	}
	
	private String payNo; 
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

}
