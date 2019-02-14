package com.qdhualing.app.vo;

import java.util.Date;

/**
 * PatientTreatment entity. @author MyEclipse Persistence Tools
 */

public class PatientTreatment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer patientId;
	private Integer doctorId;
	private Date inputTime;
	private String chiefComplaint;
	private String hofPi;
	private String masculinePhysique;
	private String otherFeatures;
	private String medicalReport;
	private String initialDiagnosis;
	private String program;
	private Integer inputDoctorId;
	private Date recordTime;
	private short isPrivacy;
	private Integer hospitalId;
	private String remark;
	private DrugsBaseInfo drugsBaseInfo;
	private Prescription prescription;
	private HospitalBaseInfo hospitalBaseInfo;
	// Constructors

	public HospitalBaseInfo getHospitalBaseInfo() {
		return hospitalBaseInfo;
	}

	public void setHospitalBaseInfo(HospitalBaseInfo hospitalBaseInfo) {
		this.hospitalBaseInfo = hospitalBaseInfo;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public DrugsBaseInfo getDrugsBaseInfo() {
		return drugsBaseInfo;
	}

	public void setDrugsBaseInfo(DrugsBaseInfo drugsBaseInfo) {
		this.drugsBaseInfo = drugsBaseInfo;
	}

	/** default constructor */
	public PatientTreatment() {
	}

	/** full constructor */
	public PatientTreatment(Integer patientId, Integer doctorId,
			Date inputTime, String chiefComplaint, String hofPi,
			String masculinePhysique, String otherFeatures,
			String medicalReport, String initialDiagnosis, String program,
			Integer inputDoctorId, Date recordTime, short isPrivacy,
			Integer hospitalId, String remark) {
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.inputTime = inputTime;
		this.chiefComplaint = chiefComplaint;
		this.hofPi = hofPi;
		this.masculinePhysique = masculinePhysique;
		this.otherFeatures = otherFeatures;
		this.medicalReport = medicalReport;
		this.initialDiagnosis = initialDiagnosis;
		this.program = program;
		this.inputDoctorId = inputDoctorId;
		this.recordTime = recordTime;
		this.isPrivacy = isPrivacy;
		this.hospitalId = hospitalId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Integer getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Date getInputTime() {
		return this.inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getChiefComplaint() {
		return this.chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getHofPi() {
		return this.hofPi;
	}

	public void setHofPi(String hofPi) {
		this.hofPi = hofPi;
	}

	public String getMasculinePhysique() {
		return this.masculinePhysique;
	}

	public void setMasculinePhysique(String masculinePhysique) {
		this.masculinePhysique = masculinePhysique;
	}

	public String getOtherFeatures() {
		return this.otherFeatures;
	}

	public void setOtherFeatures(String otherFeatures) {
		this.otherFeatures = otherFeatures;
	}

	public String getMedicalReport() {
		return this.medicalReport;
	}

	public void setMedicalReport(String medicalReport) {
		this.medicalReport = medicalReport;
	}

	public String getInitialDiagnosis() {
		return this.initialDiagnosis;
	}

	public void setInitialDiagnosis(String initialDiagnosis) {
		this.initialDiagnosis = initialDiagnosis;
	}

	public String getProgram() {
		return this.program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public Integer getInputDoctorId() {
		return this.inputDoctorId;
	}

	public void setInputDoctorId(Integer inputDoctorId) {
		this.inputDoctorId = inputDoctorId;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public short getIsPrivacy() {
		return this.isPrivacy;
	}

	public void setIsPrivacy(short isPrivacy) {
		this.isPrivacy = isPrivacy;
	}

	public Integer getHospitalId() {
		return this.hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}