package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_PA_GoalRestriction;

/**
 * Generated Interface for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public interface I_PA_GoalRestrictionInput extends I_PA_GoalRestriction {

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
	 * Set C_BP_Group.
	 *
	 * @param C_BP_Group Business Partner Group
	 */
	void setC_BP_GroupInput(ForeignEntityInput C_BP_Group);

	/**
	 * Get C_BP_Group.
	 *
	 * @return Business Partner Group
	 */
	ForeignEntityInput C_BP_Group();

	/**
	 * Set GoalRestrictionType.
	 *
	 * @param GoalRestrictionType Goal Restriction Type
	 */
	void setGoalRestrictionTypeInput(ForeignEntityInput GoalRestrictionType);

	/**
	 * Get GoalRestrictionType.
	 *
	 * @return Goal Restriction Type
	 */
	ForeignEntityInput GoalRestrictionType();

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
	 * Set PA_Goal.
	 *
	 * @param PA_Goal Performance Goal
	 */
	void setPA_GoalInput(ForeignEntityInput PA_Goal);

	/**
	 * Get PA_Goal.
	 *
	 * @return Performance Goal
	 */
	ForeignEntityInput PA_Goal();

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
