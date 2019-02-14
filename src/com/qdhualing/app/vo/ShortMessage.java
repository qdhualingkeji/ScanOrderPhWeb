package com.qdhualing.app.vo;

import java.util.Date;

/**
 * ShortMessage entity. @author MyEclipse Persistence Tools
 */

public class ShortMessage implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer senderId;
	private String content;
	private Date time;
	private Integer addresseeId;
	private Integer recipientsRole;
	private boolean status;
	private Integer senderRole;
	private String senderName;

	// Constructors

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	/** default constructor */
	public ShortMessage() {
	}

	/** full constructor */
	public ShortMessage( Integer senderId,String content, Date time,
			Integer addresseeId, Integer recipientsRole, boolean status,
			Integer senderRole) {
		this.senderId = senderId;
		this.content = content;
		this.time = time;
		this.addresseeId = addresseeId;
		this.recipientsRole = recipientsRole;
		this.status = status;
		this.senderRole = senderRole;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getAddresseeId() {
		return this.addresseeId;
	}

	public void setAddresseeId(Integer addresseeId) {
		this.addresseeId = addresseeId;
	}

	public Integer getRecipientsRole() {
		return this.recipientsRole;
	}

	public void setRecipientsRole(Integer recipientsRole) {
		this.recipientsRole = recipientsRole;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Integer getSenderRole() {
		return this.senderRole;
	}

	public void setSenderRole(Integer senderRole) {
		this.senderRole = senderRole;
	}

}