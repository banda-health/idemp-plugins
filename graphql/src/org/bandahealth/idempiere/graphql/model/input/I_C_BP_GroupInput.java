package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Group;

/**
 * Generated Interface for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_BP_GroupInput extends I_C_BP_Group {

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
	 * Set BH_SubType.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	void setBH_SubTypeInput(I_AD_Ref_ListInput BH_SubType);

	/**
	 * Get BH_SubType.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	I_AD_Ref_ListInput BH_SubType();

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
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(I_C_DunningInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	I_C_DunningInput C_Dunning();

	/**
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchemaInput(I_M_DiscountSchemaInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	I_M_DiscountSchemaInput M_DiscountSchema();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput M_PriceList();

	/**
	 * Set PO_DiscountSchema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	void setPO_DiscountSchemaInput(I_M_DiscountSchemaInput PO_DiscountSchema);

	/**
	 * Get PO_DiscountSchema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	I_M_DiscountSchemaInput PO_DiscountSchema();

	/**
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceListInput(I_M_PriceListInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	I_M_PriceListInput PO_PriceList();

	/**
	 * Set PriorityBase.
	 *
	 * @param PriorityBase Base of Priority
	 */
	void setPriorityBaseInput(I_AD_Ref_ListInput PriorityBase);

	/**
	 * Get PriorityBase.
	 *
	 * @return Base of Priority
	 */
	I_AD_Ref_ListInput PriorityBase();
}
