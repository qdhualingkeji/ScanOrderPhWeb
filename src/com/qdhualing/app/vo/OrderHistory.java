package com.qdhualing.app.vo;

import java.util.Date;

/**
 * OrderHistory entity. @author MyEclipse Persistence Tools
 */

public class OrderHistory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date time;
	private Integer chargeId;
	private Integer hospitalId;
	private boolean whetherPayment;
	private SumictCharge sumictCharge;
	private HospitalBaseInfo hospitalBaseInfo;

	// Constructors

	public HospitalBaseInfo getHospitalBaseInfo() {
		return hospitalBaseInfo;
	}

	public void setHospitalBaseInfo(HospitalBaseInfo hospitalBaseInfo) {
		this.hospitalBaseInfo = hospitalBaseInfo;
	}

	public SumictCharge getSumictCharge() {
		return sumictCharge;
	}

	public void setSumictCharge(SumictCharge sumictCharge) {
		this.sumictCharge = sumictCharge;
	}

	/** default constructor */
	public OrderHistory() {
	}

	/** full constructor */
	public OrderHistory(Date time, Integer chargeId, Integer hospitalId,
			boolean whetherPayment) {
		this.time = time;
		this.chargeId = chargeId;
		this.hospitalId = hospitalId;
		this.whetherPayment = whetherPayment;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public boolean getWhetherPayment() {
		return this.whetherPayment;
	}

	public void setWhetherPayment(boolean whetherPayment) {
		this.whetherPayment = whetherPayment;
	}

}