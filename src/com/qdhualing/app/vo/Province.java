package com.qdhualing.app.vo;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String proName;
	private String initial;

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** full constructor */
	public Province(String proName, String initial) {
		this.proName = proName;
		this.initial = initial;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getInitial() {
		return this.initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

}