package com.qdhualing.app.vo;

/**
 * DictionaryInfo entity. @author MyEclipse Persistence Tools
 */

public class DictionaryInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer infoId;
	private Integer typeId;

	// Constructors

	/** default constructor */
	public DictionaryInfo() {
	}

	/** full constructor */
	public DictionaryInfo(String name, Integer infoId, Integer typeId) {
		this.name = name;
		this.infoId = infoId;
		this.typeId = typeId;
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

	public Integer getInfoId() {
		return this.infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}