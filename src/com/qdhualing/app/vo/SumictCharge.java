package com.qdhualing.app.vo;

/**
 * SumictCharge entity. @author MyEclipse Persistence Tools
 */

public class SumictCharge implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer byTime;
	private float money;

	// Constructors

	/** default constructor */
	public SumictCharge() {
	}

	/** full constructor */
	public SumictCharge(Integer byTime, float money) {
		this.byTime = byTime;
		this.money = money;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getByTime() {
		return this.byTime;
	}

	public void setByTime(Integer byTime) {
		this.byTime = byTime;
	}

	public float getMoney() {
		return this.money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

}