package org.bandahealth.idempiere.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authentication")
public class Authentication {
	private String username;
	private String password;
	private Integer clientId;
	private Integer roleId;
	private Integer organizationId;
	private Integer warehouseId;

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
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer adClientId) {
		this.clientId = adClientId;
	}

	@XmlElement
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer adRoleId) {
		this.roleId = adRoleId;
	}

	@XmlElement
	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer adOrganizationId) {
		this.organizationId = adOrganizationId;
	}

	@XmlElement
	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer adWarehouseId) {
		this.warehouseId = adWarehouseId;
	}
}
