package org.bandahealth.idempiere.rest.model;

import org.bandahealth.idempiere.base.model.MBPartner_BH;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class BusinessPartner extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal totalOpenBalance;

	public BusinessPartner() {
	}

	public BusinessPartner(MBPartner_BH model) {
		super(model, model.getName(), model.getDescription(), model.getValue());

		this.totalOpenBalance = model.getTotalOpenBalance();
	}

	public BusinessPartner(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String name, String description, BigDecimal totalOpenBalance) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.totalOpenBalance = totalOpenBalance;
	}

	@XmlElement
	public BigDecimal getTotalOpenBalance() {
		return totalOpenBalance;
	}

	public void setTotalOpenBalance(BigDecimal totalOpenBalance) {
		this.totalOpenBalance = totalOpenBalance;
	}
}