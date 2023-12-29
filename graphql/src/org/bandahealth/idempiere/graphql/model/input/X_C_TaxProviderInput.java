package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_TaxProvider;
import org.compiere.model.X_C_TaxProviderCfg;
import org.compiere.util.Env;

/**
 * Generated Model for C_TaxProvider - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_TaxProviderInput extends X_C_TaxProvider implements I_C_TaxProviderInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_TaxProviderCfgInput C_TaxProviderCfg;

	/**
	 * Standard constructor
	 */
	public X_C_TaxProviderInput(String ID) {
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
	 * Set Tax Provider.
	 *
	 * @param C_TaxProvider_ID Tax Provider
	 */

	public void setC_TaxProvider_ID(int C_TaxProvider_ID) {
		if (get_ID() == 0) {
			super.setC_TaxProvider_ID(C_TaxProvider_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_TaxProvider_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_TaxProvider_UU();
	}

	/**
	 * Set Tax Provider Configuration.
	 *
	 * @param C_TaxProviderCfg Tax Provider Configuration
	 */
	public void setC_TaxProviderCfg(I_C_TaxProviderCfgInput C_TaxProviderCfg) {
		this.C_TaxProviderCfg = C_TaxProviderCfg;
		X_C_TaxProviderCfg foreignEntity;
		if (C_TaxProviderCfg != null &&
				(foreignEntity = new Query(getCtx(), X_C_TaxProviderCfg.Table_Name, X_C_TaxProviderCfg.COLUMNNAME_C_TaxProviderCfg_UU + "=?", get_TrxName())
						.setParameters(C_TaxProviderCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_TaxProviderCfg_ID(foreignEntity.get_ID());
		} else {
			this.setC_TaxProviderCfg_ID(0);
		}
	}

	/**
	 * Get Tax Provider Configuration.
	 *
	 * @return Tax Provider Configuration
	 */
	public I_C_TaxProviderCfgInput getC_TaxProviderCfg() {
		return C_TaxProviderCfg;
	}
}
