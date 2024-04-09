package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payer_Info_Fld_Val_Sug;

/**
 * Generated Interface for BH_Payer_Info_Fld_Val_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_Payer_Info_Fld_Val_SugInput extends I_BH_Payer_Info_Fld_Val_Sug {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within tenant
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set BH_Payer_Info_Fld_Sug.
	 *
	 * @param BH_Payer_Info_Fld_Sug BH_Payer_Info_Fld_Sug
	 */
	void setBH_Payer_Info_Fld_SugInput(ForeignEntityInput BH_Payer_Info_Fld_Sug);

	/**
	 * Get BH_Payer_Info_Fld_Sug.
	 *
	 * @return BH_Payer_Info_Fld_Sug
	 */
	ForeignEntityInput BH_Payer_Info_Fld_Sug();

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	void setUU(String UU);

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	String getUU();
}
