package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_WS_WebServiceType;
import org.compiere.model.X_WS_WebService_Para;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for WS_WebService_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_WS_WebService_ParaInput extends X_WS_WebService_Para implements I_WS_WebService_ParaInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mWS_WebServiceType;
	private I_AD_Ref_ListInput mParameterType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The WS_WebService_Para_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_WS_WebService_ParaInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_WS_WebService_Para(null, (ResultSet) null, null),
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
		if (ParameterType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(ParameterType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setParameterType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + ParameterType.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setWS_WebService_Para_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
}
