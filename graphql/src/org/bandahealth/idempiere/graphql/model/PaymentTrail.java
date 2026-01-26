package org.bandahealth.idempiere.graphql.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PaymentTrail {

	private Integer clientId;
	private Integer businessPartnerId;
	private Integer invoiceId;
	private Integer paymentId;
	private BigDecimal debits;
	private BigDecimal credits;
	private Integer visitId;
	private Timestamp transactionDate;
	private Timestamp created;
	private Timestamp updated;
	private String patientName;
	private Integer createdBy;
	private BigDecimal openBalance;
	private String item;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	public BigDecimal getDebits() {
		return debits;
	}

	public void setDebits(BigDecimal debits) {
		this.debits = debits;
	}

	public BigDecimal getCredits() {
		return credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
}
