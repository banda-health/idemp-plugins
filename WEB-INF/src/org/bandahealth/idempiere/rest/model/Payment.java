package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "payment")
@JsonInclude(value = Include.NON_NULL)
public class Payment extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private int businessPartnerId;
	private int chargeId;
	private int orderId;
	private BigDecimal payAmount;
	private PaymentType paymentType;
	private String description;
	private NHIF nhif;

	public Payment() {
	}

	public Payment(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			int businessPartnerId, int orderId, BigDecimal payAmount, PaymentType paymentType, String description,
			NHIF nhif) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.businessPartnerId = businessPartnerId;
		this.orderId = orderId;
		this.payAmount = payAmount;
		this.paymentType = paymentType;
		this.description = description;
		this.nhif = nhif;
	}

	public int getBusinessPartnerId() {
		return businessPartnerId;
	}

	public void setBusinessPartnerId(int businessPartnerId) {
		this.businessPartnerId = businessPartnerId;
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
}
