package org.bandahealth.idempiere.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
	private Timestamp dateInvoicedCreated;
	private BigDecimal grandTotal;
	@JsonProperty("isSalesOrderTransaction")
	private boolean isSalesOrderTransaction;
	private Boolean isExpense;
	private String description;
	private List<InvoiceLine> invoiceLines;
	private String paymentRule;
	// iDempiere's DocStatus i.e Drafted, InProgress, Completed, Voided etc
	private String docStatus;
	private VoidedReason voidedReason;
	private String invoiceType;

	public Invoice() {
	}

	public Invoice(MInvoice_BH entity) {
		super(entity);
		dateInvoiced = DateUtil.parseDateOnly(entity.getDateInvoiced());
		dateInvoicedCreated = entity.getDateInvoiced();
		grandTotal = entity.getGrandTotal();
		isSalesOrderTransaction = entity.isSOTrx();
		isExpense = entity.getBH_IsExpense();
		description = entity.getDescription();
		paymentRule = entity.getPaymentRule();
		docStatus = entity.getDocStatus();
		invoiceType = entity.getBH_InvoiceType();
	}

	public Invoice(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateInvoiced, boolean isSalesOrderTransaction,
			List<InvoiceLine> invoiceLines, String docStatus, String paymentRule) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateInvoiced = dateInvoiced;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.invoiceLines = invoiceLines;
		this.docStatus = docStatus;
		this.paymentRule = paymentRule;
	}

	public Invoice(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			BusinessPartner businessPartner, String dateInvoiced, boolean isSalesOrderTransaction, String docStatus,
			BigDecimal grandTotal, String paymentRule) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartner = businessPartner;
		this.dateInvoiced = dateInvoiced;
		this.isSalesOrderTransaction = isSalesOrderTransaction;
		this.docStatus = docStatus;
		this.grandTotal = grandTotal;
		this.paymentRule = paymentRule;
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

	public boolean isSalesOrderTransaction() {
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
		
		if (isExpense) {
			setInvoiceType(MInvoice_BH.EXPENSE_InvoiceType);
		}
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

	@XmlElement
	public String getPaymentRule() {
		return paymentRule;
	}

	public void setPaymentRule(String paymentRule) {
		this.paymentRule = paymentRule;
	}

	public VoidedReason getVoidedReason() {
		return voidedReason;
	}

	public void setVoidedReason(VoidedReason voidedReason) {
		this.voidedReason = voidedReason;
	}

	public Timestamp getDateInvoicedCreated() {
		return dateInvoicedCreated;
	}

	public void setDateInvoicedCreated(Timestamp dateInvoicedCreated) {
		this.dateInvoicedCreated = dateInvoicedCreated;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
}
