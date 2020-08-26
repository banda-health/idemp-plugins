package org.bandahealth.idempiere.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "patientVital")
@JsonInclude(value = Include.NON_NULL)
public class PatientVital implements Serializable {

	private static final long serialVersionUID = 1L;

	private String chiefComplaint;
	private String temperature;
	private String pulse;
	private String respiratoryRate;
	private String bloodPressure;
	private String height;
	private String weight;

	public PatientVital() {
	}

	public PatientVital(String chiefComplaint, String temperature, String pulse, String respiratoryRate,
			String bloodPressure, String height, String weight) {
		this.chiefComplaint = chiefComplaint;
		this.temperature = temperature;
		this.pulse = pulse;
		this.respiratoryRate = respiratoryRate;
		this.bloodPressure = bloodPressure;
		this.height = height;
		this.weight = weight;
	}

	@XmlElement
	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	@XmlElement
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@XmlElement
	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	
	@XmlElement
	public String getRespiratoryRate() {
		return respiratoryRate;
	}

	public void setRespiratoryRate(String respiratoryRate) {
		this.respiratoryRate = respiratoryRate;
	}

	@XmlElement
	public String getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	@XmlElement
	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	@XmlElement
	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
}
