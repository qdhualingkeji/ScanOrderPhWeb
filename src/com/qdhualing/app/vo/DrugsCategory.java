package com.qdhualing.app.vo;

/**
 * DrugsCategory entity. @author MyEclipse Persistence Tools
 */

public class DrugsCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dname;
	private Integer pid;
	private short isEnd;

	// Constructors

	/** default constructor */
	public DrugsCategory() {
	}

	/** full constructor */
	public DrugsCategory(String dname, Integer pid, short isEnd) {
		this.dname = dname;
		this.pid = pid;
		this.isEnd = isEnd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public short getIsEnd() {
		return this.isEnd;
	}

	public void setIsEnd(short isEnd) {
		this.isEnd = isEnd;
	}

}