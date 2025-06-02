package org.bandahealth.idempiere.graphql.model;

import java.sql.Timestamp;

public class DashboardFinancialVisitCharge {

	private Timestamp bucketValue;
	private Integer patientVisits;
	private Integer avgChargePatient;

	public Timestamp getBucketValue() {
		return bucketValue;
	}

	public void setBucketValue(Timestamp bucketValue) {
		this.bucketValue = bucketValue;
	}

	public Integer getPatientVisits() {
		return patientVisits;
	}

	public void setPatientVisits(Integer patientVisits) {
		this.patientVisits = patientVisits;
	}

	public Integer getAvgChargePatient() {
		return avgChargePatient;
	}

	public void setAvgChargePatient(Integer avgChargePatient) {
		this.avgChargePatient = avgChargePatient;
	}
}
