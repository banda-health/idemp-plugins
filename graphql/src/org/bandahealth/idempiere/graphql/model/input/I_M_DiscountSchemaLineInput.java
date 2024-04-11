package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_DiscountSchemaLine;

/**
 * Generated Interface for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_DiscountSchemaLineInput extends I_M_DiscountSchemaLine {

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
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(ForeignEntityInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	ForeignEntityInput C_BPartner();

	/**
	 * Set C_ConversionType.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType);

	/**
	 * Get C_ConversionType.
	 *
	 * @return Currency Conversion Rate Type
	 */
	ForeignEntityInput C_ConversionType();

	/**
	 * Set Limit_Base.
	 *
	 * @param Limit_Base Base price for calculation of the new price
	 */
	void setLimit_BaseInput(ForeignEntityInput Limit_Base);

	/**
	 * Get Limit_Base.
	 *
	 * @return Base price for calculation of the new price
	 */
	ForeignEntityInput Limit_Base();

	/**
	 * Set Limit_Rounding.
	 *
	 * @param Limit_Rounding Rounding of the final result
	 */
	void setLimit_RoundingInput(ForeignEntityInput Limit_Rounding);

	/**
	 * Get Limit_Rounding.
	 *
	 * @return Rounding of the final result
	 */
	ForeignEntityInput Limit_Rounding();

	/**
	 * Set List_Base.
	 *
	 * @param List_Base Price used as the basis for price list calculations
	 */
	void setList_BaseInput(ForeignEntityInput List_Base);

	/**
	 * Get List_Base.
	 *
	 * @return Price used as the basis for price list calculations
	 */
	ForeignEntityInput List_Base();

	/**
	 * Set List_Rounding.
	 *
	 * @param List_Rounding Rounding rule for final list price
	 */
	void setList_RoundingInput(ForeignEntityInput List_Rounding);

	/**
	 * Get List_Rounding.
	 *
	 * @return Rounding rule for final list price
	 */
	ForeignEntityInput List_Rounding();

	/**
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchemaInput(ForeignEntityInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	ForeignEntityInput M_DiscountSchema();

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
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(ForeignEntityInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	ForeignEntityInput M_Product_Category();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(ForeignEntityInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	ForeignEntityInput M_Product();

	/**
	 * Set Std_Base.
	 *
	 * @param Std_Base Base price for calculating new standard price
	 */
	void setStd_BaseInput(ForeignEntityInput Std_Base);

	/**
	 * Get Std_Base.
	 *
	 * @return Base price for calculating new standard price
	 */
	ForeignEntityInput Std_Base();

	/**
	 * Set Std_Rounding.
	 *
	 * @param Std_Rounding Rounding rule for calculated price
	 */
	void setStd_RoundingInput(ForeignEntityInput Std_Rounding);

	/**
	 * Get Std_Rounding.
	 *
	 * @return Rounding rule for calculated price
	 */
	ForeignEntityInput Std_Rounding();
}
