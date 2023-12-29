package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_AddressValidation;
import org.compiere.model.X_C_AddressValidationCfg;
import org.compiere.util.Env;

/**
 * Generated Model for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressValidationInput extends X_C_AddressValidation implements I_C_AddressValidationInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_AddressValidationCfgInput C_AddressValidationCfg;

	/**
	 * Standard constructor
	 */
	public X_C_AddressValidationInput(String ID) {
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
	 * Set Address Validation.
	 *
	 * @param C_AddressValidation_ID Address Validation
	 */

	public void setC_AddressValidation_ID(int C_AddressValidation_ID) {
		if (get_ID() == 0) {
			super.setC_AddressValidation_ID(C_AddressValidation_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_AddressValidation_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_AddressValidation_UU();
	}

	/**
	 * Set Address Validation Configuration.
	 *
	 * @param C_AddressValidationCfg Address Validation Configuration
	 */
	public void setC_AddressValidationCfg(I_C_AddressValidationCfgInput C_AddressValidationCfg) {
		this.C_AddressValidationCfg = C_AddressValidationCfg;
		X_C_AddressValidationCfg foreignEntity;
		if (C_AddressValidationCfg != null &&
				(foreignEntity = new Query(getCtx(), X_C_AddressValidationCfg.Table_Name, X_C_AddressValidationCfg.COLUMNNAME_C_AddressValidationCfg_UU + "=?", get_TrxName())
						.setParameters(C_AddressValidationCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AddressValidationCfg_ID(foreignEntity.get_ID());
		} else {
			this.setC_AddressValidationCfg_ID(0);
		}
	}

	/**
	 * Get Address Validation Configuration.
	 *
	 * @return Address Validation Configuration
	 */
	public I_C_AddressValidationCfgInput getC_AddressValidationCfg() {
		return C_AddressValidationCfg;
	}
}
