package org.bandahealth.idempiere.rest.model;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement(name = "supplier")
@JsonInclude(value = Include.NON_NULL)
public class Vendor extends BusinessPartner {

	private static final long serialVersionUID = 1L;
	
	private String phoneNumber;
	private String emailAddress;

	public Vendor() {
	}

	public Vendor(int clientId, int orgId, String uuid, boolean isActive, String created, int createdBy,
			String description, String name, String email, String phone, BigDecimal totalOpenBalance) {
		super(clientId, orgId, uuid, isActive, created, createdBy, name, description, totalOpenBalance);
		this.emailAddress = email;
		this.phoneNumber = phone;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setemailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
}
