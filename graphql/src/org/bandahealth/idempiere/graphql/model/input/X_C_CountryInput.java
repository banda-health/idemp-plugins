package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MCurrency;
import org.compiere.model.MLanguage;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_Country;
import org.compiere.util.Env;

/**
 * Generated Model for C_Country - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CountryInput extends X_C_Country implements I_C_CountryInput {

	 private I_AD_LanguageInput AD_Language_L;
	 private I_AD_OrgInput AD_Org;
	 private I_C_CurrencyInput C_Currency;

	/**
	 * Standard constructor
	 */
	public X_C_CountryInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Language.
	 *
	 * @param AD_Language_L Language for this entity
	 */
	public void setAD_Language_L(I_AD_LanguageInput AD_Language_L) {
		this.AD_Language_L = AD_Language_L;
		MLanguage foreignEntity;
		if (AD_Language_L != null &&
				(foreignEntity = new Query(getCtx(), MLanguage.Table_Name, MLanguage.COLUMNNAME_AD_Language_UU + "=?", get_TrxName())
						.setParameters(AD_Language_L.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Language(foreignEntity.getAD_Language());
		} else {
			this.setAD_Language(null);
		}
	}

	/**
	 * Get Language.
	 *
	 * @return Language for this entity
	 */
	public I_AD_LanguageInput getAD_Language_L() {
		return AD_Language_L;
	}
	/**
	 * Set Language.
	 *
	 * @param AD_Language Language for this entity
	 */

	public void setAD_Language(String AD_Language) {
		if (get_ID() == 0) {
			super.setAD_Language(AD_Language);
		}
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
	 * Set Country.
	 *
	 * @param C_Country_ID Country 
	 */

	public void setC_Country_ID(int C_Country_ID) {
		if (get_ID() == 0) {
			super.setC_Country_ID(C_Country_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Country_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Country_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}
}
