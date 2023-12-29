package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAddressValidation;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.model.X_C_Location;
import org.compiere.util.Env;

/**
 * Generated Model for C_Location - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_LocationInput extends X_C_Location implements I_C_LocationInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_AddressValidationInput C_AddressValidation;
	 private I_C_CityInput C_City;
	 private I_C_CountryInput C_Country;
	 private I_C_RegionInput C_Region;

	/**
	 * Standard constructor
	 */
	public X_C_LocationInput(String ID) {
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
	 * @param C_AddressValidation Address Validation
	 */
	public void setC_AddressValidation(I_C_AddressValidationInput C_AddressValidation) {
		this.C_AddressValidation = C_AddressValidation;
		MAddressValidation foreignEntity;
		if (get_ID() == 0 &&C_AddressValidation != null &&
				(foreignEntity = new Query(getCtx(), MAddressValidation.Table_Name, MAddressValidation.COLUMNNAME_C_AddressValidation_UU + "=?", get_TrxName())
						.setParameters(C_AddressValidation.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AddressValidation_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Address Validation.
	 *
	 * @return Address Validation
	 */
	public I_C_AddressValidationInput getC_AddressValidation() {
		return C_AddressValidation;
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
	 * Set City.
	 *
	 * @param C_City City
	 */
	public void setC_City(I_C_CityInput C_City) {
		this.C_City = C_City;
		MCity foreignEntity;
		if (C_City != null &&
				(foreignEntity = new Query(getCtx(), MCity.Table_Name, MCity.COLUMNNAME_C_City_UU + "=?", get_TrxName())
						.setParameters(C_City.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_City_ID(foreignEntity.get_ID());
		} else {
			this.setC_City_ID(0);
		}
	}

	/**
	 * Get City.
	 *
	 * @return City
	 */
	public I_C_CityInput getC_City() {
		return C_City;
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	public void setC_Country(I_C_CountryInput C_Country) {
		this.C_Country = C_Country;
		MCountry foreignEntity;
		if (C_Country != null &&
				(foreignEntity = new Query(getCtx(), MCountry.Table_Name, MCountry.COLUMNNAME_C_Country_UU + "=?", get_TrxName())
						.setParameters(C_Country.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Country_ID(foreignEntity.get_ID());
		} else {
			this.setC_Country_ID(0);
		}
	}

	/**
	 * Get Country.
	 *
	 * @return Country 
	 */
	public I_C_CountryInput getC_Country() {
		return C_Country;
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Location_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Location_UU();
	}

	/**
	 * Set Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	public void setC_Region(I_C_RegionInput C_Region) {
		this.C_Region = C_Region;
		MRegion foreignEntity;
		if (C_Region != null &&
				(foreignEntity = new Query(getCtx(), MRegion.Table_Name, MRegion.COLUMNNAME_C_Region_UU + "=?", get_TrxName())
						.setParameters(C_Region.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Region_ID(foreignEntity.get_ID());
		} else {
			this.setC_Region_ID(0);
		}
	}

	/**
	 * Get Region.
	 *
	 * @return Identifies a geographical Region
	 */
	public I_C_RegionInput getC_Region() {
		return C_Region;
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
