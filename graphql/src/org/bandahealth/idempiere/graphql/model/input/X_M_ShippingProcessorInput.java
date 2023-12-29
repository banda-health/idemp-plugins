package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_ShippingProcessor;
import org.compiere.model.X_M_ShippingProcessorCfg;
import org.compiere.util.Env;

/**
 * Generated Model for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ShippingProcessorInput extends X_M_ShippingProcessor implements I_M_ShippingProcessorInput {

	 private I_AD_OrgInput AD_Org;
	 private I_M_ShippingProcessorCfgInput M_ShippingProcessorCfg;

	/**
	 * Standard constructor
	 */
	public X_M_ShippingProcessorInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}
	/**
	 * Set Shipping Processor.
	 *
	 * @param M_ShippingProcessor_ID Shipping Processor
	 */

	public void setM_ShippingProcessor_ID(int M_ShippingProcessor_ID) {
		if (get_ID() == 0) {
			super.setM_ShippingProcessor_ID(M_ShippingProcessor_ID);
		}
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
	public void setM_ShippingProcessorCfg(I_M_ShippingProcessorCfgInput M_ShippingProcessorCfg) {
		this.M_ShippingProcessorCfg = M_ShippingProcessorCfg;
		X_M_ShippingProcessorCfg foreignEntity;
		if (M_ShippingProcessorCfg != null &&
				(foreignEntity = new Query(getCtx(), X_M_ShippingProcessorCfg.Table_Name, X_M_ShippingProcessorCfg.COLUMNNAME_M_ShippingProcessorCfg_UU + "=?", get_TrxName())
						.setParameters(M_ShippingProcessorCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_ShippingProcessorCfg_ID(foreignEntity.get_ID());
		} else {
			this.setM_ShippingProcessorCfg_ID(0);
		}
	}

	/**
	 * Get Shipping Processor Configuration.
	 *
	 * @return Shipping Processor Configuration
	 */
	public I_M_ShippingProcessorCfgInput getM_ShippingProcessorCfg() {
		return M_ShippingProcessorCfg;
	}
}
