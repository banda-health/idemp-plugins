package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_OrderLandedCost;

/**
 * Generated Interface for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_C_OrderLandedCostInput extends I_C_OrderLandedCost {

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
	 * Set C_Order.
	 *
	 * @param C_Order Order
	 */
	void setC_OrderInput(ForeignEntityInput C_Order);

	/**
	 * Get C_Order.
	 *
	 * @return Order
	 */
	ForeignEntityInput C_Order();

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
	 * Set LandedCostDistribution.
	 *
	 * @param LandedCostDistribution Landed Cost Distribution
	 */
	void setLandedCostDistributionInput(I_AD_Ref_ListInput LandedCostDistribution);

	/**
	 * Get LandedCostDistribution.
	 *
	 * @return Landed Cost Distribution
	 */
	I_AD_Ref_ListInput LandedCostDistribution();

	/**
	 * Set M_CostElement.
	 *
	 * @param M_CostElement Product Cost Element
	 */
	void setM_CostElementInput(ForeignEntityInput M_CostElement);

	/**
	 * Get M_CostElement.
	 *
	 * @return Product Cost Element
	 */
	ForeignEntityInput M_CostElement();
}
