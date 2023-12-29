package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CityInput extends MCity implements I_C_CityInput {

	 private I_AD_OrgInput AD_Org;
	 private I_C_CountryInput C_Country;
	 private I_C_RegionInput C_Region;

	/**
	 * Standard constructor
	 */
	public X_C_CityInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_City_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_City_UU();
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	public void setC_Country(I_C_CountryInput C_Country) {
		this.C_Country = C_Country;
		MCountry foreignEntity;
		if (get_ID() == 0 &&C_Country != null &&
				(foreignEntity = new Query(getCtx(), MCountry.Table_Name, MCountry.COLUMNNAME_C_Country_UU + "=?", get_TrxName())
						.setParameters(C_Country.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Country_ID(foreignEntity.get_ID());
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
}
