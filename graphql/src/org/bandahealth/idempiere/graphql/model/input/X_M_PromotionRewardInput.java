package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionDistribution;
import org.compiere.model.X_M_PromotionReward;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionReward - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
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
	 * Standard constructor
	 */
	@JsonCreator
	public X_M_PromotionRewardInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_M_PromotionReward(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
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
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			super.setC_Charge_ID(0);
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
		MRefList_BH foreignEntity;
		if (DistributionSorting != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DistributionSorting.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDistributionSorting(foreignEntity.getValue());
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
		X_M_Promotion foreignEntity;
		if (get_ID() == 0 && M_Promotion != null &&
				(foreignEntity = new Query(getCtx(), "M_Promotion", "M_Promotion_UU=?", get_TrxName())
						.setParameters(M_Promotion.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_Promotion_ID(foreignEntity.get_ID());
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
		X_M_PromotionDistribution foreignEntity;
		if (M_PromotionDistribution != null &&
				(foreignEntity = new Query(getCtx(), "M_PromotionDistribution", "M_PromotionDistribution_UU=?", get_TrxName())
						.setParameters(M_PromotionDistribution.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_PromotionDistribution_ID(foreignEntity.get_ID());
		} else {
			super.setM_PromotionDistribution_ID(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setM_PromotionReward_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		X_M_PromotionDistribution foreignEntity;
		if (M_TargetDistribution != null &&
				(foreignEntity = new Query(getCtx(), "M_PromotionDistribution", "M_PromotionDistribution_UU=?", get_TrxName())
						.setParameters(M_TargetDistribution.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_TargetDistribution_ID(foreignEntity.get_ID());
		} else {
			super.setM_TargetDistribution_ID(0);
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
		MRefList_BH foreignEntity;
		if (RewardType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RewardType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRewardType(foreignEntity.getValue());
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
