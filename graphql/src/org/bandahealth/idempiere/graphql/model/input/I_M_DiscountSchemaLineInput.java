package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_DiscountSchemaLine;

/**
 * Generated Interface for M_DiscountSchemaLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_DiscountSchemaLineInput extends I_M_DiscountSchemaLine {

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
	void setLimit_BaseInput(I_AD_Ref_ListInput Limit_Base);

	/**
	 * Get Limit_Base.
	 *
	 * @return Base price for calculation of the new price
	 */
	I_AD_Ref_ListInput Limit_Base();

	/**
	 * Set Limit_Rounding.
	 *
	 * @param Limit_Rounding Rounding of the final result
	 */
	void setLimit_RoundingInput(I_AD_Ref_ListInput Limit_Rounding);

	/**
	 * Get Limit_Rounding.
	 *
	 * @return Rounding of the final result
	 */
	I_AD_Ref_ListInput Limit_Rounding();

	/**
	 * Set List_Base.
	 *
	 * @param List_Base Price used as the basis for price list calculations
	 */
	void setList_BaseInput(I_AD_Ref_ListInput List_Base);

	/**
	 * Get List_Base.
	 *
	 * @return Price used as the basis for price list calculations
	 */
	I_AD_Ref_ListInput List_Base();

	/**
	 * Set List_Rounding.
	 *
	 * @param List_Rounding Rounding rule for final list price
	 */
	void setList_RoundingInput(I_AD_Ref_ListInput List_Rounding);

	/**
	 * Get List_Rounding.
	 *
	 * @return Rounding rule for final list price
	 */
	I_AD_Ref_ListInput List_Rounding();

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
	void setStd_BaseInput(I_AD_Ref_ListInput Std_Base);

	/**
	 * Get Std_Base.
	 *
	 * @return Base price for calculating new standard price
	 */
	I_AD_Ref_ListInput Std_Base();

	/**
	 * Set Std_Rounding.
	 *
	 * @param Std_Rounding Rounding rule for calculated price
	 */
	void setStd_RoundingInput(I_AD_Ref_ListInput Std_Rounding);

	/**
	 * Get Std_Rounding.
	 *
	 * @return Rounding rule for calculated price
	 */
	I_AD_Ref_ListInput Std_Rounding();
}
