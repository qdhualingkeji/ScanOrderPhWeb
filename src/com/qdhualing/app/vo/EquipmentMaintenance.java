package com.qdhualing.app.vo;

import java.util.Date;

/**
 * EquipmentMaintenance entity. @author MyEclipse Persistence Tools
 */

public class EquipmentMaintenance implements java.io.Serializable {

	// Fields

	private Integer id;
	private Date time;
	private Integer inventoryId;
	private float fee;
	private Integer doctorId;
	private String reason;
	private Integer hospitalId;
	private GoodsInventory goodsInventory;

	// Constructors

	public GoodsInventory getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(GoodsInventory goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	/** default constructor */
	public EquipmentMaintenance() {
	}

	/** full constructor */
	public EquipmentMaintenance(Date time, Integer inventoryId, float fee,
			Integer doctorId, String reason, Integer hospitalId) {
		this.time = time;
		this.inventoryId = inventoryId;
		this.fee = fee;
		this.doctorId = doctorId;
		this.reason = reason;
		this.hospitalId = hospitalId;
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

	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}