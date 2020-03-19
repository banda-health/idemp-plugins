package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "payment")
@JsonInclude(value = Include.NON_NULL)
public class Payment extends BaseMetadata {

	private static final long serialVersionUID = 1L;
	private int bpartnerId;
	private int chargeId;
	private int orderId;
	private BigDecimal payAmount;
	private String tenderType;

	public Payment() {
	}

	public Payment(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			int bpartnerId, int orderId, BigDecimal payAmount, String tenderType) {
		super(clientId, orgId, uuid, isActive, created, createdBy);

		this.bpartnerId = bpartnerId;
		this.orderId = orderId;
		this.payAmount = payAmount;
		this.tenderType = tenderType;
	}

	public int getBpartnerId() {
		return bpartnerId;
	}

	public void setBpartnerId(int bpartnerId) {
		this.bpartnerId = bpartnerId;
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

	public String getTenderType() {
		return tenderType;
	}

	public void setTenderType(String tenderType) {
		this.tenderType = tenderType;
	}

}
