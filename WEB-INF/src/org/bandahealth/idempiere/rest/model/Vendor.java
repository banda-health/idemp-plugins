package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "supplier")
public class Vendor extends BusinessPartner {

	private static final long serialVersionUID = 1L;

	public Vendor() {
	}

	public Vendor(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String description, String name, BigDecimal totalOpenBalance) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description, totalOpenBalance);
	}
}
