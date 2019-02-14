package com.qdhualing.app.vo;

import java.util.Date;

/**
 * HospitalFee entity. @author MyEclipse Persistence Tools
 */

public class HospitalFee implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String number;
	private String prescriptionId;
	private float money;
	private Integer doctorId;
	private Date feeTime;
	private short isPayment;
	private Integer hospitalId;
	private String remark;

	// Constructors

	/** default constructor */
	public HospitalFee() {
	}

	/** full constructor */
	public HospitalFee(String number, String prescriptionId, float money,
			Integer doctorId, Date feeTime, short isPayment,
			Integer hospitalId, String remark) {
		this.number = number;
		this.prescriptionId = prescriptionId;
		this.money = money;
		this.doctorId = doctorId;
		this.feeTime = feeTime;
		this.isPayment = isPayment;
		this.hospitalId = hospitalId;
		this.remark = remark;
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

	public String getPrescriptionId() {
		return this.prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public float getMoney() {
		return this.money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Date getFeeTime() {
		return this.feeTime;
	}

	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}

	public short getIsPayment() {
		return this.isPayment;
	}

	public void setIsPayment(short isPayment) {
		this.isPayment = isPayment;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}