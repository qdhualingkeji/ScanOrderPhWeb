package com.qdhualing.app.vo;

import java.util.Date;

/**
 * HospitalFeesItemPricing entity. @author MyEclipse Persistence Tools
 */

public class HospitalFeesItemPricing implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer feesItemId;
	private Integer inputDoctor;
	private Date time;
	private float unitPrice;
	private Integer hospitalId;
	private HospitalFeesItem hospitalFeesItem;
	// Constructors

	public HospitalFeesItem getHospitalFeesItem() {
		return hospitalFeesItem;
	}

	public void setHospitalFeesItem(HospitalFeesItem hospitalFeesItem) {
		this.hospitalFeesItem = hospitalFeesItem;
	}

	/** default constructor */
	public HospitalFeesItemPricing() {
	}

	/** full constructor */
	public HospitalFeesItemPricing(Integer feesItemId, Integer inputDoctor,
			Date time, float unitPrice, Integer hospitalId) {
		this.feesItemId = feesItemId;
		this.inputDoctor = inputDoctor;
		this.time = time;
		this.unitPrice = unitPrice;
		this.hospitalId = hospitalId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFeesItemId() {
		return this.feesItemId;
	}

	public void setFeesItemId(Integer feesItemId) {
		this.feesItemId = feesItemId;
	}

	public Integer getInputDoctor() {
		return this.inputDoctor;
	}

	public void setInputDoctor(Integer inputDoctor) {
		this.inputDoctor = inputDoctor;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}