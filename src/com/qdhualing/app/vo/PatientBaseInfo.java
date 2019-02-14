package com.qdhualing.app.vo;

import java.util.Date;

/**
 * PatientBaseInfo entity. @author MyEclipse Persistence Tools
 */

public class PatientBaseInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String password;
	private String avatar;
	private String patientName;
	private boolean sex;
	private String maritalStatus;
	private Integer nation;
	private String tel;
	private String email;
	private Date birthday;
	private String idCard;
	private String medicare;
	private String guardian;
	private String guardianTel;
	private String hometown;
	private String address;
	private String profession;
	private String past;
	private String allergicHistory;
	private short treatmentCategories;
	private String remark;

	// Constructors

	/** default constructor */
	public PatientBaseInfo() {
	}

	/** full constructor */
	public PatientBaseInfo(String password, String avatar, String patientName,
			boolean sex, String maritalStatus, Integer nation, String tel,
			String email,Date birthday, String idCard, String medicare, String guardian,
			String guardianTel, String hometown, String address,
			String profession, String past, String allergicHistory,
			short treatmentCategories, String remark) {
		this.password = password;
		this.avatar = avatar;
		this.patientName = patientName;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.nation = nation;
		this.tel = tel;
		this.email = email;
		this.birthday = birthday;
		this.idCard = idCard;
		this.medicare = medicare;
		this.guardian = guardian;
		this.guardianTel = guardianTel;
		this.hometown = hometown;
		this.address = address;
		this.profession = profession;
		this.past = past;
		this.allergicHistory = allergicHistory;
		this.treatmentCategories = treatmentCategories;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public boolean getSex() {
		return this.sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Integer getNation() {
		return this.nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMedicare() {
		return this.medicare;
	}

	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}

	public String getGuardian() {
		return this.guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public String getGuardianTel() {
		return this.guardianTel;
	}

	public void setGuardianTel(String guardianTel) {
		this.guardianTel = guardianTel;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getPast() {
		return this.past;
	}

	public void setPast(String past) {
		this.past = past;
	}

	public String getAllergicHistory() {
		return this.allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public short getTreatmentCategories() {
		return this.treatmentCategories;
	}

	public void setTreatmentCategories(short treatmentCategories) {
		this.treatmentCategories = treatmentCategories;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}