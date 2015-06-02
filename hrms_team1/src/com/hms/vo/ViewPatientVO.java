package com.hms.vo;

public class ViewPatientVO {

	 // Logger LOG=Logger.getLogger(LoggerInitializer.class);
	private String patient_id;
	private String first_name;
	private String last_name;
	private String Date_of_diagnosis;
	private String physician_id;
	private String symptoms;
	private String diagnosis;
	private String follow_up_date;
	private String bill_amount;
	public String getPatient_id() {
		
		return patient_id;
	}
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDate_of_diagnosis() {
		return Date_of_diagnosis;
	}
	public void setDate_of_diagnosis(String date_of_diagnosis) {
		Date_of_diagnosis = date_of_diagnosis;
	}
	public String getPhysician_id() {
		return physician_id;
	}
	public void setPhysician_id(String physician_id) {
		this.physician_id = physician_id;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getFollow_up_date() {
		return follow_up_date;
	}
	public void setFollow_up_date(String follow_up_date) {
		this.follow_up_date = follow_up_date;
	}
	public String getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(String bill_amount) {
		this.bill_amount = bill_amount;
	}
	
	
	
	
}
