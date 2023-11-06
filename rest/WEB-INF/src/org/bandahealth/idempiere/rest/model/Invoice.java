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
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of iDempiere's MOrder (C_Order).
 *
 * @author andrew
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
	private String description;
	private List<InvoiceLine> invoiceLines = new ArrayList<>();
	private String paymentRule;
	// iDempiere's DocStatus i.e Drafted, InProgress, Completed, Voided etc
	private String docStatus;
	private VoidedReason voidedReason;
	@JsonIgnore
	private int documentTypeTargetId;
	private DocumentType documentTypeTarget;
	@JsonIgnore
	private int visitId;
	@JsonIgnore
	private int orderId;
	private Order order;

	public Invoice() {
	}

	public Invoice(MInvoice_BH entity) {
		super(entity);
		dateInvoiced = DateUtil.parseDateOnly(entity.getDateInvoiced());
		dateInvoicedCreated = entity.getDateInvoiced();
		grandTotal = entity.getGrandTotal();
		isSalesOrderTransaction = entity.isSOTrx();
		description = entity.getDescription();
		paymentRule = entity.getPaymentRule();
		docStatus = entity.getDocStatus();
		setDocumentTypeTargetId(entity.getC_DocType_ID());
		setVisitId(entity.getBH_Visit_ID());
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

	@JsonProperty("isSalesOrderTransaction")
	public boolean isSalesOrderTransaction() {
		return isSalesOrderTransaction;
	}

	@JsonProperty("isSalesOrderTransaction")
	public void setSalesOrderTransaction(boolean salesOrderTransaction) {
		isSalesOrderTransaction = salesOrderTransaction;
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

	@JsonIgnore
	public int getDocumentTypeTargetId() {
		return documentTypeTargetId;
	}

	@JsonIgnore
	public void setDocumentTypeTargetId(int documentTypeTargetId) {
		this.documentTypeTargetId = documentTypeTargetId;
	}

	public DocumentType getDocumentTypeTarget() {
		return documentTypeTarget;
	}

	public void setDocumentTypeTarget(DocumentType documentTypeTarget) {
		this.documentTypeTarget = documentTypeTarget;
	}

	@JsonIgnore
	public int getVisitId() {
		return visitId;
	}

	@JsonIgnore
	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
