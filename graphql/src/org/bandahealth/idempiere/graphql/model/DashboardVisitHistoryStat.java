package org.bandahealth.idempiere.graphql.model;

import java.sql.Timestamp;

public class DashboardVisitHistoryStat {
	private Timestamp bucketValue;
	private Integer referenceListId;
	private String alternateVisitType;
	private Integer frequency;

	public Timestamp getBucketValue() {
		return bucketValue;
	}

	public void setBucketValue(Timestamp bucketValue) {
		this.bucketValue = bucketValue;
	}

	public Integer getReferenceListId() {
		return referenceListId;
	}

	public void setReferenceListId(Integer referenceListId) {
		this.referenceListId = referenceListId;
	}

	public String getAlternateVisitType() {
		return alternateVisitType;
	}

	public void setAlternateVisitType(String alternateVisitType) {
		this.alternateVisitType = alternateVisitType;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
}
