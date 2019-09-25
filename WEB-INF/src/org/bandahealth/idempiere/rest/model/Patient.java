package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class Patient extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private BigDecimal totalOpenBalance;

	public Patient() {
	}

	public Patient(int clientId, int orgId, String uuid, boolean isActive, Timestamp created, int createdBy,
			String description, String name, BigDecimal totalOpenBalance) {
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