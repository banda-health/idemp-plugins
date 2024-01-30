package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebService;
import org.compiere.model.X_WS_WebServiceMethod;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceMethodInput extends X_WS_WebServiceMethod implements I_WS_WebServiceMethodInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWS_WebService;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The WS_WebServiceMethod_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_WS_WebServiceMethodInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Web Service.
	 *
	 * @param WS_WebService Web Service
	 */
	@JsonProperty("WS_WebService")
	public void setWS_WebServiceInput(ForeignEntityInput WS_WebService) {
		this.mWS_WebService = WS_WebService;
		if (get_ID() != 0) {
			return;
		}
		if (WS_WebService != null) {
			// Since an entity was passed, make sure it's in the DB
			X_WS_WebService foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "WS_WebService", "WS_WebService_UU=?", get_TrxName())
							.setParameters(WS_WebService.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setWS_WebService_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table WS_WebService with UUID " + WS_WebService.getUUID());
			}
		} else {
			this.setWS_WebService_ID(0);
		}
	}

	/**
	 * Get Web Service.
	 *
	 * @return Web Service
	 */
	@JsonProperty("WS_WebService")
	public ForeignEntityInput WS_WebService() {
		return mWS_WebService;
	}
	/**
	 * Set Web Service Method.
	 *
	 * @param WS_WebServiceMethod_ID Web Service Method
	 */

	public void setWS_WebServiceMethod_ID(int WS_WebServiceMethod_ID) {
		if (get_ID() == 0) {
			super.setWS_WebServiceMethod_ID(WS_WebServiceMethod_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setWS_WebServiceMethod_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getWS_WebServiceMethod_UU();
	}
}
