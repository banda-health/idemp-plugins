package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patientsummary")
public class PatientSummary extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private int totalVisits;
	private int inpatientVisits;
	private int outpatientVisits;
	private int patientsWithOutstandingBalance;

	public PatientSummary(int totalVisits, int inpatientVisits, int outpatientVisits,
			int patientsWithOutstandingBalance) {
		super();
		this.totalVisits = totalVisits;
		this.inpatientVisits = inpatientVisits;
		this.outpatientVisits = outpatientVisits;
		this.patientsWithOutstandingBalance = patientsWithOutstandingBalance;
	}

	@XmlElement
	public int getTotalVisits() {
		return totalVisits;
	}

	public void setTotalVisits(int totalVisits) {
		this.totalVisits = totalVisits;
	}

	@XmlElement
	public int getInpatientVisits() {
		return inpatientVisits;
	}

	public void setInpatientVisits(int inpatientVisits) {
		this.inpatientVisits = inpatientVisits;
	}

	@XmlElement
	public int getOutpatientVisits() {
		return outpatientVisits;
	}

	public void setOutpatientVisits(int oupatientVisits) {
		this.outpatientVisits = oupatientVisits;
	}

	@XmlElement
	public int getPatientsWithOutstandingBalance() {
		return patientsWithOutstandingBalance;
	}

	public void setPatientsWithOutstandingBalance(int patientsWithOutstandingBalance) {
		this.patientsWithOutstandingBalance = patientsWithOutstandingBalance;
	}

}
