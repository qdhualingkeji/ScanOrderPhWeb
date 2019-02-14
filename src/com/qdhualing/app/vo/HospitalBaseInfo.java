package com.qdhualing.app.vo;

import java.util.Date;

/**
 * HospitalBaseInfo entity. @author MyEclipse Persistence Tools
 */

public class HospitalBaseInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String number;
	private String hospitalName;
	private String legal;
	private String license;
	private String licenseNumber;
	private Integer isValidate;
	private String hospitalTel;
	private String hospitalAddress;
	private Date foundTime;
	private String about;
	private String departments;
	private String remark;
	private Integer frequencyOfUse;
	private boolean whetherPayment;
	private Date startDate;
	private Date endDate;
	private Integer charge;

	// Constructors

	/** default constructor */
	public HospitalBaseInfo() {
	}

	/** full constructor */
	public HospitalBaseInfo(String number, String hospitalName, String legal,
			String license, String licenseNumber, Integer isValidate,
			String hospitalTel, String hospitalAddress, Date foundTime,
			String about, String departments, String remark,
			Integer frequencyOfUse, boolean whetherPayment, Date startDate,
			Date endDate, Integer charge) {
		this.number = number;
		this.hospitalName = hospitalName;
		this.legal = legal;
		this.license = license;
		this.licenseNumber = licenseNumber;
		this.isValidate = isValidate;
		this.hospitalTel = hospitalTel;
		this.hospitalAddress = hospitalAddress;
		this.foundTime = foundTime;
		this.about = about;
		this.departments = departments;
		this.remark = remark;
		this.frequencyOfUse = frequencyOfUse;
		this.whetherPayment = whetherPayment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.charge = charge;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHospitalName() {
		return this.hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getLegal() {
		return this.legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Integer getIsValidate() {
		return this.isValidate;
	}

	public void setIsValidate(Integer isValidate) {
		this.isValidate = isValidate;
	}

	public String getHospitalTel() {
		return this.hospitalTel;
	}

	public void setHospitalTel(String hospitalTel) {
		this.hospitalTel = hospitalTel;
	}

	public String getHospitalAddress() {
		return this.hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public Date getFoundTime() {
		return this.foundTime;
	}

	public void setFoundTime(Date foundTime) {
		this.foundTime = foundTime;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getDepartments() {
		return this.departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getFrequencyOfUse() {
		return this.frequencyOfUse;
	}

	public void setFrequencyOfUse(Integer frequencyOfUse) {
		this.frequencyOfUse = frequencyOfUse;
	}

	public boolean getWhetherPayment() {
		return this.whetherPayment;
	}

	public void setWhetherPayment(boolean whetherPayment) {
		this.whetherPayment = whetherPayment;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getCharge() {
		return this.charge;
	}

	public void setCharge(Integer charge) {
		this.charge = charge;
	}

}