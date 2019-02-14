package com.qdhualing.app.vo;

/**
 * Nation entity. @author MyEclipse Persistence Tools
 */

public class Nation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nationName;

	// Constructors

	/** default constructor */
	public Nation() {
	}

	/** full constructor */
	public Nation(String nationName) {
		this.nationName = nationName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNationName() {
		return this.nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

}