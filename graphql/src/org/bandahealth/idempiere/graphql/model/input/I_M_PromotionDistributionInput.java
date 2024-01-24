package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PromotionDistribution;

/**
 * Generated Interface for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public interface I_M_PromotionDistributionInput extends I_M_PromotionDistribution {

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
	 * Set DistributionSorting.
	 *
	 * @param DistributionSorting Quantity distribution sorting by unit price
	 */
	void setDistributionSortingInput(I_AD_Ref_ListInput DistributionSorting);

	/**
	 * Get DistributionSorting.
	 *
	 * @return Quantity distribution sorting by unit price
	 */
	I_AD_Ref_ListInput DistributionSorting();

	/**
	 * Set DistributionType.
	 *
	 * @param DistributionType Type of quantity distribution calculation using comparison qty and order qty as operand
	 */
	void setDistributionTypeInput(I_AD_Ref_ListInput DistributionType);

	/**
	 * Get DistributionType.
	 *
	 * @return Type of quantity distribution calculation using comparison qty and order qty as operand
	 */
	I_AD_Ref_ListInput DistributionType();

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
	void setOperationInput(I_AD_Ref_ListInput Operation);

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	I_AD_Ref_ListInput Operation();
}
