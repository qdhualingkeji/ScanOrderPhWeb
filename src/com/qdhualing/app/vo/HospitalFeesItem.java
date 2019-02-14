package com.qdhualing.app.vo;

/**
 * HospitalFeesItem entity. @author MyEclipse Persistence Tools
 */

public class HospitalFeesItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String itemName;
	private Integer fessUnitId;
	private HospitalFeesItemPricing hospitalFeesItemPricing;
	// Constructors

	public HospitalFeesItemPricing getHospitalFeesItemPricing() {
		return hospitalFeesItemPricing;
	}

	public void setHospitalFeesItemPricing(
			HospitalFeesItemPricing hospitalFeesItemPricing) {
		this.hospitalFeesItemPricing = hospitalFeesItemPricing;
	}

	/** default constructor */
	public HospitalFeesItem() {
	}

	/** full constructor */
	public HospitalFeesItem(String itemName, Integer fessUnitId) {
		this.itemName = itemName;
		this.fessUnitId = fessUnitId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getFessUnitId() {
		return this.fessUnitId;
	}

	public void setFessUnitId(Integer fessUnitId) {
		this.fessUnitId = fessUnitId;
	}

}