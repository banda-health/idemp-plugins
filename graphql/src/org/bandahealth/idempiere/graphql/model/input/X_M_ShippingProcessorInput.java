package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.MShippingProcessor;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShippingProcessorCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorInput extends MShippingProcessor implements I_M_ShippingProcessorInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_M_ShippingProcessorCfgInput mM_ShippingProcessorCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_ShippingProcessorInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_ShippingProcessor_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getM_ShippingProcessor_UU();
	}

	/**
	 * Set Shipping Processor Configuration.
	 *
	 * @param M_ShippingProcessorCfg Shipping Processor Configuration
	 */
	@JsonProperty("M_ShippingProcessorCfg")
	public void setM_ShippingProcessorCfgInput(I_M_ShippingProcessorCfgInput M_ShippingProcessorCfg) {
		this.mM_ShippingProcessorCfg = M_ShippingProcessorCfg;
		X_M_ShippingProcessorCfg foreignEntity;
		if (M_ShippingProcessorCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShippingProcessorCfg.Table_Name, X_M_ShippingProcessorCfg.COLUMNNAME_M_ShippingProcessorCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShippingProcessorCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_ShippingProcessorCfg_ID(foreignEntity.get_ID());
		} else {
			super.setM_ShippingProcessorCfg_ID(0);
		}
	}

	/**
	 * Get Shipping Processor Configuration.
	 *
	 * @return Shipping Processor Configuration
	 */
	@JsonProperty("M_ShippingProcessorCfg")
	public I_M_ShippingProcessorCfgInput M_ShippingProcessorCfg() {
		return mM_ShippingProcessorCfg;
	}
}
