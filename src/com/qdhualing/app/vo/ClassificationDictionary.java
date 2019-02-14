package com.qdhualing.app.vo;

/**
 * ClassificationDictionary entity. @author MyEclipse Persistence Tools
 */

public class ClassificationDictionary implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	// Constructors

	/** default constructor */
	public ClassificationDictionary() {
	}

	/** full constructor */
	public ClassificationDictionary(String name) {
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