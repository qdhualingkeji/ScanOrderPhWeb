package com.qdhualing.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jspsmart.upload.Request;
import com.qdhualing.app.util.Const;
import com.qdhualing.app.util.Escape;
import com.qdhualing.app.util.InputIdsReturnIdArray;
import com.qdhualing.app.util.PageModel;
import com.qdhualing.app.util.QsUtil;
import com.qdhualing.app.vo.City;
import com.qdhualing.app.vo.ClassificationDictionary;
import com.qdhualing.app.vo.CommonMennus;
import com.qdhualing.app.vo.Config;
import com.qdhualing.app.vo.Department;
import com.qdhualing.app.vo.DictionaryInfo;
import com.qdhualing.app.vo.DrugsCategory;
import com.qdhualing.app.vo.HospitalFeesItem;
import com.qdhualing.app.vo.HospitalFeesItemPricing;
import com.qdhualing.app.vo.HospitalOfficeSupplies;
import com.qdhualing.app.vo.Manufacturers;
import com.qdhualing.app.vo.Nation;
import com.qdhualing.app.vo.Province;
import com.qdhualing.app.vo.ShortMessage;
import com.qdhualing.app.vo.SumictCharge;
import com.qdhualing.app.vo.UserFeedback;



public class CommonAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer recipientsRole;
	private Integer addresseeId;
	private Integer senderRole;
	private Integer pids;
	public Integer getPids(){
		return pids;
	}
	public void setPids(Integer pids){
		this.pids=pids;
	}
	public Integer getSenderRole() {
		return senderRole;
	}
	public void setSenderRole(Integer senderRole) {
		this.senderRole = senderRole;
	}
	
	private String producers;
	private String feeName;
	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	public void setProducers(String producers) {
		this.producers = producers;
	}
	public void setRecipientsRole(Integer recipientsRole) {
		this.recipientsRole = recipientsRole;
	}
	public void setAddresseeId(Integer addresseeId) {
		this.addresseeId = addresseeId;
	}
	private Integer province;
	public void setProvince(Integer province) {
		this.province = province;
	}
	
	private String dictionary;
	public void setDictionary(String dictionary) {
		this.dictionary = dictionary;
	}
	private String charge;
	public void setCharge(String charge) {
		this.charge = charge;
	}
	private Integer pricingId;
	
	public void setPricingId(Integer pricingId) {
		this.pricingId = pricingId;
	}
	private Integer unitId;
	
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	
	private Integer nationId;
	private String supply;
	private String category;
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSupply(String supply) {
		this.supply = supply;
	}
	public void setNationId(Integer nationId) {
		this.nationId = nationId;
	}

	private Integer provinceId;
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	private String manufacturersName;
	private Integer manufacturersId;
	public void setManufacturersId(Integer manufacturersId) {
		this.manufacturersId = manufacturersId;
	}
	public void setManufacturersName(String manufacturersName) {
		this.manufacturersName = manufacturersName;
	}
	private Integer cityId;
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	private String className;
	public void setClassName(String className) {
		this.className = className;
	}
	private Integer eudid;
	public void setEudid(Integer eudid) {
		this.eudid = eudid;
	}
	private Integer depid;
	public void setDepid(Integer depid) {
		this.depid = depid;
	}
	private Integer titleid;
	public void setTitleid(Integer titleid) {
		this.titleid = titleid;
	}
	private Integer officeSuppliesId;
	public void setOfficeSuppliesId(Integer officeSuppliesId) {
		this.officeSuppliesId = officeSuppliesId;
	}
	private Integer userType;
	private Integer userId;
	private String contentFeedback;
	private Timestamp feedbackTime;
	private Integer categoryId;
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setContentFeedback(String contentFeedback) {
		this.contentFeedback = contentFeedback;
	}
	public void setFeedbackTime(Timestamp feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	
	private Integer itemId;

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	
	private Integer hospitalId;
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	private Integer feesItemId;
	public void setFeesItemId(Integer feesItemId) {
		this.feesItemId = feesItemId;
	}
	
	private Integer pharmacyTypeId;
	public void setPharmacyTypeId(Integer pharmacyTypeId) {
		this.pharmacyTypeId = pharmacyTypeId;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	private String departmentName;
	private Integer hospital;
	public void setHospital(Integer hospital) {
		this.hospital = hospital;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	private String about;
	
	private String select;
	public void setSelect(String select) {
		this.select = select;
	}
	private String pageNoc;
	public void setPageNoc(String pageNoc) {
		this.pageNoc = pageNoc;
	}
	private String device;
	public void setDevice(String device) {
		this.device = device;
	}
	private String classificationName;
	public void setClassificationName(String classificationName) {
		this.classificationName = classificationName;
	}
	
	private Integer classificationDictionaryId;
	public void setClassificationDictionaryId(Integer classificationDictionaryId) {
		this.classificationDictionaryId = classificationDictionaryId;
	}
	
	private String dictionaryInfoName;
	public void setDictionaryInfoName(String dictionaryInfoName) {
		this.dictionaryInfoName = dictionaryInfoName;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}
	private Integer typeId;
	private Integer infoId;
	private Integer dictionaryId;
	public void setDictionaryId(Integer dictionaryId) {
		this.dictionaryId = dictionaryId;
	}
	private String educationName;
	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	private Integer educationId;
	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	private String dname;
	public void setDname(String dname) {
		this.dname = dname;
	}
	public void setIsEnd(short isEnd) {
		this.isEnd = isEnd;
	}
	private short isEnd;
	private String equipmentName;
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = Escape.unescape(equipmentName);
	}
	public void setModel(String model) {
		this.model = Escape.unescape(model);
	}
	public void setAction(String action) {
		this.action = Escape.unescape(action);
	}
	private Integer equipmentId;
	public void setEquipmentId(Integer equipmentId) {
		this.equipmentId = equipmentId;
	}
	private String itemName;
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setFessUnitId(Integer fessUnitId) {
		this.fessUnitId = fessUnitId;
	}
	private Integer fessUnitId;
	private String model;
	private String action;
	private Integer inputDoctor;
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	private Integer senderId;
	private String content;
	private String addressee;
	public void setInputDoctor(Integer inputDoctor) {
		this.inputDoctor = inputDoctor;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}
	private Boolean status;
	public void setStatus(Boolean status) {
		this.status = status;
	}
	private Timestamp time;
	private Float unitPrice;
	public void setOfficeSupplies(String officeSupplies) {
		this.officeSupplies = Escape.unescape(officeSupplies);
	}
	private String officeSupplies;
	private Integer mark;
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	private Integer shortMessageById;
	public void setShortMessageById(Integer shortMessageById) {
		this.shortMessageById = shortMessageById;
	}
	private String ByTime;
	public void setByTime(String byTime) {
		ByTime = byTime;
	}
	private String money;

	
	public void setMoney(String money) {
		this.money = money;
	}
	
}
