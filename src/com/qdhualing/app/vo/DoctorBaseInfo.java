package com.qdhualing.app.vo;

import java.util.Date;

/**
 * DoctorBaseInfo entity. @author MyEclipse Persistence Tools
 */

public class DoctorBaseInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String password;
	private String qualificationNumber;
	private String doctorName;
	private String avatar;
	private short sex;
	private Integer education;
	private String idCard;
	private Integer nation;
	private Date birthday;
	private String hometown;
	private Integer department;
	private Integer title;
	private String directions;
	private String address;
	private String tel;
	private String email;
	private String about;
	private Integer hospital;
	private String remark;
	private String roleIds;

	// Constructors

	/** default constructor */
	public DoctorBaseInfo() {
	}

	/** full constructor */
	public DoctorBaseInfo(String password, String qualificationNumber,
			String doctorName, String avatar, short sex, Integer education,
			String idCard, Integer nation, Date birthday, String hometown,
			Integer department, Integer title, String directions,
			String address, String tel, String email, String about,
			Integer hospital, String remark, String roleIds) {
		this.password = password;
		this.qualificationNumber = qualificationNumber;
		this.doctorName = doctorName;
		this.avatar = avatar;
		this.sex = sex;
		this.education = education;
		this.idCard = idCard;
		this.nation = nation;
		this.birthday = birthday;
		this.hometown = hometown;
		this.department = department;
		this.title = title;
		this.directions = directions;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.about = about;
		this.hospital = hospital;
		this.remark = remark;
		this.roleIds = roleIds;
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

	public String getQualificationNumber() {
		return this.qualificationNumber;
	}

	public void setQualificationNumber(String qualificationNumber) {
		this.qualificationNumber = qualificationNumber;
	}

	public String getDoctorName() {
		return this.doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public short getSex() {
		return this.sex;
	}

	public void setSex(short sex) {
		this.sex = sex;
	}

	public Integer getEducation() {
		return this.education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getNation() {
		return this.nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getTitle() {
		return this.title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public String getDirections() {
		return this.directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Integer getHospital() {
		return this.hospital;
	}

	public void setHospital(Integer hospital) {
		this.hospital = hospital;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleIds() {
		return this.roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

}