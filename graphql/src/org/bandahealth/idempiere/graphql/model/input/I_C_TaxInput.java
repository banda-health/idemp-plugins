package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Tax;

/**
 * Generated Interface for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_TaxInput extends I_C_Tax {

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
	 * Set AD_Rule.
	 *
	 * @param AD_Rule AD_Rule
	 */
	void setAD_RuleInput(I_AD_RuleInput AD_Rule);

	/**
	 * Get AD_Rule.
	 *
	 * @return AD_Rule
	 */
	I_AD_RuleInput AD_Rule();

	/**
	 * Set C_Country.
	 *
	 * @param C_Country Country 
	 */
	void setC_CountryInput(I_C_CountryInput C_Country);

	/**
	 * Get C_Country.
	 *
	 * @return Country 
	 */
	I_C_CountryInput C_Country();

	/**
	 * Set C_CountryGroupFrom.
	 *
	 * @param C_CountryGroupFrom C_CountryGroupFrom
	 */
	void setC_CountryGroupFromInput(I_C_CountryGroupInput C_CountryGroupFrom);

	/**
	 * Get C_CountryGroupFrom.
	 *
	 * @return C_CountryGroupFrom
	 */
	I_C_CountryGroupInput C_CountryGroupFrom();

	/**
	 * Set C_CountryGroupTo.
	 *
	 * @param C_CountryGroupTo C_CountryGroupTo
	 */
	void setC_CountryGroupToInput(I_C_CountryGroupInput C_CountryGroupTo);

	/**
	 * Get C_CountryGroupTo.
	 *
	 * @return C_CountryGroupTo
	 */
	I_C_CountryGroupInput C_CountryGroupTo();

	/**
	 * Set C_Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	void setC_RegionInput(I_C_RegionInput C_Region);

	/**
	 * Get C_Region.
	 *
	 * @return Identifies a geographical Region
	 */
	I_C_RegionInput C_Region();

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

	/**
	 * Set C_TaxProvider.
	 *
	 * @param C_TaxProvider C_TaxProvider
	 */
	void setC_TaxProviderInput(I_C_TaxProviderInput C_TaxProvider);

	/**
	 * Get C_TaxProvider.
	 *
	 * @return C_TaxProvider
	 */
	I_C_TaxProviderInput C_TaxProvider();

	/**
	 * Set Parent_Tax.
	 *
	 * @param Parent_Tax Parent Tax indicates a tax that is made up of multiple taxes
	 */
	void setParent_TaxInput(I_C_TaxInput Parent_Tax);

	/**
	 * Get Parent_Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	I_C_TaxInput Parent_Tax();

	/**
	 * Set SOPOType.
	 *
	 * @param SOPOType Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	void setSOPOTypeInput(I_AD_Ref_ListInput SOPOType);

	/**
	 * Get SOPOType.
	 *
	 * @return Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	I_AD_Ref_ListInput SOPOType();

	/**
	 * Set To_Region.
	 *
	 * @param To_Region Receiving Region
	 */
	void setTo_RegionInput(I_C_RegionInput To_Region);

	/**
	 * Get To_Region.
	 *
	 * @return Receiving Region
	 */
	I_C_RegionInput To_Region();
}
