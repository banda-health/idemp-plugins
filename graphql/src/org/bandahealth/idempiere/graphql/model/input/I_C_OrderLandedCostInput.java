package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_OrderLandedCost;

/**
 * Generated Interface for C_OrderLandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_C_OrderLandedCostInput extends I_C_OrderLandedCost {

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

	/**
	 * Set LandedCostDistribution.
	 *
	 * @param LandedCostDistribution Landed Cost Distribution
	 */
	void setLandedCostDistributionInput(ForeignEntityInput LandedCostDistribution);

	/**
	 * Get LandedCostDistribution.
	 *
	 * @return Landed Cost Distribution
	 */
	ForeignEntityInput LandedCostDistribution();

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
