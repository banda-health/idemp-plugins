package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCountry;
import org.compiere.model.MCountryGroup;
import org.compiere.model.MCountryGroupCountry;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

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
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_CountryGroupCountryInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MCountryGroupCountry(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Country.
	 *
	 * @param C_Country Country 
	 */
	@JsonProperty("C_Country")
	public void setC_CountryInput(ForeignEntityInput C_Country) {
		this.mC_Country = C_Country;
		MCountry foreignEntity;
		if (get_ID() == 0 && C_Country != null &&
				(foreignEntity = new Query(getCtx(), "C_Country", "C_Country_UU=?", get_TrxName())
						.setParameters(C_Country.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Country_ID(foreignEntity.get_ID());
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
		MCountryGroup foreignEntity;
		if (get_ID() == 0 && C_CountryGroup != null &&
				(foreignEntity = new Query(getCtx(), "C_CountryGroup", "C_CountryGroup_UU=?", get_TrxName())
						.setParameters(C_CountryGroup.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CountryGroup_ID(foreignEntity.get_ID());
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_CountryGroupCountry_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_CountryGroupCountry_UU();
	}
}
