package com.qdhualing.app.vo;

import java.util.Date;

/**
 * UserFeedback entity. @author MyEclipse Persistence Tools
 */

public class UserFeedback implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userType;
	private Integer userId;
	private String contentFeedback;
	private Date feedbackTime;

	/** default constructor */
	public UserFeedback() {
	}

	/** full constructor */
	public UserFeedback(Integer userType, Integer userId,
			String contentFeedback, Date feedbackTime) {
		this.userType = userType;
		this.userId = userId;
		this.contentFeedback = contentFeedback;
		this.feedbackTime = feedbackTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getContentFeedback() {
		return this.contentFeedback;
	}

	public void setContentFeedback(String contentFeedback) {
		this.contentFeedback = contentFeedback;
	}

	public Date getFeedbackTime() {
		return this.feedbackTime;
	}

	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}

}