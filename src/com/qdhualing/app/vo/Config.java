package com.qdhualing.app.vo;

/**
 * Config entity. @author MyEclipse Persistence Tools
 */

public class Config implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String theKey;
	private String value;
	private String description;
	private short enable;

	// Constructors

	/** default constructor */
	public Config() {
	}

	/** full constructor */
	public Config(String theKey, String value, String description, short enable) {
		this.theKey = theKey;
		this.value = value;
		this.description = description;
		this.enable = enable;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTheKey() {
		return this.theKey;
	}

	public void setTheKey(String theKey) {
		this.theKey = theKey;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getEnable() {
		return this.enable;
	}

	public void setEnable(short enable) {
		this.enable = enable;
	}

}