package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAddressTransaction;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AddressTransactionInput extends MAddressTransaction implements I_C_AddressTransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AddressValidation;
	private ForeignEntityInput mC_Location;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AddressTransaction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AddressTransactionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MAddressTransaction(null, (ResultSet) null, null),
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
	 * Set Address Transaction.
	 *
	 * @param C_AddressTransaction_ID Address Transaction
	 */

	public void setC_AddressTransaction_ID(int C_AddressTransaction_ID) {
		if (get_ID() == 0) {
			super.setC_AddressTransaction_ID(C_AddressTransaction_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_AddressTransaction_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_AddressTransaction_UU();
	}

	/**
	 * Set Address Validation.
	 *
	 * @param C_AddressValidation Address Validation
	 */
	@JsonProperty("C_AddressValidation")
	public void setC_AddressValidationInput(ForeignEntityInput C_AddressValidation) {
		this.mC_AddressValidation = C_AddressValidation;
		MAddressValidation foreignEntity;
		if (get_ID() == 0 && C_AddressValidation != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_AddressValidation", "C_AddressValidation_UU=?", get_TrxName())
							.setParameters(C_AddressValidation.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AddressValidation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AddressValidation with UUID " + C_AddressValidation.getUUID());
			}
		}
	}

	/**
	 * Get Address Validation.
	 *
	 * @return Address Validation
	 */
	@JsonProperty("C_AddressValidation")
	public ForeignEntityInput C_AddressValidation() {
		return mC_AddressValidation;
	}

	/**
	 * Set Address.
	 *
	 * @param C_Location Location or Address
	 */
	@JsonProperty("C_Location")
	public void setC_LocationInput(ForeignEntityInput C_Location) {
		this.mC_Location = C_Location;
		MLocation foreignEntity;
		if (C_Location != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UUID " + C_Location.getUUID());
			}
		} else {
			super.setC_Location_ID(0);
		}
	}

	/**
	 * Get Address.
	 *
	 * @return Location or Address
	 */
	@JsonProperty("C_Location")
	public ForeignEntityInput C_Location() {
		return mC_Location;
	}
	/**
	 * Set Country.
	 *
	 * @param Country Country
	 */

	public void setCountry(String Country) {
		if (get_ID() == 0) {
			super.setCountry(Country);
		}
	}
	/**
	 * Set Region.
	 *
	 * @param Region Region
	 */

	public void setRegion(String Region) {
		if (get_ID() == 0) {
			super.setRegion(Region);
		}
	}
	/**
	 * Set Result.
	 *
	 * @param Result Result of the action taken
	 */

	public void setResult(String Result) {
		if (get_ID() == 0) {
			super.setResult(Result);
		}
	}
}
