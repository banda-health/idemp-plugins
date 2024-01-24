package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MPInstance;
import org.compiere.model.Query;
import org.eevolution.model.X_T_MRP_CRP;

import java.sql.ResultSet;

/**
 * Generated Model for T_MRP_CRP - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_T_MRP_CRPInput extends X_T_MRP_CRP implements I_T_MRP_CRPInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAD_PInstance;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_T_MRP_CRPInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_T_MRP_CRP(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Process Instance.
	 *
	 * @param AD_PInstance Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public void setAD_PInstanceInput(ForeignEntityInput AD_PInstance) {
		this.mAD_PInstance = AD_PInstance;
		MPInstance foreignEntity;
		if (AD_PInstance != null &&
				(foreignEntity = new Query(getCtx(), "AD_PInstance", "AD_PInstance_UU=?", get_TrxName())
						.setParameters(AD_PInstance.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_PInstance_ID(foreignEntity.get_ID());
		} else {
			super.setAD_PInstance_ID(0);
		}
	}

	/**
	 * Get Process Instance.
	 *
	 * @return Instance of the process
	 */
	@JsonProperty("AD_PInstance")
	public ForeignEntityInput AD_PInstance() {
		return mAD_PInstance;
	}
	/**
	 * Set Temporal MRP & CRP.
	 *
	 * @param T_MRP_CRP_ID Temporal MRP & CRP
	 */

	public void setT_MRP_CRP_ID(int T_MRP_CRP_ID) {
		if (get_ID() == 0) {
			super.setT_MRP_CRP_ID(T_MRP_CRP_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setT_MRP_CRP_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getT_MRP_CRP_UU();
	}
}
