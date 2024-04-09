package org.bandahealth.idempiere.graphql.model.input;

public class ChangeAccessInput {
	private String username;
	private String AD_Client_UU;
	private String AD_Role_UU;
	private String AD_Org_UU;
	private String M_Warehouse_UU;
	private String AD_Language;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAD_Client_UU() {
		return AD_Client_UU;
	}

	public void setAD_Client_UU(String adClientId) {
		this.AD_Client_UU = adClientId;
	}

	public String getAD_Role_UU() {
		return AD_Role_UU;
	}

	public void setAD_Role_UU(String adRoleId) {
		this.AD_Role_UU = adRoleId;
	}

	public String getAD_Org_UU() {
		return AD_Org_UU;
	}

	public void setAD_Org_UU(String adOrganizationId) {
		this.AD_Org_UU = adOrganizationId;
	}

	public String getM_Warehouse_UU() {
		return M_Warehouse_UU;
	}

	public void setM_Warehouse_UU(String adWarehouseId) {
		this.M_Warehouse_UU = adWarehouseId;
	}

	public String getAD_Language() {
		return AD_Language;
	}

	public void setAD_Language(String AD_Language) {
		this.AD_Language = AD_Language;
	}
}
