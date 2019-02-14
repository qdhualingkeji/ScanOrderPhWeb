package com.qdhualing.app.vo;

/**
 * DrugsBaseInfo entity. @author MyEclipse Persistence Tools
 */

public class DrugsBaseInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String drugName;
	private String commonName;
	private Integer categoryId;
	private String specifications;
	private Integer drugUnitId;
	private String indications;
	private Integer pharmacyTypeId;
	private short isPrescription;
	private String remark;
	private String xmlDrugCatName;

	public String getXmlDrugCatName() {
		return xmlDrugCatName;
	}

	public void setXmlDrugCatName(String xmlDrugCatName) {
		this.xmlDrugCatName = xmlDrugCatName;
	}
	
	private String xmlManufacturer;

	public String getXmlManufacturer() {
		return xmlManufacturer;
	}

	public void setXmlManufacturer(String xmlManufacturer) {
		this.xmlManufacturer = xmlManufacturer;
	}
	
	private String xmlLotNumber;

	public String getXmlLotNumber() {
		return xmlLotNumber;
	}

	public void setXmlLotNumber(String xmlLotNumber) {
		this.xmlLotNumber = xmlLotNumber;
	}
	
	private Float xmlPurchasePrice;

	public Float getXmlPurchasePrice() {
		return xmlPurchasePrice;
	}

	public void setXmlPurchasePrice(Float xmlPurchasePrice) {
		this.xmlPurchasePrice = xmlPurchasePrice;
	}

	private Manufacturers manufacturers;
	private DrugsCategory drugsCategory;
	private GoodsInventory goodsInventory; 

	// Constructors

	public GoodsInventory getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(GoodsInventory goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public DrugsCategory getDrugsCategory() {
		return drugsCategory;
	}

	public void setDrugsCategory(DrugsCategory drugsCategory) {
		this.drugsCategory = drugsCategory;
	}

	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}

	/** default constructor */
	public DrugsBaseInfo() {
	}

	/** full constructor */
	public DrugsBaseInfo(String drugName, String commonName,
			Integer categoryId, String specifications, Integer drugUnitId,
			String indications, Integer pharmacyTypeId, short isPrescription,
			String remark) {
		this.drugName = drugName;
		this.commonName = commonName;
		this.categoryId = categoryId;
		this.specifications = specifications;
		this.drugUnitId = drugUnitId;
		this.indications = indications;
		this.pharmacyTypeId = pharmacyTypeId;
		this.isPrescription = isPrescription;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getCommonName() {
		return this.commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public Integer getDrugUnitId() {
		return this.drugUnitId;
	}

	public void setDrugUnitId(Integer drugUnitId) {
		this.drugUnitId = drugUnitId;
	}

	public String getIndications() {
		return this.indications;
	}

	public void setIndications(String indications) {
		this.indications = indications;
	}

	public Integer getPharmacyTypeId() {
		return this.pharmacyTypeId;
	}

	public void setPharmacyTypeId(Integer pharmacyTypeId) {
		this.pharmacyTypeId = pharmacyTypeId;
	}

	public short getIsPrescription() {
		return this.isPrescription;
	}

	public void setIsPrescription(short isPrescription) {
		this.isPrescription = isPrescription;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}