package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MLocation;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_LocationInput extends MLocation implements I_C_LocationInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AddressValidation;
	private ForeignEntityInput mC_City;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_Region;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Location_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_LocationInput(@JsonProperty("UU") String UU) {
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
		if (!is_new()) {
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
	 * Set Address Validation.
	 *
	 * @param C_AddressValidation Address Validation
	 */
	@JsonProperty("C_AddressValidation")
	public void setC_AddressValidationInput(ForeignEntityInput C_AddressValidation) {
		this.mC_AddressValidation = C_AddressValidation;
		if (!is_new()) {
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
	 * Set City.
	 *
	 * @param C_City City
	 */
	@JsonProperty("C_City")
	public void setC_CityInput(ForeignEntityInput C_City) {
		this.mC_City = C_City;
		if (C_City != null) {
			// Since an entity was passed, make sure it's in the DB
			MCity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_City", "C_City_UU=?", get_TrxName())
							.setParameters(C_City.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_City_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_City with UU " + C_City.getUU());
			}
		} else {
			this.setC_City_ID(0);
		}
	}

	/**
	 * Get City.
	 *
	 * @return City
	 */
	@JsonProperty("C_City")
	public ForeignEntityInput C_City() {
		return mC_City;
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		if (C_Country != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UU " + C_Country.getUU());
			}
		} else {
			this.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	@JsonProperty("C_Country")
	public ForeignEntityInput C_Country() {
		return mC_Country;
	}
	/**
	 * Set Address.
	 *
	 * @param C_Location_ID Location or Address
	 */
	@JsonProperty("C_Location_ID")
	public void setC_Location_IDFromJson(int C_Location_ID) {
		if (get_ID() == 0) {
			super.setC_Location_ID(C_Location_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Location_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_Location_UU();
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public void setC_RegionInput(ForeignEntityInput C_Region) {
		this.mC_Region = C_Region;
		if (C_Region != null) {
			// Since an entity was passed, make sure it's in the DB
			MRegion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(C_Region.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UU " + C_Region.getUU());
			}
		} else {
			this.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	@JsonProperty("C_Region")
	public ForeignEntityInput C_Region() {
		return mC_Region;
	}
	/**
	 * Set Valid.
	 *
	 * @param IsValid Element is valid
	 */
	@JsonProperty("IsValid")
	public void setIsValidFromJson(boolean IsValid) {
		if (get_ID() == 0) {
			super.setIsValid(IsValid);
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
