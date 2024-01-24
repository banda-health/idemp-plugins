package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product_Category;

/**
 * Generated Interface for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_Product_CategoryInput extends I_M_Product_Category {

	/**
	 * Set A_Asset_Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	void setA_Asset_GroupInput(ForeignEntityInput A_Asset_Group);

	/**
	 * Get A_Asset_Group.
	 *
	 * @return Group of Assets
	 */
	ForeignEntityInput A_Asset_Group();

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
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColorInput(ForeignEntityInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	ForeignEntityInput AD_PrintColor();

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
	 * Set M_Product_Category_Parent.
	 *
	 * @param M_Product_Category_Parent M_Product_Category_Parent
	 */
	void setM_Product_Category_ParentInput(ForeignEntityInput M_Product_Category_Parent);

	/**
	 * Get M_Product_Category_Parent.
	 *
	 * @return M_Product_Category_Parent
	 */
	ForeignEntityInput M_Product_Category_Parent();

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
	 * Set MMPolicy.
	 *
	 * @param MMPolicy Material Movement Policy
	 */
	void setMMPolicyInput(I_AD_Ref_ListInput MMPolicy);

	/**
	 * Get MMPolicy.
	 *
	 * @return Material Movement Policy
	 */
	I_AD_Ref_ListInput MMPolicy();
}
