package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_GoalRestriction;

/**
 * Generated Interface for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_PA_GoalRestrictionInput extends I_PA_GoalRestriction {

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
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(I_C_BP_GroupInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	I_C_BP_GroupInput C_BP_Group();

	/**
	 * Set C_BPartner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	void setC_BPartnerInput(I_C_BPartnerInput C_BPartner);

	/**
	 * Get C_BPartner.
	 *
	 * @return Identifies a Business Partner
	 */
	I_C_BPartnerInput C_BPartner();

	/**
	 * Set GoalRestrictionType.
	 *
	 * @param GoalRestrictionType Goal Restriction Type
	 */
	void setGoalRestrictionTypeInput(I_AD_Ref_ListInput GoalRestrictionType);

	/**
	 * Get GoalRestrictionType.
	 *
	 * @return Goal Restriction Type
	 */
	I_AD_Ref_ListInput GoalRestrictionType();

	/**
	 * Set M_Product_Category.
	 *
	 * @param M_Product_Category Category of a Product
	 */
	void setM_Product_CategoryInput(I_M_Product_CategoryInput M_Product_Category);

	/**
	 * Get M_Product_Category.
	 *
	 * @return Category of a Product
	 */
	I_M_Product_CategoryInput M_Product_Category();

	/**
	 * Set M_Product.
	 *
	 * @param M_Product Product, Service, Item
	 */
	void setM_ProductInput(I_M_ProductInput M_Product);

	/**
	 * Get M_Product.
	 *
	 * @return Product, Service, Item
	 */
	I_M_ProductInput M_Product();

	/**
	 * Set PA_Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	void setPA_GoalInput(I_PA_GoalInput PA_Goal);

	/**
	 * Get PA_Goal.
	 *
	 * @return Performance Goal
	 */
	I_PA_GoalInput PA_Goal();

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
}
