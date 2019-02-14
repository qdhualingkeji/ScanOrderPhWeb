package com.qdhualing.app.vo;

/**
 * HospitalOfficeSupplies entity. @author MyEclipse Persistence Tools
 */

public class HospitalOfficeSupplies implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	// Constructors

	/** default constructor */
	public HospitalOfficeSupplies() {
	}

	/** full constructor */
	public HospitalOfficeSupplies(String name) {
		this.name = name;
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

}