package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.model.X_WS_WebService_Para;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_WS_WebService_ParaInput extends X_WS_WebService_Para implements I_WS_WebService_ParaInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWS_WebServiceType;
	private I_AD_Ref_ListInput mParameterType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_WS_WebService_ParaInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_WS_WebService_Para(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Parameter Name.
	 *
	 * @param ParameterName Parameter Name
	 */

	public void setParameterName(String ParameterName) {
		if (get_ID() == 0) {
			super.setParameterName(ParameterName);
		}
	}

	/**
	 * Set Parameter Type.
	 *
	 * @param ParameterType Parameter Type
	 */
	@JsonProperty("ParameterType")
	public void setParameterTypeInput(I_AD_Ref_ListInput ParameterType) {
		this.mParameterType = ParameterType;
		MRefList_BH foreignEntity;
		if (ParameterType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(ParameterType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setParameterType(foreignEntity.getValue());
		} else {
			this.setParameterType(null);
		}
	}

	/**
	 * Get Parameter Type.
	 *
	 * @return Parameter Type
	 */
	@JsonProperty("ParameterType")
	public I_AD_Ref_ListInput ParameterType() {
		return mParameterType;
	}
	/**
	 * Set Web Service Parameters.
	 *
	 * @param WS_WebService_Para_ID Web Service Parameters
	 */

	public void setWS_WebService_Para_ID(int WS_WebService_Para_ID) {
		if (get_ID() == 0) {
			super.setWS_WebService_Para_ID(WS_WebService_Para_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setWS_WebService_Para_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getWS_WebService_Para_UU();
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
		if (WS_WebServiceType != null &&
				(foreignEntity = new Query(getCtx(), "WS_WebServiceType", "WS_WebServiceType_UU=?", get_TrxName())
						.setParameters(WS_WebServiceType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setWS_WebServiceType_ID(foreignEntity.get_ID());
		} else {
			super.setWS_WebServiceType_ID(0);
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
}
