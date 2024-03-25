package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_BP_Group;

/**
 * Generated Interface for C_BP_Group - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_BP_GroupInput extends I_C_BP_Group {

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
	 * Column name BH_Locked
	 */
	static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	void setBH_Locked(boolean BH_Locked);

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	boolean isBH_Locked();

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
	 * Set C_Dunning.
	 *
	 * @param C_Dunning Dunning Rules for overdue invoices
	 */
	void setC_DunningInput(ForeignEntityInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	ForeignEntityInput C_Dunning();

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
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceListInput(ForeignEntityInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	ForeignEntityInput M_PriceList();

	/**
	 * Set PO_DiscountSchema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	void setPO_DiscountSchemaInput(ForeignEntityInput PO_DiscountSchema);

	/**
	 * Get PO_DiscountSchema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	ForeignEntityInput PO_DiscountSchema();

	/**
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceListInput(ForeignEntityInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	ForeignEntityInput PO_PriceList();

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
