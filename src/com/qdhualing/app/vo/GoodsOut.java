package com.qdhualing.app.vo;

import java.util.Date;

/**
 * GoodsOut entity. @author MyEclipse Persistence Tools
 */

public class GoodsOut implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer doctorId;
	private Integer count;
	private Date time;
	private float money;
	private float income;
	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	private Integer hospitalId;
	private Integer inventoryId;
	private GoodsInventory goodsInventory;
	// Constructors

	public void setGoodsInventory(GoodsInventory goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public GoodsInventory getGoodsInventory() {
		return goodsInventory;
	}

	/** default constructor */
	public GoodsOut() {
	}

	/** full constructor */
	public GoodsOut(Integer doctorId, Integer count, Date time, float money,
			Integer hospitalId, Integer inventoryId) {
		this.doctorId = doctorId;
		this.count = count;
		this.time = time;
		this.money = money;
		this.hospitalId = hospitalId;
		this.inventoryId = inventoryId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getInventoryId() {
		return this.inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

}