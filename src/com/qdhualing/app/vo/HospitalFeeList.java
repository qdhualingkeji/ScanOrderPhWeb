package com.qdhualing.app.vo;

import java.util.Date;

/**
 * HospitalFeeList entity. @author MyEclipse Persistence Tools
 */

public class HospitalFeeList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String number;
	private Integer treatmentId;
	private Integer itemId;
	private Integer count;
	private Integer doctorId;
	private Integer feeDoctorId;
	public Integer getFeeDoctorId() {
		return feeDoctorId;
	}

	public void setFeeDoctorId(Integer feeDoctorId) {
		this.feeDoctorId = feeDoctorId;
	}

	private float money;
	private Date feeTime;
	private short isPayment;
	private Integer hospitalId;

	// Constructors

	/** default constructor */
	public HospitalFeeList() {
	}

	/** full constructor */
	public HospitalFeeList(String number, Integer treatmentId, Integer itemId,
			Integer count, Integer doctorId,float money, Date feeTime, short isPayment,
			Integer hospitalId) {
		this.number = number;
		this.treatmentId = treatmentId;
		this.itemId = itemId;
		this.count = count;
		this.doctorId = doctorId;
		this.money = money;
		this.feeTime = feeTime;
		this.isPayment = isPayment;
		this.hospitalId = hospitalId;
	}

	// Property accessors
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}
	
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

	public Integer getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
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

}