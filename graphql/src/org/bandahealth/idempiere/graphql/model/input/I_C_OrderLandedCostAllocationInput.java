package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_OrderLandedCostAllocation;

/**
 * Generated Interface for C_OrderLandedCostAllocation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_OrderLandedCostAllocationInput extends I_C_OrderLandedCostAllocation {

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
	 * Set C_OrderLandedCost.
	 *
	 * @param C_OrderLandedCost C_OrderLandedCost
	 */
	void setC_OrderLandedCostInput(ForeignEntityInput C_OrderLandedCost);

	/**
	 * Get C_OrderLandedCost.
	 *
	 * @return C_OrderLandedCost
	 */
	ForeignEntityInput C_OrderLandedCost();

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
	 * Set C_OrderLine.
	 *
	 * @param C_OrderLine Sales Order Line
	 */
	void setC_OrderLineInput(ForeignEntityInput C_OrderLine);

	/**
	 * Get C_OrderLine.
	 *
	 * @return Sales Order Line
	 */
	ForeignEntityInput C_OrderLine();
}
