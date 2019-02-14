package com.qdhualing.app.vo;

/**
 * Manufacturers entity. @author MyEclipse Persistence Tools
 */

public class Manufacturers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String manufacturersName;

	// Constructors

	/** default constructor */
	public Manufacturers() {
	}

	/** full constructor */
	public Manufacturers(String manufacturersName) {
		this.manufacturersName = manufacturersName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getManufacturersName() {
		return this.manufacturersName;
	}

	public void setManufacturersName(String manufacturersName) {
		this.manufacturersName = manufacturersName;
	}

}