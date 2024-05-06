package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.rest.utils.DateUtil;

@XmlRootElement(name = "payment")
@JsonInclude(value = Include.NON_NULL)
public class Payment extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private BusinessPartner businessPartner;
	@JsonIgnore
	private int chargeId;
	@JsonIgnore
	private int visitId;
	private BigDecimal payAmount;
	@JsonIgnore
	private String tenderType;
	private PaymentType paymentType;
	private String description;
	private String docStatus;
	private String transactionDate;
	private BigDecimal tenderAmount;
	@JsonIgnore
	private int documentTypeId;
	private DocumentType documentType;

	public Payment() {
	}

	public Payment(MPayment_BH entity) {
		super(entity);

		this.visitId = entity.getBH_Visit_ID();
		this.payAmount = entity.getPayAmt();
		this.description = entity.getDescription();
		this.docStatus = entity.getDocStatus();
		this.transactionDate = DateUtil.parseDateOnly(entity.getDateTrx());
		this.tenderAmount = entity.getBH_tender_amount();
		setTenderType(entity.getTenderType());
		setDocumentTypeId(entity.getC_DocType_ID());
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocStatus() {
		return docStatus;
	}

	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTenderAmount() {
		return tenderAmount;
	}

	public void setTenderAmount(BigDecimal tenderAmount) {
		this.tenderAmount = tenderAmount;
	}

	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

	public int getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(int documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
}
