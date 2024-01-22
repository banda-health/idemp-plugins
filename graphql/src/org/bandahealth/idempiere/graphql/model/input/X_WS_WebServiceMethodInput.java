package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebService;
import org.compiere.model.X_WS_WebServiceMethod;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceMethod - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebServiceMethodInput extends X_WS_WebServiceMethod implements I_WS_WebServiceMethodInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWS_WebService;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_WS_WebServiceMethodInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_WS_WebServiceMethod(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Web Service.
	 *
	 * @param WS_WebService Web Service
	 */
	@JsonProperty("WS_WebService")
	public void setWS_WebServiceInput(ForeignEntityInput WS_WebService) {
		this.mWS_WebService = WS_WebService;
		X_WS_WebService foreignEntity;
		if (get_ID() == 0 && WS_WebService != null &&
				(foreignEntity = new Query(getCtx(), "WS_WebService", "WS_WebService_UU=?", get_TrxName())
						.setParameters(WS_WebService.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWS_WebService_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setWS_WebServiceMethod_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getWS_WebServiceMethod_UU();
	}
}
