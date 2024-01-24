package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_AddressValidationCfg;
import org.compiere.util.Env;

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
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AddressValidation_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AddressValidationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAddressValidation(null, (ResultSet) null, null),
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
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_AddressValidation_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		if (C_AddressValidationCfg != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_AddressValidationCfg", "C_AddressValidationCfg_UU=?", get_TrxName())
							.setParameters(C_AddressValidationCfg.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AddressValidationCfg_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AddressValidationCfg with UUID " + C_AddressValidationCfg.getUUID());
			}
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
