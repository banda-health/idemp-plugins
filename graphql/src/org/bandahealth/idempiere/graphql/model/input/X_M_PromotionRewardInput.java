package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionDistribution;
import org.compiere.model.X_M_PromotionReward;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_PromotionRewardInput extends X_M_PromotionReward implements I_M_PromotionRewardInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mM_Promotion;
	private ForeignEntityInput mM_PromotionDistribution;
	private ForeignEntityInput mM_TargetDistribution;
	private I_AD_Ref_ListInput mDistributionSorting;
	private I_AD_Ref_ListInput mRewardType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_PromotionReward_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PromotionRewardInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_M_PromotionReward(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UUID " + C_Charge.getUUID());
			}
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Distribution Sorting.
	 *
	 * @param DistributionSorting Quantity distribution sorting by unit price
	 */
	@JsonProperty("DistributionSorting")
	public void setDistributionSortingInput(I_AD_Ref_ListInput DistributionSorting) {
		this.mDistributionSorting = DistributionSorting;
		if (DistributionSorting != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DistributionSorting.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDistributionSorting(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DistributionSorting.getUUID());
			}
		} else {
			this.setDistributionSorting(null);
		}
	}

	/**
	 * Get Distribution Sorting.
	 *
	 * @return Quantity distribution sorting by unit price
	 */
	@JsonProperty("DistributionSorting")
	public I_AD_Ref_ListInput DistributionSorting() {
		return mDistributionSorting;
	}

	/**
	 * Set Promotion.
	 *
	 * @param M_Promotion Promotion
	 */
	@JsonProperty("M_Promotion")
	public void setM_PromotionInput(ForeignEntityInput M_Promotion) {
		this.mM_Promotion = M_Promotion;
		if (get_ID() != 0) {
			return;
		}
		if (M_Promotion != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_Promotion foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_Promotion", "M_Promotion_UU=?", get_TrxName())
							.setParameters(M_Promotion.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_Promotion_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_Promotion with UUID " + M_Promotion.getUUID());
			}
		} else {
			this.setM_Promotion_ID(0);
		}
	}

	/**
	 * Get Promotion.
	 *
	 * @return Promotion
	 */
	@JsonProperty("M_Promotion")
	public ForeignEntityInput M_Promotion() {
		return mM_Promotion;
	}

	/**
	 * Set Promotion Distribution.
	 *
	 * @param M_PromotionDistribution Promotion Distribution
	 */
	@JsonProperty("M_PromotionDistribution")
	public void setM_PromotionDistributionInput(ForeignEntityInput M_PromotionDistribution) {
		this.mM_PromotionDistribution = M_PromotionDistribution;
		if (M_PromotionDistribution != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PromotionDistribution foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PromotionDistribution", "M_PromotionDistribution_UU=?", get_TrxName())
							.setParameters(M_PromotionDistribution.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_PromotionDistribution_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PromotionDistribution with UUID " + M_PromotionDistribution.getUUID());
			}
		} else {
			this.setM_PromotionDistribution_ID(0);
		}
	}

	/**
	 * Get Promotion Distribution.
	 *
	 * @return Promotion Distribution
	 */
	@JsonProperty("M_PromotionDistribution")
	public ForeignEntityInput M_PromotionDistribution() {
		return mM_PromotionDistribution;
	}
	/**
	 * Set Promotion Reward.
	 *
	 * @param M_PromotionReward_ID Promotion Reward
	 */

	public void setM_PromotionReward_ID(int M_PromotionReward_ID) {
		if (get_ID() == 0) {
			super.setM_PromotionReward_ID(M_PromotionReward_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_PromotionReward_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_PromotionReward_UU();
	}

	/**
	 * Set Target distribution.
	 *
	 * @param M_TargetDistribution Get product from target distribution to apply the promotion reward
	 */
	@JsonProperty("M_TargetDistribution")
	public void setM_TargetDistributionInput(ForeignEntityInput M_TargetDistribution) {
		this.mM_TargetDistribution = M_TargetDistribution;
		if (M_TargetDistribution != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PromotionDistribution foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PromotionDistribution", "M_PromotionDistribution_UU=?", get_TrxName())
							.setParameters(M_TargetDistribution.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setM_TargetDistribution_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PromotionDistribution with UUID " + M_TargetDistribution.getUUID());
			}
		} else {
			this.setM_TargetDistribution_ID(0);
		}
	}

	/**
	 * Get Target distribution.
	 *
	 * @return Get product from target distribution to apply the promotion reward
	 */
	@JsonProperty("M_TargetDistribution")
	public ForeignEntityInput M_TargetDistribution() {
		return mM_TargetDistribution;
	}

	/**
	 * Set Reward Type.
	 *
	 * @param RewardType Type of reward which consists of percentage discount, flat discount or absolute amount
	 */
	@JsonProperty("RewardType")
	public void setRewardTypeInput(I_AD_Ref_ListInput RewardType) {
		this.mRewardType = RewardType;
		if (RewardType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RewardType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRewardType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RewardType.getUUID());
			}
		} else {
			this.setRewardType(null);
		}
	}

	/**
	 * Get Reward Type.
	 *
	 * @return Type of reward which consists of percentage discount, flat discount or absolute amount
	 */
	@JsonProperty("RewardType")
	public I_AD_Ref_ListInput RewardType() {
		return mRewardType;
	}
}
