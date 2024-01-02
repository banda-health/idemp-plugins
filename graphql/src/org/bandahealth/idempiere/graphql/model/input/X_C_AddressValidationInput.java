package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_AddressValidationCfg;
import org.compiere.util.Env;

/**
 * Generated Model for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressValidationInput extends MAddressValidation implements I_C_AddressValidationInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_C_AddressValidationCfgInput mC_AddressValidationCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_AddressValidationInput(@JsonProperty("ID") String ID) {
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
	@JsonProperty("C_AddressValidationCfg")
	public void setC_AddressValidationCfgInput(I_C_AddressValidationCfgInput C_AddressValidationCfg) {
		this.mC_AddressValidationCfg = C_AddressValidationCfg;
		X_C_AddressValidationCfg foreignEntity;
		if (C_AddressValidationCfg != null &&
				(foreignEntity = new Query(getCtx(), X_C_AddressValidationCfg.Table_Name, X_C_AddressValidationCfg.COLUMNNAME_C_AddressValidationCfg_UU + "=?", get_TrxName())
						.setParameters(C_AddressValidationCfg.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AddressValidationCfg_ID(foreignEntity.get_ID());
		} else {
			super.setC_AddressValidationCfg_ID(0);
		}
	}

	/**
	 * Get Address Validation Configuration.
	 *
	 * @return Address Validation Configuration
	 */
	@JsonProperty("C_AddressValidationCfg")
	public I_C_AddressValidationCfgInput C_AddressValidationCfg() {
		return mC_AddressValidationCfg;
	}
}
