package com.qdhualing.app.vo;

import java.util.Date;

/**
 * DrugDamage entity. @author MyEclipse Persistence Tools
 */

public class DrugDamage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer inventoryId;
	private Integer doctorId;
	private Integer count;
	private Date time;
	private String reason;
	private float money;
	private Integer hospitalId;
	private GoodsInventory goodsInventoryserch;
	// Constructors

	public GoodsInventory getGoodsInventoryserch() {
		return goodsInventoryserch;
	}

	public void setGoodsInventoryserch(GoodsInventory goodsInventoryserch) {
		this.goodsInventoryserch = goodsInventoryserch;
	}

	/** default constructor */
	public DrugDamage() {
	}

	/** full constructor */
	public DrugDamage(Integer inventoryId, Integer doctorId, Integer count,
			Date time, String reason, float money, Integer hospitalId) {
		this.inventoryId = inventoryId;
		this.doctorId = doctorId;
		this.count = count;
		this.time = time;
		this.reason = reason;
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

	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public float getMoney() {
		return this.money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}