package com.qdhualing.app.vo;

/**
 * CommonMennus entity. @author MyEclipse Persistence Tools
 */

public class CommonMennus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String menuName;
	private Integer anId;
	private Integer parentId;
	private Integer depth;
	private String target;
	private String url;

	// Constructors

	/** default constructor */
	public CommonMennus() {
	}

	/** full constructor */
	public CommonMennus(String menuName, Integer anId, Integer parentId,
			Integer depth, String target, String url) {
		this.menuName = menuName;
		this.anId = anId;
		this.parentId = parentId;
		this.depth = depth;
		this.target = target;
		this.url = url;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getAnId() {
		return this.anId;
	}

	public void setAnId(Integer anId) {
		this.anId = anId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getDepth() {
		return this.depth;
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public String getTarget() {
		return this.target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}