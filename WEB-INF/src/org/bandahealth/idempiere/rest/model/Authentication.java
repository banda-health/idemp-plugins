package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authentication")
public class Authentication {
	private String username;
	private String password;
	private int clientId;
	private int roleId;
	private int organizationId;
	private int warehouseId;

	public Authentication() {
	}

	@XmlElement
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElement
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int adClientId) {
		this.clientId = adClientId;
	}

	@XmlElement
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int adRoleId) {
		this.roleId = adRoleId;
	}

	@XmlElement
	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int adOrganizationId) {
		this.organizationId = adOrganizationId;
	}

	@XmlElement
	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int adWarehouseId) {
		this.warehouseId = adWarehouseId;
	}
}
