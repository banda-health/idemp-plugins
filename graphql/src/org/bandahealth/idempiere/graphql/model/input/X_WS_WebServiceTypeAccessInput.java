package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.model.X_WS_WebServiceTypeAccess;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceTypeAccessInput extends X_WS_WebServiceTypeAccess implements I_WS_WebServiceTypeAccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mWS_WebServiceType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_WS_WebServiceTypeAccessInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_WS_WebServiceTypeAccess(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Role.
	 *
	 * @param AD_Role Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public void setAD_RoleInput(ForeignEntityInput AD_Role) {
		this.mAD_Role = AD_Role;
		X_AD_Role foreignEntity;
		if (get_ID() == 0 && AD_Role != null &&
				(foreignEntity = new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
						.setParameters(AD_Role.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Role_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Role.
	 *
	 * @return Responsibility Role
	 */
	@JsonProperty("AD_Role")
	public ForeignEntityInput AD_Role() {
		return mAD_Role;
	}

	/**
	 * Set Web Service Type.
	 *
	 * @param WS_WebServiceType Web Service Type
	 */
	@JsonProperty("WS_WebServiceType")
	public void setWS_WebServiceTypeInput(ForeignEntityInput WS_WebServiceType) {
		this.mWS_WebServiceType = WS_WebServiceType;
		X_WS_WebServiceType foreignEntity;
		if (get_ID() == 0 && WS_WebServiceType != null &&
				(foreignEntity = new Query(getCtx(), "WS_WebServiceType", "WS_WebServiceType_UU=?", get_TrxName())
						.setParameters(WS_WebServiceType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWS_WebServiceType_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Web Service Type.
	 *
	 * @return Web Service Type
	 */
	@JsonProperty("WS_WebServiceType")
	public ForeignEntityInput WS_WebServiceType() {
		return mWS_WebServiceType;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setWS_WebServiceTypeAccess_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getWS_WebServiceTypeAccess_UU();
	}
}
