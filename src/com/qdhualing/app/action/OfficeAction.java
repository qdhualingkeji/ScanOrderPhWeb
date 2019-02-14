package com.qdhualing.app.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.qdhualing.app.util.Const;
import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.GoodsInventory;
import com.qdhualing.app.vo.GoodsStorage;
import com.qdhualing.app.vo.HospitalOfficeSupplies;

public class OfficeAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private float money;
	private int count;
	private String pageNoc;
	private float purchasePrice;
	private Date warehousingDates;
	private Date productionDate;
	private Integer hospitalId;
	private Integer officeId;
	private Date expirationDate;
	private Integer doctorId;
	private float sellingPrice;
	private String barcode;
	private Integer manufacturersId;
	private Date expirationDateval;
	private Date timeval;
	private Integer condition;
	private Date startTime;
	private Date stopTime;
	private Integer staffId;
	private String lotNumber;
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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
	public void setTimeval(Date timeval) {
		this.timeval = timeval;
	}
	public void setExpirationDateval(Date expirationDateval) {
		this.expirationDateval = expirationDateval;
	}
	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public void setManufacturersId(Integer manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setWarehousingDates(Date warehousingDates) {
		this.warehousingDates = warehousingDates;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public void setCount(Integer count) {
		this.count = count;
	}



	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

}
