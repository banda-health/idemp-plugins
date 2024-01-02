package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_Product_Category;

/**
 * Generated Interface for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_Product_CategoryInput extends I_M_Product_Category {

	/**
	 * Set A_Asset_Group.
	 *
	 * @param A_Asset_Group Group of Assets
	 */
	void setA_Asset_GroupInput(I_A_Asset_GroupInput A_Asset_Group);

	/**
	 * Get A_Asset_Group.
	 *
	 * @return Group of Assets
	 */
	I_A_Asset_GroupInput A_Asset_Group();

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
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColorInput(I_AD_PrintColorInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	I_AD_PrintColorInput AD_PrintColor();

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
	void setM_Product_Category_ParentInput(I_M_Product_CategoryInput M_Product_Category_Parent);

	/**
	 * Get M_Product_Category_Parent.
	 *
	 * @return M_Product_Category_Parent
	 */
	I_M_Product_CategoryInput M_Product_Category_Parent();

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
