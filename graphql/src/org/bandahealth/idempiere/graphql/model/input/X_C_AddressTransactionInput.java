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
 * @version Release 12 - $Id$
 */
public class X_C_AddressTransactionInput extends MAddressTransaction implements I_C_AddressTransactionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AddressValidation;
	private ForeignEntityInput mC_Location;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_AddressTransaction_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AddressTransactionInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within tenant
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
	@JsonProperty("C_AddressTransaction_ID")
	public void setC_AddressTransaction_IDFromJson(int C_AddressTransaction_ID) {
		if (get_ID() == 0) {
			super.setC_AddressTransaction_ID(C_AddressTransaction_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_AddressTransaction_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (get_ID() != 0) {
			return;
		}
		if (C_AddressValidation != null) {
			// Since an entity was passed, make sure it's in the DB
			MAddressValidation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AddressValidation", "C_AddressValidation_UU=?", get_TrxName())
							.setParameters(C_AddressValidation.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AddressValidation_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AddressValidation with UU " + C_AddressValidation.getUU());
			}
		} else {
			this.setC_AddressValidation_ID(0);
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
		if (C_Location != null) {
			// Since an entity was passed, make sure it's in the DB
			MLocation foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Location", "C_Location_UU=?", get_TrxName())
							.setParameters(C_Location.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Location_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Location with UU " + C_Location.getUU());
			}
		} else {
			this.setC_Location_ID(0);
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
	@JsonProperty("Country")
	public void setCountryFromJson(String Country) {
		if (get_ID() == 0) {
			super.setCountry(Country);
		}
	}
	/**
	 * Set Region.
	 *
	 * @param Region Region
	 */
	@JsonProperty("Region")
	public void setRegionFromJson(String Region) {
		if (get_ID() == 0) {
			super.setRegion(Region);
		}
	}
	/**
	 * Set Result.
	 *
	 * @param Result Result of the action taken
	 */
	@JsonProperty("Result")
	public void setResultFromJson(String Result) {
		if (get_ID() == 0) {
			super.setResult(Result);
		}
	}
}
