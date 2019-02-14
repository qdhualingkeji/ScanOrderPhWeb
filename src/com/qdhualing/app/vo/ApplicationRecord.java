package com.qdhualing.app.vo;

import java.util.Date;

/**
 * ApplicationRecord entity. @author MyEclipse Persistence Tools
 */

public class ApplicationRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer hospitalId;
	private Date applicationTime;
	private Date approvalTime;
	private boolean whetherApproval;
	private Integer approvedBy;
	private DoctorBaseInfo doctorBaseInfo;
	private SumictAdmin sumictAdmin;
	private HospitalBaseInfo hospitalBaseInfo;

	public SumictAdmin getSumictAdmin() {
		return sumictAdmin;
	}

	public void setSumictAdmin(SumictAdmin sumictAdmin) {
		this.sumictAdmin = sumictAdmin;
	}

	public HospitalBaseInfo getHospitalBaseInfo() {
		return hospitalBaseInfo;
	}

	public void setHospitalBaseInfo(HospitalBaseInfo hospitalBaseInfo) {
		this.hospitalBaseInfo = hospitalBaseInfo;
	}

	// Constructors
	

	public DoctorBaseInfo getDoctorBaseInfo() {
		return doctorBaseInfo;
	}

	public void setDoctorBaseInfo(DoctorBaseInfo doctorBaseInfo) {
		this.doctorBaseInfo = doctorBaseInfo;
	}

	/** default constructor */
	public ApplicationRecord() {
	}

	/** full constructor */
	public ApplicationRecord(Integer hospitalId, Date applicationTime,
			Date approvalTime, boolean whetherApproval, Integer approvedBy) {
		this.hospitalId = hospitalId;
		this.applicationTime = applicationTime;
		this.approvalTime = approvalTime;
		this.whetherApproval = whetherApproval;
		this.approvedBy = approvedBy;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Date getApplicationTime() {
		return this.applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	public Date getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

	public boolean getWhetherApproval() {
		return this.whetherApproval;
	}

	public void setWhetherApproval(boolean whetherApproval) {
		this.whetherApproval = whetherApproval;
	}

	public Integer getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(Integer approvedBy) {
		this.approvedBy = approvedBy;
	}

}