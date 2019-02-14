package com.qdhualing.app.vo;

import java.util.Date;

/**
 * HospitalAppendFee entity. @author MyEclipse Persistence Tools
 */

public class HospitalAppendFee implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private float fee;
	private Integer doctorId;
	private Date time;
	private short type;
	private Integer hospitalId;

	// Constructors

	/** default constructor */
	public HospitalAppendFee() {
	}

	/** full constructor */
	public HospitalAppendFee(String name, float fee, Integer doctorId,
			Date time, short type, Integer hospitalId) {
		this.name = name;
		this.fee = fee;
		this.doctorId = doctorId;
		this.time = time;
		this.type = type;
		this.hospitalId = hospitalId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getFee() {
		return this.fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}