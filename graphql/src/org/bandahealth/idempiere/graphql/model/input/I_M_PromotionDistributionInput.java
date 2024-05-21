package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PromotionDistribution;

/**
 * Generated Interface for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public interface I_M_PromotionDistributionInput extends I_M_PromotionDistribution {

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
	 * Set DistributionSorting.
	 *
	 * @param DistributionSorting Quantity distribution sorting by unit price
	 */
	void setDistributionSortingInput(ForeignEntityInput DistributionSorting);

	/**
	 * Get DistributionSorting.
	 *
	 * @return Quantity distribution sorting by unit price
	 */
	ForeignEntityInput DistributionSorting();

	/**
	 * Set DistributionType.
	 *
	 * @param DistributionType Type of quantity distribution calculation using comparison qty and order qty as operand
	 */
	void setDistributionTypeInput(ForeignEntityInput DistributionType);

	/**
	 * Get DistributionType.
	 *
	 * @return Type of quantity distribution calculation using comparison qty and order qty as operand
	 */
	ForeignEntityInput DistributionType();

	/**
	 * Set M_Promotion.
	 *
	 * @param M_Promotion M_Promotion
	 */
	void setM_PromotionInput(ForeignEntityInput M_Promotion);

	/**
	 * Get M_Promotion.
	 *
	 * @return M_Promotion
	 */
	ForeignEntityInput M_Promotion();

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
	 * Set M_PromotionLine.
	 *
	 * @param M_PromotionLine M_PromotionLine
	 */
	void setM_PromotionLineInput(ForeignEntityInput M_PromotionLine);

	/**
	 * Get M_PromotionLine.
	 *
	 * @return M_PromotionLine
	 */
	ForeignEntityInput M_PromotionLine();

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	void setOperationInput(ForeignEntityInput Operation);

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	ForeignEntityInput Operation();
}
