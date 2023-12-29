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
	void setA_Asset_Group(I_A_Asset_GroupInput A_Asset_Group);

	/**
	 * Get A_Asset_Group.
	 *
	 * @return Group of Assets
	 */
	I_A_Asset_GroupInput getA_Asset_Group();

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
	 * Set AD_PrintColor.
	 *
	 * @param AD_PrintColor Color used for printing and display
	 */
	void setAD_PrintColor(I_AD_PrintColorInput AD_PrintColor);

	/**
	 * Get AD_PrintColor.
	 *
	 * @return Color used for printing and display
	 */
	I_AD_PrintColorInput getAD_PrintColor();

	/**
	 * Set BH_Product_Category_Type_RL.
	 *
	 * @param BH_Product_Category_Type_RL Contains a character the is linked to a ref list to determine types of product categories
	 */
	void setBH_Product_Category_Type_RL(I_AD_Ref_ListInput BH_Product_Category_Type_RL);

	/**
	 * Get BH_Product_Category_Type_RL.
	 *
	 * @return Contains a character the is linked to a ref list to determine types of product categories
	 */
	I_AD_Ref_ListInput getBH_Product_Category_Type_RL();

	/**
	 * Set M_Product_Category_Parent.
	 *
	 * @param M_Product_Category_Parent M_Product_Category_Parent
	 */
	void setM_Product_Category_Parent(I_M_Product_CategoryInput M_Product_Category_Parent);

	/**
	 * Get M_Product_Category_Parent.
	 *
	 * @return M_Product_Category_Parent
	 */
	I_M_Product_CategoryInput getM_Product_Category_Parent();

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
	 * Set MMPolicy_RL.
	 *
	 * @param MMPolicy_RL Material Movement Policy
	 */
	void setMMPolicy_RL(I_AD_Ref_ListInput MMPolicy_RL);

	/**
	 * Get MMPolicy_RL.
	 *
	 * @return Material Movement Policy
	 */
	I_AD_Ref_ListInput getMMPolicy_RL();
}
