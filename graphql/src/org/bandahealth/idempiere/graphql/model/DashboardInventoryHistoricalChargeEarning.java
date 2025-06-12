package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DashboardInventoryHistoricalChargeEarning {

	private Timestamp bucketValue;
	private BigDecimal charges;
	private BigDecimal margins;

	public Timestamp getBucketValue() {
		return bucketValue;
	}

	public void setBucketValue(Timestamp bucketValue) {
		this.bucketValue = bucketValue;
	}

	public BigDecimal getCharges() {
		return charges;
	}

	public void setCharges(BigDecimal charges) {
		this.charges = charges;
	}

	public BigDecimal getMargins() {
		return margins;
	}

	public void setMargins(BigDecimal margins) {
		this.margins = margins;
	}
}
