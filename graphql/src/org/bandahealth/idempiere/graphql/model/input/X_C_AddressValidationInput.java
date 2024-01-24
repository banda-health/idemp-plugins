package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_AddressValidationCfg;

import java.sql.ResultSet;

/**
 * Generated Model for C_AddressValidation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_AddressValidationInput extends MAddressValidation implements I_C_AddressValidationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AddressValidationCfg;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_AddressValidationInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAddressValidation(null, (ResultSet) null, null), null, Table_Name, ID),
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
	@JsonProperty("C_AddressValidationCfg")
	public void setC_AddressValidationCfgInput(ForeignEntityInput C_AddressValidationCfg) {
		this.mC_AddressValidationCfg = C_AddressValidationCfg;
		X_C_AddressValidationCfg foreignEntity;
		if (C_AddressValidationCfg != null &&
				(foreignEntity = new Query(getCtx(), "C_AddressValidationCfg", "C_AddressValidationCfg_UU=?", get_TrxName())
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
	public ForeignEntityInput C_AddressValidationCfg() {
		return mC_AddressValidationCfg;
	}
}
