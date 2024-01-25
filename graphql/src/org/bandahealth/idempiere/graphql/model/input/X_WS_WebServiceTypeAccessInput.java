package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_Role;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.model.X_WS_WebServiceTypeAccess;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceTypeAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeAccessInput extends X_WS_WebServiceTypeAccess implements I_WS_WebServiceTypeAccessInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Role;
	private ForeignEntityInput mWS_WebServiceType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The WS_WebServiceTypeAccess_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_WS_WebServiceTypeAccessInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_WS_WebServiceTypeAccess(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Role != null) {
			// Since an entity was passed, make sure it's in the DB
			X_AD_Role foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Role", "AD_Role_UU=?", get_TrxName())
							.setParameters(AD_Role.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Role_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Role with UUID " + AD_Role.getUUID());
			}
		} else {
			this.setAD_Role_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (WS_WebServiceType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_WS_WebServiceType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "WS_WebServiceType", "WS_WebServiceType_UU=?", get_TrxName())
							.setParameters(WS_WebServiceType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setWS_WebServiceType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table WS_WebServiceType with UUID " + WS_WebServiceType.getUUID());
			}
		} else {
			this.setWS_WebServiceType_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setWS_WebServiceTypeAccess_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getWS_WebServiceTypeAccess_UU();
	}
}
