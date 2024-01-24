package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_M_PromotionReward;

/**
 * Generated Interface for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public interface I_M_PromotionRewardInput extends I_M_PromotionReward {

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
	 * Set C_Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	void setC_ChargeInput(ForeignEntityInput C_Charge);

	/**
	 * Get C_Charge.
	 *
	 * @return Additional document charges
	 */
	ForeignEntityInput C_Charge();

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
	 * Set M_PromotionDistribution.
	 *
	 * @param M_PromotionDistribution M_PromotionDistribution
	 */
	void setM_PromotionDistributionInput(ForeignEntityInput M_PromotionDistribution);

	/**
	 * Get M_PromotionDistribution.
	 *
	 * @return M_PromotionDistribution
	 */
	ForeignEntityInput M_PromotionDistribution();

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
	 * Set M_TargetDistribution.
	 *
	 * @param M_TargetDistribution Get product from target distribution to apply the promotion reward
	 */
	void setM_TargetDistributionInput(ForeignEntityInput M_TargetDistribution);

	/**
	 * Get M_TargetDistribution.
	 *
	 * @return Get product from target distribution to apply the promotion reward
	 */
	ForeignEntityInput M_TargetDistribution();

	/**
	 * Set RewardType.
	 *
	 * @param RewardType Type of reward which consists of percentage discount, flat discount or absolute amount
	 */
	void setRewardTypeInput(I_AD_Ref_ListInput RewardType);

	/**
	 * Get RewardType.
	 *
	 * @return Type of reward which consists of percentage discount, flat discount or absolute amount
	 */
	I_AD_Ref_ListInput RewardType();
}
