package com.qdhualing.app.vo;

/**
 * Prescription entity. @author MyEclipse Persistence Tools
 */

public class Prescription implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer drugId;
	private Integer quantity;
	private Integer treatmentId;
	private Integer usageId;
	private Integer dosageId;
	private float money;
	private Integer hospitalId;

	// Constructors

	/** default constructor */
	public Prescription() {
	}

	/** full constructor */
	public Prescription(Integer drugId, Integer quantity, Integer treatmentId,
			Integer usageId, Integer dosageId,float money, Integer hospitalId) {
		this.drugId = drugId;
		this.quantity = quantity;
		this.treatmentId = treatmentId;
		this.usageId = usageId;
		this.dosageId = dosageId;
		this.money = money;
		this.hospitalId = hospitalId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDrugId() {
		return this.drugId;
	}

	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTreatmentId() {
		return this.treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Integer getUsageId() {
		return this.usageId;
	}

	public void setUsageId(Integer usageId) {
		this.usageId = usageId;
	}

	public Integer getDosageId() {
		return this.dosageId;
	}

	public void setDosageId(Integer dosageId) {
		this.dosageId = dosageId;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	

}