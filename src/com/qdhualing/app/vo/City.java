package com.qdhualing.app.vo;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String cityName;
	private Integer proId;
	private String initial;
	private String firstLetter;
	private String spelling;

	// Constructors

	/** default constructor */
	public City() {
	}

	/** full constructor */
	public City(String cityName, Integer proId, String initial,
			String firstLetter, String spelling) {
		this.cityName = cityName;
		this.proId = proId;
		this.initial = initial;
		this.firstLetter = firstLetter;
		this.spelling = spelling;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getInitial() {
		return this.initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getFirstLetter() {
		return this.firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public String getSpelling() {
		return this.spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

}