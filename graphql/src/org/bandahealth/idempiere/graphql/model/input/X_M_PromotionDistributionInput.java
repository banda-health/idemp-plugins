package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_M_Promotion;
import org.compiere.model.X_M_PromotionDistribution;
import org.compiere.model.X_M_PromotionLine;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for M_PromotionDistribution - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_PromotionDistributionInput extends X_M_PromotionDistribution implements I_M_PromotionDistributionInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mM_Promotion;
	private ForeignEntityInput mM_PromotionLine;
	private I_AD_Ref_ListInput mDistributionSorting;
	private I_AD_Ref_ListInput mDistributionType;
	private I_AD_Ref_ListInput mOperation;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_PromotionDistribution_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_M_PromotionDistributionInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
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
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
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
							.setParameters(DistributionSorting.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Distribution Type.
	 *
	 * @param DistributionType Type of quantity distribution calculation using comparison qty and order qty as operand
	 */
	@JsonProperty("DistributionType")
	public void setDistributionTypeInput(I_AD_Ref_ListInput DistributionType) {
		this.mDistributionType = DistributionType;
		if (DistributionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DistributionType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDistributionType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DistributionType.getUUID());
			}
		} else {
			this.setDistributionType(null);
		}
	}

	/**
	 * Get Distribution Type.
	 *
	 * @return Type of quantity distribution calculation using comparison qty and order qty as operand
	 */
	@JsonProperty("DistributionType")
	public I_AD_Ref_ListInput DistributionType() {
		return mDistributionType;
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
							.setParameters(M_Promotion.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @param M_PromotionDistribution_ID Promotion Distribution
	 */

	public void setM_PromotionDistribution_ID(int M_PromotionDistribution_ID) {
		if (get_ID() == 0) {
			super.setM_PromotionDistribution_ID(M_PromotionDistribution_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setM_PromotionDistribution_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getM_PromotionDistribution_UU();
	}

	/**
	 * Set Promotion Line.
	 *
	 * @param M_PromotionLine Promotion Line
	 */
	@JsonProperty("M_PromotionLine")
	public void setM_PromotionLineInput(ForeignEntityInput M_PromotionLine) {
		this.mM_PromotionLine = M_PromotionLine;
		if (M_PromotionLine != null) {
			// Since an entity was passed, make sure it's in the DB
			X_M_PromotionLine foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_PromotionLine", "M_PromotionLine_UU=?", get_TrxName())
							.setParameters(M_PromotionLine.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_PromotionLine_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_PromotionLine with UUID " + M_PromotionLine.getUUID());
			}
		} else {
			this.setM_PromotionLine_ID(0);
		}
	}

	/**
	 * Get Promotion Line.
	 *
	 * @return Promotion Line
	 */
	@JsonProperty("M_PromotionLine")
	public ForeignEntityInput M_PromotionLine() {
		return mM_PromotionLine;
	}

	/**
	 * Set Operation.
	 *
	 * @param Operation Compare Operation
	 */
	@JsonProperty("Operation")
	public void setOperationInput(I_AD_Ref_ListInput Operation) {
		this.mOperation = Operation;
		if (Operation != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(Operation.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setOperation(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + Operation.getUUID());
			}
		} else {
			this.setOperation(null);
		}
	}

	/**
	 * Get Operation.
	 *
	 * @return Compare Operation
	 */
	@JsonProperty("Operation")
	public I_AD_Ref_ListInput Operation() {
		return mOperation;
	}
}
