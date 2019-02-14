package com.qdhualing.app.vo;

/**
 * GoodsInventory entity. @author MyEclipse Persistence Tools
 */

public class GoodsInventory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer goodsId;
	private Integer goodsTypeId;
	private float purchasePrice;
	private float sellingPrice;
	private String barcode;
	private String lotNumber;
	private Integer count;
	private Integer caps;
	private Integer lower;
	private Integer hospitalId;
	private Integer manufacturersId;
	private DrugsBaseInfo drugsBaseInfo;
	private Manufacturers manufacturers;
	public Manufacturers getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(Manufacturers manufacturers) {
		this.manufacturers = manufacturers;
	}

	private HospitalOfficeSupplies hospitalOfficeSupplies ;
	// Constructors

	public HospitalOfficeSupplies getHospitalOfficeSupplies() {
		return hospitalOfficeSupplies;
	}

	public void setHospitalOfficeSupplies(
			HospitalOfficeSupplies hospitalOfficeSupplies) {
		this.hospitalOfficeSupplies = hospitalOfficeSupplies;
	}

	public DrugsBaseInfo getDrugsBaseInfo() {
		return drugsBaseInfo;
	}

	public void setDrugsBaseInfo(DrugsBaseInfo drugsBaseInfo) {
		this.drugsBaseInfo = drugsBaseInfo;
	}

	/** default constructor */
	public GoodsInventory() {
	}

	/** full constructor */
	public GoodsInventory(Integer goodsId, Integer goodsTypeId,
			float sellingPrice,float purchasePrice, String barcode, String lotNumber, Integer count, Integer caps,
			Integer lower, Integer hospitalId, Integer manufacturersId) {
		this.goodsId = goodsId;
		this.goodsTypeId = goodsTypeId;
		this.sellingPrice = sellingPrice;
		this.barcode = barcode;
		this.lotNumber = lotNumber;
		this.count = count;
		this.caps = caps;
		this.purchasePrice = purchasePrice;
		this.lower = lower;
		this.hospitalId = hospitalId;
		this.manufacturersId = manufacturersId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public float getSellingPrice() {
		return this.sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public float getPurchasePrice() {
		return this.purchasePrice;
	}
	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getBarcode() {
		return this.barcode;
	}
	public String getLotNumber() {
		return this.lotNumber;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCaps() {
		return this.caps;
	}

	public void setCaps(Integer caps) {
		this.caps = caps;
	}

	public Integer getLower() {
		return this.lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Integer getManufacturersId() {
		return this.manufacturersId;
	}

	public void setManufacturersId(Integer manufacturersId) {
		this.manufacturersId = manufacturersId;
	}

}