package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Representation of iDempiere's MOrder (C_Order).
 * 
 * @author andrew
 *
 */
@JsonInclude(value = Include.NON_NULL)
public class Invoice extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private BusinessPartner businessPartner;
	private String dateInvoiced;
	private BigDecimal grandTotal;
	private boolean isSalesOrderTransaction;
	private Boolean isExpense;
	private String description;
	private List<InvoiceLine> invoiceLines;
	// iDempiere's DocStatus i.e Drafted, InProgress, Completed, Voided etc
	private String docStatus;

	public Invoice() {
	}

	public Invoice(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
								 BusinessPartner businessPartner, String dateInvoiced, BigDecimal grandTotal, boolean isSalesOrderTransaction,
								 String description, List<InvoiceLine> invoiceLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateInvoiced = dateInvoiced;
		this.grandTotal = grandTotal;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.description = description;
		this.invoiceLines = invoiceLines;
		this.docStatus = docStatus;
	}

	public Invoice(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
								 BusinessPartner businessPartner, String dateInvoiced, boolean isSalesOrderTransaction,
								 List<InvoiceLine> invoiceLines, String docStatus) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateInvoiced = dateInvoiced;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.invoiceLines = invoiceLines;
		this.docStatus = docStatus;
	}

	public Invoice(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
								 BusinessPartner businessPartner, String dateInvoiced, boolean isSalesOrderTransaction, String docStatus,
								 BigDecimal grandTotal) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateInvoiced = dateInvoiced;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.docStatus = docStatus;
		this.grandTotal = grandTotal;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	@XmlElement
	public String getDateInvoiced() {
		return dateInvoiced;
	}

	public void setDateInvoiced(String dateInvoiced) {
		this.dateInvoiced = dateInvoiced;
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

	public void setIsExpense(Boolean isExpense) {
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
	public List<InvoiceLine> getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(List<InvoiceLine> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	@XmlElement
	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
}
