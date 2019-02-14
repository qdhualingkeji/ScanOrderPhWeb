package com.qdhualing.app.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.HospitalAppendFee;
import com.qdhualing.app.vo.HospitalFee;
import com.qdhualing.app.vo.HospitalFeeList;

public class FinanceAction extends BaseActionSupport {
	/**财务中心Action
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pageNoc;
	private Integer condition;
	private Date startTime;
	private Date stopTime;
	private String select;
	public void setSelect(String select) {
		this.select = select;
	}

	private Date expirationDateval;
	private Date time;
	private Short type;
	private String feeNumber;
	public void setFeeNumber(String feeNumber) {
		this.feeNumber = feeNumber;
	}
	public void setType(Short type) {
		this.type = type;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	private int staffId;
	private Integer id;
	public void setId(int id) {
		this.id = id;
	}

	private int hospitalId;
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	private int doctorId;
	private float fee;
	public void setFee(float fee) {
		this.fee = fee;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	private String feeName;
	
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public void setExpirationDateval(Date expirationDateval) {
		this.expirationDateval = expirationDateval;
	}

	private Integer itemId;
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setCondition(Integer condition) {
		this.condition = condition;
	}
	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}
	
}
