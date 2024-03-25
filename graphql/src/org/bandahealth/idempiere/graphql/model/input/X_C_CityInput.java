package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCity;
import org.compiere.model.MCountry;
import org.compiere.model.MOrg;
import org.compiere.model.MRegion;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_City - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CityInput extends MCity implements I_C_CityInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_Region;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_City_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CityInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
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
	 * Set City.
	 *
	 * @param C_City_ID City
	 */

	public void setC_City_ID(int C_City_ID) {
		if (get_ID() == 0) {
			super.setC_City_ID(C_City_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_City_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_City_UU();
	}

	/**
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		if (get_ID() != 0) {
			return;
		}
		if (C_Country != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountry foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
							.setParameters(C_Country.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Country_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Country with UUID " + C_Country.getUUID());
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
							.setParameters(C_Region.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Region_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Region with UUID " + C_Region.getUUID());
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
}
