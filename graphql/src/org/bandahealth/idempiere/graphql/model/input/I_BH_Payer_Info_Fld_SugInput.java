package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Payer_Info_Fld_Sug;

/**
 * Generated Interface for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_BH_Payer_Info_Fld_SugInput extends I_BH_Payer_Info_Fld_Sug {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(ForeignEntityInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	ForeignEntityInput AD_Org();

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	void setUUID(String UUID);

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	String getUUID();

	/**
	 * Set BH_PayerInfoFieldDataType.
	 *
	 * @param BH_PayerInfoFieldDataType BH_PayerInfoFieldDataType
	 */
	void setBH_PayerInfoFieldDataTypeInput(I_AD_Ref_ListInput BH_PayerInfoFieldDataType);

	/**
	 * Get BH_PayerInfoFieldDataType.
	 *
	 * @return BH_PayerInfoFieldDataType
	 */
	I_AD_Ref_ListInput BH_PayerInfoFieldDataType();

	/**
	 * Set BH_SubType.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	void setBH_SubTypeInput(I_AD_Ref_ListInput BH_SubType);

	/**
	 * Get BH_SubType.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	I_AD_Ref_ListInput BH_SubType();
}
