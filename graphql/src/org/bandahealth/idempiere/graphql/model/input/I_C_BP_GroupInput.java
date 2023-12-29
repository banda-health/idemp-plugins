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
	 * Column name BH_Locked
	 */
	public static final String COLUMNNAME_BH_Locked = "BH_Locked";

	/**
	 * Set BH_Locked.
	 *
	 * @param BH_Locked Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public void setBH_Locked(boolean BH_Locked);

	/**
	 * Get BH_Locked.
	 *
	 * @return Determines whether a record is locked or not (must configure each field to enabled/disabled to read from this field)
	 */
	public boolean isBH_Locked();

	/**
	 * Column name BH_SubType
	 */
	public static final String COLUMNNAME_BH_SubType = "BH_SubType";

	/**
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	public void setBH_SubType(String BH_SubType);

	/**
	 * Get Sub Type.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	public String getBH_SubType();

	/**
	 * Set BH_SubType_RL.
	 *
	 * @param BH_SubType_RL Meant to be a sub-type of the charge type
	 */
	void setBH_SubType_RL(I_AD_Ref_ListInput BH_SubType_RL);

	/**
	 * Get BH_SubType_RL.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	I_AD_Ref_ListInput getBH_SubType_RL();

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
	void setC_Dunning(I_C_DunningInput C_Dunning);

	/**
	 * Get C_Dunning.
	 *
	 * @return Dunning Rules for overdue invoices
	 */
	I_C_DunningInput getC_Dunning();

	/**
	 * Set M_DiscountSchema.
	 *
	 * @param M_DiscountSchema Schema to calculate the trade discount percentage
	 */
	void setM_DiscountSchema(I_M_DiscountSchemaInput M_DiscountSchema);

	/**
	 * Get M_DiscountSchema.
	 *
	 * @return Schema to calculate the trade discount percentage
	 */
	I_M_DiscountSchemaInput getM_DiscountSchema();

	/**
	 * Set M_PriceList.
	 *
	 * @param M_PriceList Unique identifier of a Price List
	 */
	void setM_PriceList(I_M_PriceListInput M_PriceList);

	/**
	 * Get M_PriceList.
	 *
	 * @return Unique identifier of a Price List
	 */
	I_M_PriceListInput getM_PriceList();

	/**
	 * Set PO_DiscountSchema.
	 *
	 * @param PO_DiscountSchema Schema to calculate the purchase trade discount percentage
	 */
	void setPO_DiscountSchema(I_M_DiscountSchemaInput PO_DiscountSchema);

	/**
	 * Get PO_DiscountSchema.
	 *
	 * @return Schema to calculate the purchase trade discount percentage
	 */
	I_M_DiscountSchemaInput getPO_DiscountSchema();

	/**
	 * Set PO_PriceList.
	 *
	 * @param PO_PriceList Price List used by this Business Partner
	 */
	void setPO_PriceList(I_M_PriceListInput PO_PriceList);

	/**
	 * Get PO_PriceList.
	 *
	 * @return Price List used by this Business Partner
	 */
	I_M_PriceListInput getPO_PriceList();

	/**
	 * Set PriorityBase_RL.
	 *
	 * @param PriorityBase_RL Base of Priority
	 */
	void setPriorityBase_RL(I_AD_Ref_ListInput PriorityBase_RL);

	/**
	 * Get PriorityBase_RL.
	 *
	 * @return Base of Priority
	 */
	I_AD_Ref_ListInput getPriorityBase_RL();
}
