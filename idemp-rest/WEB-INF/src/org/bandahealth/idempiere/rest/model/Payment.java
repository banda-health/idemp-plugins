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
	private Patient patient;
	private int chargeId;
	private int orderId;
	private BigDecimal payAmount;
	@JsonIgnore
	private String tenderType;
	private PaymentType paymentType;
	private String description;
	private NHIF nhif;
	private String docStatus;
	private String transactionDate;
	private BigDecimal tenderAmount;

	public Payment() {
	}

	public Payment(MPayment_BH entity) {
		super(entity);

		this.orderId = entity.getBH_C_Order_ID();
		this.payAmount = entity.getPayAmt();
		this.description = entity.getDescription();
		this.docStatus = entity.getDocStatus();
		this.transactionDate = DateUtil.parseDateOnly(entity.getDateTrx());
		this.tenderAmount = entity.getBH_TenderAmount();
		setTenderType(entity.getTenderType());
	}

	public Payment(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			Patient patient, int orderId, BigDecimal payAmount, PaymentType paymentType, String description, NHIF nhif,
			String docStatus, String transactionDate, BigDecimal tenderAmount, MPayment_BH entity) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.patient = patient;
		this.orderId = orderId;
		this.payAmount = payAmount;
		this.paymentType = paymentType;
		this.description = description;
		this.nhif = nhif;
		this.docStatus = docStatus;
		this.transactionDate = transactionDate;
		this.tenderAmount = tenderAmount;
		setTenderType(entity.getTenderType());
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public int getChargeId() {
		return chargeId;
	}

	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public NHIF getNhif() {
		return nhif;
	}

	public void setNhif(NHIF nhif) {
		this.nhif = nhif;
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
}
