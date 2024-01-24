package org.bandahealth.idempiere.graphql.model.input;

public class ChangeAccessInput {
	private String username;
	private String clientUuid;
	private String roleUuid;
	private String organizationUuid;
	private String warehouseUuid;
	private String language;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientUuid() {
		return clientUuid;
	}

	public void setClientUuid(String adClientId) {
		this.clientUuid = adClientId;
	}

	public String getRoleUuid() {
		return roleUuid;
	}

	public void setRoleUuid(String adRoleId) {
		this.roleUuid = adRoleId;
	}

	public String getOrganizationUuid() {
		return organizationUuid;
	}

	public void setOrganizationUuid(String adOrganizationId) {
		this.organizationUuid = adOrganizationId;
	}

	public String getWarehouseUuid() {
		return warehouseUuid;
	}

	public void setWarehouseUuid(String adWarehouseId) {
		this.warehouseUuid = adWarehouseId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
