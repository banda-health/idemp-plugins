package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Tax;

/**
 * Generated Interface for C_Tax - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public interface I_C_TaxInput extends I_C_Tax {

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
	 * Set AD_Rule.
	 *
	 * @param AD_Rule AD_Rule
	 */
	void setAD_RuleInput(ForeignEntityInput AD_Rule);

	/**
	 * Get AD_Rule.
	 *
	 * @return AD_Rule
	 */
	ForeignEntityInput AD_Rule();

	/**
	 * Set C_Country.
	 *
	 * @param C_Country Country 
	 */
	void setC_CountryInput(ForeignEntityInput C_Country);

	/**
	 * Get C_Country.
	 *
	 * @return Country 
	 */
	ForeignEntityInput C_Country();

	/**
	 * Set C_CountryGroupFrom.
	 *
	 * @param C_CountryGroupFrom C_CountryGroupFrom
	 */
	void setC_CountryGroupFromInput(ForeignEntityInput C_CountryGroupFrom);

	/**
	 * Get C_CountryGroupFrom.
	 *
	 * @return C_CountryGroupFrom
	 */
	ForeignEntityInput C_CountryGroupFrom();

	/**
	 * Set C_CountryGroupTo.
	 *
	 * @param C_CountryGroupTo C_CountryGroupTo
	 */
	void setC_CountryGroupToInput(ForeignEntityInput C_CountryGroupTo);

	/**
	 * Get C_CountryGroupTo.
	 *
	 * @return C_CountryGroupTo
	 */
	ForeignEntityInput C_CountryGroupTo();

	/**
	 * Set C_Region.
	 *
	 * @param C_Region Identifies a geographical Region
	 */
	void setC_RegionInput(ForeignEntityInput C_Region);

	/**
	 * Get C_Region.
	 *
	 * @return Identifies a geographical Region
	 */
	ForeignEntityInput C_Region();

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
	 * Set C_TaxCategory.
	 *
	 * @param C_TaxCategory Tax Category
	 */
	void setC_TaxCategoryInput(ForeignEntityInput C_TaxCategory);

	/**
	 * Get C_TaxCategory.
	 *
	 * @return Tax Category
	 */
	ForeignEntityInput C_TaxCategory();

	/**
	 * Set C_TaxProvider.
	 *
	 * @param C_TaxProvider C_TaxProvider
	 */
	void setC_TaxProviderInput(ForeignEntityInput C_TaxProvider);

	/**
	 * Get C_TaxProvider.
	 *
	 * @return C_TaxProvider
	 */
	ForeignEntityInput C_TaxProvider();

	/**
	 * Set Parent_Tax.
	 *
	 * @param Parent_Tax Parent Tax indicates a tax that is made up of multiple taxes
	 */
	void setParent_TaxInput(ForeignEntityInput Parent_Tax);

	/**
	 * Get Parent_Tax.
	 *
	 * @return Parent Tax indicates a tax that is made up of multiple taxes
	 */
	ForeignEntityInput Parent_Tax();

	/**
	 * Set SOPOType.
	 *
	 * @param SOPOType Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	void setSOPOTypeInput(ForeignEntityInput SOPOType);

	/**
	 * Get SOPOType.
	 *
	 * @return Sales Tax applies to sales situations, Purchase Tax to purchase situations
	 */
	ForeignEntityInput SOPOType();

	/**
	 * Set TaxPostingIndicator.
	 *
	 * @param TaxPostingIndicator Type of input tax (deductible and non deductible)
	 */
	void setTaxPostingIndicatorInput(ForeignEntityInput TaxPostingIndicator);

	/**
	 * Get TaxPostingIndicator.
	 *
	 * @return Type of input tax (deductible and non deductible)
	 */
	ForeignEntityInput TaxPostingIndicator();

	/**
	 * Set To_Region.
	 *
	 * @param To_Region Receiving Region
	 */
	void setTo_RegionInput(ForeignEntityInput To_Region);

	/**
	 * Get To_Region.
	 *
	 * @return Receiving Region
	 */
	ForeignEntityInput To_Region();
}
