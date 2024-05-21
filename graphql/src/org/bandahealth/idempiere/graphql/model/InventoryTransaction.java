package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class InventoryTransaction {
	private Integer createdBy;
	private Timestamp created;
	private Integer transactionId;
	private Integer orderId;
	private Integer movementId;
	private Integer visitId;
	private Integer locatorId;
	private Integer productId;
	private BigDecimal movementQty;
	private Integer attributeSetInstanceId;
	private BigDecimal runningTotal;
	private String transactionType;

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMovementId() {
		return movementId;
	}

	public void setMovementId(Integer movementId) {
		this.movementId = movementId;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public Integer getLocatorId() {
		return locatorId;
	}

	public void setLocatorId(Integer locatorId) {
		this.locatorId = locatorId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public BigDecimal getMovementQty() {
		return movementQty;
	}

	public void setMovementQty(BigDecimal movementQty) {
		this.movementQty = movementQty;
	}

	public Integer getAttributeSetInstanceId() {
		return attributeSetInstanceId;
	}

	public void setAttributeSetInstanceId(Integer attributeSetInstanceId) {
		this.attributeSetInstanceId = attributeSetInstanceId;
	}

	public BigDecimal getRunningTotal() {
		return runningTotal;
	}

	public void setRunningTotal(BigDecimal runningTotal) {
		this.runningTotal = runningTotal;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
