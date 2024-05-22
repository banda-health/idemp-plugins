package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Product_CategoryDefault;

/**
 * Generated Interface for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_BH_Product_CategoryDefaultInput extends I_BH_Product_CategoryDefault {

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
	 * Set BH_Product_Category_Type.
	 *
	 * @param BH_Product_Category_Type Contains a character the is linked to a ref list to determine types of product categories
	 */
	void setBH_Product_Category_TypeInput(ForeignEntityInput BH_Product_Category_Type);

	/**
	 * Get BH_Product_Category_Type.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	ForeignEntityInput BH_Product_Category_Type();

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
