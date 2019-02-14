package com.qdhualing.app.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.Control.Type;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.jasper.tagplugins.jstl.core.Out;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qdhualing.app.util.MD5;
import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.util.SenderMail;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.PatientBaseInfo;
import com.qdhualing.app.vo.PatientTreatment;

public class HealthMembers extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String pageNoc;

	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}

	private Short treatmentCategories;
	private String patientName;
	private String sex;
	private String maritalStatus;
	private Timestamp birthday;
	private Integer nation;
	private String profession;
	private String medicare;
	private String idCard;
	private String tel;
	private String email;
	private String past;
	private String allergicHistory;
	private String guardian;
	private String guardianTel;
	private String password;
	private String card;
	private int picEnable;
	public void setPicEnable(int picEnable) {
		this.picEnable = picEnable;
	}
	public void setCard(String card) {
		this.card = card;
	}

	public void setTreatmentCategories(Short treatmentCategories) {
		this.treatmentCategories = treatmentCategories;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPast(String past) {
		this.past = past;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public void setGuardianTel(String guardianTel) {
		this.guardianTel = guardianTel;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private String searchTxt;

	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}

	private String select;

	public void setSelect(String select) {
		this.select = select;
	}

	private Integer HM;

	public void setHM(Integer hM) {
		HM = hM;
	}

	private Integer doctorID;
	private Timestamp inputTime;
	private String chiefComplaint;
	private String hp;
	private String masculinePhysique;
	private String otherFeatures;
	private String medicalReport;
	private String initialDiagnosis;
	private String program;
	private Integer inputDoctorID;
	private Timestamp recordTime;
	private Short isPrivacy;
	private Integer hospitalId;

	public void setDoctorID(Integer doctorID) {
		this.doctorID = doctorID;
	}

	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public void setMasculinePhysique(String masculinePhysique) {
		this.masculinePhysique = masculinePhysique;
	}

	public void setOtherFeatures(String otherFeatures) {
		this.otherFeatures = otherFeatures;
	}

	public void setMedicalReport(String medicalReport) {
		this.medicalReport = medicalReport;
	}

	public void setInitialDiagnosis(String initialDiagnosis) {
		this.initialDiagnosis = initialDiagnosis;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public void setInputDoctorID(Integer inputDoctorID) {
		this.inputDoctorID = inputDoctorID;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

	public void setIsPrivacy(Short isPrivacy) {
		this.isPrivacy = isPrivacy;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	private String startTime;

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	
	private String address;
	private String hometown;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
	private String stopTime;

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
	
	private Integer treatmentId;
	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	private String avatar;

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	private Integer patientId;

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	
	private Integer condition;

	public Integer getCondition() {
		return condition;
	}
	
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	
	private String like;
	
	public String getLike() {
		return like;
	}
	
	public void setLike(String like) {
		this.like = like;
	}
	
}
