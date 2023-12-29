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
	void setAD_Org(I_AD_OrgInput AD_Org);

	/**
	 * Get AD_Org.
	 *
	 * @return Organizational entity within client
	 */
	I_AD_OrgInput getAD_Org();

	/**
	 * Set BH_SubType_RL.
	 *
	 * @param BH_SubType_RL Meant to be a sub-type of the charge type
	 */
	void setBH_SubType_RL(I_AD_Ref_ListInput BH_SubType_RL);

	/**
	 * Get BH_SubType_RL.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	I_AD_Ref_ListInput getBH_SubType_RL();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartner(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput getC_BPartner();

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
	void setC_ChargeType(I_C_ChargeTypeInput C_ChargeType);

	/**
	 * Get C_ChargeType.
	 *
	 * @return C_ChargeType
	 */
	I_C_ChargeTypeInput getC_ChargeType();

	/**
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategory(I_C_TaxCategoryInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	I_C_TaxCategoryInput getC_TaxCategory();
}
