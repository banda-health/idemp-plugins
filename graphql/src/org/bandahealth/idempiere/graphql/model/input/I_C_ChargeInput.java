package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Charge;

/**
 * Generated Interface for C_Charge - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_ChargeInput extends I_C_Charge {

	/**
	 * Set AD_Org.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	void setAD_OrgInput(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput AD_Org();

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

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	void setID(String ID);

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	String getID();

	/**
	 * Set C_ChargeType.
	 *
	 * @param C_ChargeType C_ChargeType
	 */
	void setC_ChargeTypeInput(I_C_ChargeTypeInput C_ChargeType);

	/**
	 * Get C_ChargeType.
	 *
	 * @return C_ChargeType
	 */
	I_C_ChargeTypeInput C_ChargeType();

	/**
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategoryInput(I_C_TaxCategoryInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	I_C_TaxCategoryInput C_TaxCategory();
}
