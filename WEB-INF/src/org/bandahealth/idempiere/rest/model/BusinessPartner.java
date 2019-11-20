package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;

public class BusinessPartner extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal totalOpenBalance;

	public BusinessPartner() {
	}

	public BusinessPartner(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String description, String name, BigDecimal totalOpenBalance) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description);

		this.totalOpenBalance = totalOpenBalance;
	}

	public BusinessPartner updateFields(int clientId, int orgId, String uuid, boolean isActive, String created,
			int createdBy, String description, String name, BigDecimal totalOpenBalance) {
		setClientId(clientId);
		setOrgId(orgId);
		setUuid(uuid);
		setActive(isActive);
		setCreated(created);
		setCreatedBy(createdBy);
		setDescription(description);
		setName(name);
		setTotalOpenBalance(totalOpenBalance);

		return this;
	}

	@XmlElement
	public BigDecimal getTotalOpenBalance() {
		return totalOpenBalance;
	}

	public void setTotalOpenBalance(BigDecimal totalOpenBalance) {
		this.totalOpenBalance = totalOpenBalance;
	}
}