package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Product_CategoryDefault;

/**
 * Generated Interface for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_BH_Product_CategoryDefaultInput extends I_BH_Product_CategoryDefault {

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
	 * Set BH_Product_Category_Type.
	 *
	 * @param BH_Product_Category_Type Contains a character the is linked to a ref list to determine types of product categories
	 */
	void setBH_Product_Category_TypeInput(I_AD_Ref_ListInput BH_Product_Category_Type);

	/**
	 * Get BH_Product_Category_Type.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	I_AD_Ref_ListInput BH_Product_Category_Type();

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
}
