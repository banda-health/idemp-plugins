package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MCountryGroupCountry;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_CountryGroupCountry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_CountryGroupCountryInput extends MCountryGroupCountry implements I_C_CountryGroupCountryInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Country;
	private ForeignEntityInput mC_CountryGroup;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_CountryGroupCountry_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_CountryGroupCountryInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MCountryGroupCountry(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
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
							.setParameters(C_Country.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
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
	 * Set Country Group.
	 *
	 * @param C_CountryGroup Country Group
	 */
	@JsonProperty("C_CountryGroup")
	public void setC_CountryGroupInput(ForeignEntityInput C_CountryGroup) {
		this.mC_CountryGroup = C_CountryGroup;
		if (get_ID() != 0) {
			return;
		}
		if (C_CountryGroup != null) {
			// Since an entity was passed, make sure it's in the DB
			MCountryGroup foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CountryGroup", "C_CountryGroup_UU=?", get_TrxName())
							.setParameters(C_CountryGroup.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_CountryGroup_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CountryGroup with UUID " + C_CountryGroup.getUUID());
			}
		} else {
			this.setC_CountryGroup_ID(0);
		}
	}

	/**
	 * Get Country Group.
	 *
	 * @return Country Group
	 */
	@JsonProperty("C_CountryGroup")
	public ForeignEntityInput C_CountryGroup() {
		return mC_CountryGroup;
	}
	/**
	 * Set Country on Country Group.
	 *
	 * @param C_CountryGroupCountry_ID Country on Country Group
	 */

	public void setC_CountryGroupCountry_ID(int C_CountryGroupCountry_ID) {
		if (get_ID() == 0) {
			super.setC_CountryGroupCountry_ID(C_CountryGroupCountry_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_CountryGroupCountry_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_CountryGroupCountry_UU();
	}
}
