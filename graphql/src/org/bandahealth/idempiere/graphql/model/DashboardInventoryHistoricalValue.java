package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DashboardInventoryHistoricalValue {

	private Timestamp bucketValue;
	private BigDecimal inventoryValue;
	private BigDecimal inventoryReceived;

	public Timestamp getBucketValue() {
		return bucketValue;
	}

	public void setBucketValue(Timestamp bucketValue) {
		this.bucketValue = bucketValue;
	}

	public BigDecimal getInventoryValue() {
		return inventoryValue;
	}

	public void setInventoryValue(BigDecimal inventoryValue) {
		this.inventoryValue = inventoryValue;
	}

	public BigDecimal getInventoryReceived() {
		return inventoryReceived;
	}

	public void setInventoryReceived(BigDecimal inventoryReceived) {
		this.inventoryReceived = inventoryReceived;
	}
}
