package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentTrail {
	private Integer clientId;
	private Integer visitId;
	private Integer invoiceId;
	private Integer businessPartnerId;
	private Integer paymentId;
	private Timestamp date;
	private Timestamp created;
	private Timestamp updated;
	private Timestamp orderingDate;
	private Integer createdBy;
	private Integer orderId;
	private BigDecimal charged;
	private BigDecimal paid;
	private BigDecimal openBalance;
	private Integer baseReversalInvoiceId;
	private Integer baseReversalPaymentId;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(Integer businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public BigDecimal getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(BigDecimal openBalance) {
		this.openBalance = openBalance;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getCharged() {
		return charged;
	}

	public void setCharged(BigDecimal charged) {
		this.charged = charged;
	}

	public BigDecimal getPaid() {
		return paid;
	}

	public void setPaid(BigDecimal paid) {
		this.paid = paid;
	}

	public Integer getBaseReversalInvoiceId() {
		return baseReversalInvoiceId;
	}

	public void setBaseReversalInvoiceId(Integer baseReversalInvoiceId) {
		this.baseReversalInvoiceId = baseReversalInvoiceId;
	}

	public Integer getBaseReversalPaymentId() {
		return baseReversalPaymentId;
	}

	public void setBaseReversalPaymentId(Integer baseReversalPaymentId) {
		this.baseReversalPaymentId = baseReversalPaymentId;
	}

	public Timestamp getOrderingDate() {
		return orderingDate;
	}

	public void setOrderingDate(Timestamp orderingDate) {
		this.orderingDate = orderingDate;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}
}
