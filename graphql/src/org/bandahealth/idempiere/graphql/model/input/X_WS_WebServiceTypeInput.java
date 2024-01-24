package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MTable;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebService;
import org.compiere.model.X_WS_WebServiceMethod;
import org.compiere.model.X_WS_WebServiceType;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebServiceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebServiceTypeInput extends X_WS_WebServiceType implements I_WS_WebServiceTypeInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_Table;
	private ForeignEntityInput mWS_WebService;
	private ForeignEntityInput mWS_WebServiceMethod;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_WS_WebServiceTypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_WS_WebServiceType(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Table.
	 *
	 * @param AD_Table Database Table information
	 */
	@JsonProperty("AD_Table")
	public void setAD_TableInput(ForeignEntityInput AD_Table) {
		this.mAD_Table = AD_Table;
		MTable foreignEntity;
		if (AD_Table != null &&
				(foreignEntity = new Query(getCtx(), "AD_Table", "AD_Table_UU=?", get_TrxName())
						.setParameters(AD_Table.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Table_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Table_ID(0);
		}
	}

	/**
	 * Get Table.
	 *
	 * @return Database Table information
	 */
	@JsonProperty("AD_Table")
	public ForeignEntityInput AD_Table() {
		return mAD_Table;
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
		if (WS_WebService != null &&
				(foreignEntity = new Query(getCtx(), "WS_WebService", "WS_WebService_UU=?", get_TrxName())
						.setParameters(WS_WebService.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWS_WebService_ID(foreignEntity.get_ID());
		} else {
			super.setWS_WebService_ID(0);
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
	 * @param WS_WebServiceMethod Web Service Method
	 */
	@JsonProperty("WS_WebServiceMethod")
	public void setWS_WebServiceMethodInput(ForeignEntityInput WS_WebServiceMethod) {
		this.mWS_WebServiceMethod = WS_WebServiceMethod;
		X_WS_WebServiceMethod foreignEntity;
		if (WS_WebServiceMethod != null &&
				(foreignEntity = new Query(getCtx(), "WS_WebServiceMethod", "WS_WebServiceMethod_UU=?", get_TrxName())
						.setParameters(WS_WebServiceMethod.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWS_WebServiceMethod_ID(foreignEntity.get_ID());
		} else {
			super.setWS_WebServiceMethod_ID(0);
		}
	}

	/**
	 * Get Web Service Method.
	 *
	 * @return Web Service Method
	 */
	@JsonProperty("WS_WebServiceMethod")
	public ForeignEntityInput WS_WebServiceMethod() {
		return mWS_WebServiceMethod;
	}
	/**
	 * Set Web Service Type.
	 *
	 * @param WS_WebServiceType_ID Web Service Type
	 */

	public void setWS_WebServiceType_ID(int WS_WebServiceType_ID) {
		if (get_ID() == 0) {
			super.setWS_WebServiceType_ID(WS_WebServiceType_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setWS_WebServiceType_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getWS_WebServiceType_UU();
	}
}
