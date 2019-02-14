package com.qdhualing.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.qdhualing.app.util.Const;
import com.qdhualing.app.util.Escape;
import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.util.QsUtil;
import com.qdhualing.app.vo.DoctorBaseInfo;
import com.qdhualing.app.vo.DrugDamage;
import com.qdhualing.app.vo.DrugsBaseInfo;
import com.qdhualing.app.vo.DrugsCategory;
import com.qdhualing.app.vo.GoodsInventory;
import com.qdhualing.app.vo.GoodsOut;
import com.qdhualing.app.vo.GoodsStorage;
import com.qdhualing.app.vo.HospitalFee;
import com.qdhualing.app.vo.HospitalOfficeSupplies;
import com.qdhualing.app.vo.Manufacturers;
import com.qdhualing.app.vo.Prescription;


public class DrugsAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String like;
	public void setLike(String like) {
		this.like = Escape.unescape(like);
	}

	private String feeNumber;
	public void setFeeNumber(String feeNumber) {
		this.feeNumber = feeNumber;
	}

	private String drugName;
	private String equipmentName;
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = Escape.unescape(equipmentName);
	}

	private String newFirmName;
	private String manufacturersByName;
	private String specifications;
	private short isPrescription;
	private String indications;
	private Integer categoryId;
	private String commonName;
	private Integer pharmacyTypeId;
	private String remark;
	private float money;
	private int inventoryIdval;
	private int capsval;
	private int lowerval;
	private int count;
	private Integer manufacturersIdval;
	private String reason;
	private String officeName;
	private String lotNumber;
	private String payNo;
	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public void setOfficeName(String officeName) {
		this.officeName = Escape.unescape(officeName);
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setManufacturersIdval(Integer manufacturersIdval) {
		this.manufacturersIdval = manufacturersIdval;
	}

	public void setInventoryIdval(int inventoryIdval) {
		this.inventoryIdval = inventoryIdval;
	}

	public void setCapsval(int capsval) {
		this.capsval = capsval;
	}

	public void setLowerval(int lowerval) {
		this.lowerval = lowerval;
	}


	public void setMoney(float money) {
		this.money = money;
	}
	private String select;
	public void setSelect(String select) {
		this.select = select;
	}

	private float purchasePrice;
	private Date warehousingDates;
	private Date productionDate;
	private Date expirationDateval;
	private Date damageDateval;
	public void setDamageDateval(Date damageDateval) {
		this.damageDateval = damageDateval;
	}

	private Date timeval;
	private Date startTime;
	private Date stopTime;
	private Integer staffId;

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public void setTimeval(Date timeval) {
		this.timeval = timeval;
	}

	public void setExpirationDateval(Date expirationDateval) {
		this.expirationDateval = expirationDateval;
	}

	private Integer hospitalId;
	private Integer goodsTypeId;
	private Integer drugId;
	private Date expirationDate;
	private Integer doctorId;
	private float sellingPrice;
	private String manufacturers;
	private String barcode;
	private Integer manufacturersId;
	private String searchTxt;
	private String pageNoc;
	private Integer condition;

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	private Integer goodsId;

	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}

	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}

	public void setManufacturersId(Integer manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

	public void setManufacturersByName(String manufacturersByName) {
		this.manufacturersByName = Escape.unescape(manufacturersByName);
	}

	public void setNewFirmName(String newFirmName) {
		this.newFirmName = Escape.unescape(newFirmName);
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
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

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
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

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public void setIsPrescription(short isPrescription) {
		this.isPrescription = isPrescription;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public void setPharmacyTypeId(Integer pharmacyTypeId) {
		this.pharmacyTypeId = pharmacyTypeId;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setDrugName(String drugName) {
		this.drugName = Escape.unescape(drugName);
	}

	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public void setUsageId(Integer usageId) {
		this.usageId = usageId;
	}

	public void setDosageId(Integer dosageId) {
		this.dosageId = dosageId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	private Integer quantity;
	private Integer treatmentId;
	private Integer usageId;
	private Integer dosageId;
	private String prescriptionId;
	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

}
