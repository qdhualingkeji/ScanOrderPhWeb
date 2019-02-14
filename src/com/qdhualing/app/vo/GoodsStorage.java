package com.qdhualing.app.vo;

import java.util.Date;

/**
 * GoodsStorage entity. @author MyEclipse Persistence Tools
 */

public class GoodsStorage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer goodsId;
	private Integer goodsTypeId;
	private Integer doctorId;
	private Date productionDate;
	private Date expirationDate;
	private Date shengChanRiQi;
	private GoodsInventory goodsInventory;
	public GoodsInventory getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(GoodsInventory goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public Date getShengChanRiQi() {
		return shengChanRiQi;
	}

	public void setShengChanRiQi(Date shengChanRiQi) {
		this.shengChanRiQi = shengChanRiQi;
	}

	private Integer count;
	private Date time;
	private float money;
	private Integer hospitalId;
	private Integer inventoryId;

	// Constructors

	/** default constructor */
	public GoodsStorage() {
	}

	/** full constructor */
	public GoodsStorage(Integer goodsId, Integer goodsTypeId, Integer doctorId,
			Date productionDate, Date expirationDate,
			Integer count, Date time, float money, Integer hospitalId,
			Integer inventoryId) {
		this.goodsId = goodsId;
		this.goodsTypeId = goodsTypeId;
		this.doctorId = doctorId;
		this.productionDate = productionDate;
		this.expirationDate = expirationDate;
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

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}


	public Date getProductionDate() {
		return this.productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
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