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
 * @version Release 7.1 - $Id$
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
	 * @param UUID The C_Location_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_LocationInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MLocation(null, (ResultSet) null, null),
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
	 * Set City.
	 *
	 * @param C_City City
	 */
	@JsonProperty("C_City")
	public void setC_CityInput(ForeignEntityInput C_City) {
		this.mC_City = C_City;
		MCity foreignEntity;
		if (C_City != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_City", "C_City_UU=?", get_TrxName())
							.setParameters(C_City.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_City_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_City with UUID " + C_City.getUUID());
			}
		} else {
			super.setC_City_ID(0);
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
		MCountry foreignEntity;
		if (C_Country != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UUID " + C_Country.getUUID());
			}
		} else {
			super.setC_Country_ID(0);
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

	public void setC_Location_ID(int C_Location_ID) {
		if (get_ID() == 0) {
			super.setC_Location_ID(C_Location_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Location_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
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
		MRegion foreignEntity;
		if (C_Region != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Region", "C_Region_UU=?", get_TrxName())
							.setParameters(C_Region.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UUID " + C_Region.getUUID());
			}
		} else {
			super.setC_Region_ID(0);
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

	public void setIsValid(boolean IsValid) {
		if (get_ID() == 0) {
			super.setIsValid(IsValid);
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
