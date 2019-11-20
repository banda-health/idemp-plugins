package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class Patient extends BusinessPartner {

	private static final long serialVersionUID = 1L;

	public Patient() {
	}

	public Patient(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String description, String name, BigDecimal totalOpenBalance) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description, totalOpenBalance);
	}
}