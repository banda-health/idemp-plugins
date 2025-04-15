package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payer_Info_Fld_Sug;

/**
 * Generated Interface for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_BH_Payer_Info_Fld_SugInput extends I_BH_Payer_Info_Fld_Sug {

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

	/**
	 * Set BH_PayerInfoFieldDataType.
	 *
	 * @param BH_PayerInfoFieldDataType BH_PayerInfoFieldDataType
	 */
	void setBH_PayerInfoFieldDataTypeInput(ForeignEntityInput BH_PayerInfoFieldDataType);

	/**
	 * Get BH_PayerInfoFieldDataType.
	 *
	 * @return BH_PayerInfoFieldDataType
	 */
	ForeignEntityInput BH_PayerInfoFieldDataType();

	/**
	 * Set BH_SubType.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	void setBH_SubTypeInput(ForeignEntityInput BH_SubType);

	/**
	 * Get BH_SubType.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	ForeignEntityInput BH_SubType();
}
