package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Representation of iDempiere's MOrder (C_Order).
 * 
 * @author andrew
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class Order extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private BusinessPartner businessPartner;
	private String dateOrdered;
	private BigDecimal grandTotal;
	private boolean isSalesOrderTransaction;
	private Boolean isExpense;
	private String description;
	private List<OrderLine> orderLines;
	private List<Payment> payments;
	// iDempiere's DocStatus i.e Drafted, InProgress, Completed, Voided etc
	private String docStatus;

	public Order() {
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, BigDecimal grandTotal, boolean isSalesOrderTransaction,
			String description, List<OrderLine> orderLines, List<Payment> payments, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.grandTotal = grandTotal;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.description = description;
		this.orderLines = orderLines;
		this.payments = payments;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, boolean isSalesOrderTransaction,
			List<OrderLine> orderLines, List<Payment> payments, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.orderLines = orderLines;
		this.payments = payments;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, boolean isSalesOrderTransaction,
			List<OrderLine> orderLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.orderLines = orderLines;
		this.docStatus = docStatus;
	}

	public Order(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateOrdered, boolean isSalesOrderTransaction, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateOrdered = dateOrdered;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.docStatus = docStatus;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	@XmlElement
	public String getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	@XmlElement
	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	@JsonIgnore
	public boolean isIsSalesOrderTransaction() {
		return isSalesOrderTransaction;
	}

	public void setIsSalesOrderTransaction(boolean isSalesOrderTransaction) {
		this.isSalesOrderTransaction = isSalesOrderTransaction;
	}

	@JsonIgnore
	public Boolean isExpense() {
		return isExpense;
	}

	public void setExpense(Boolean isExpense) {
		this.isExpense = isExpense;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	@XmlElement
	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@XmlElement
	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
}
