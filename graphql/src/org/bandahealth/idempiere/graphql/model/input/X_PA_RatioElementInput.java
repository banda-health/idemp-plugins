package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Ratio;
import org.compiere.model.X_PA_RatioElement;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioElementInput extends X_PA_RatioElement implements I_PA_RatioElementInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mAccount;
	private ForeignEntityInput mPA_MeasureCalc;
	private ForeignEntityInput mPA_Ratio;
	private ForeignEntityInput mPA_RatioUsed;
	private I_AD_Ref_ListInput mPostingType;
	private I_AD_Ref_ListInput mRatioElementType;
	private I_AD_Ref_ListInput mRatioOperand;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The PA_RatioElement_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_PA_RatioElementInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	@JsonProperty("Account")
	public void setAccountInput(ForeignEntityInput Account) {
		this.mAccount = Account;
		if (Account != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(Account.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + Account.getUUID());
			}
		} else {
			this.setAccount_ID(0);
		}
	}

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	@JsonProperty("Account")
	public ForeignEntityInput Account() {
		return mAccount;
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
	 * Set Measure Calculation.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	@JsonProperty("PA_MeasureCalc")
	public void setPA_MeasureCalcInput(ForeignEntityInput PA_MeasureCalc) {
		this.mPA_MeasureCalc = PA_MeasureCalc;
		if (PA_MeasureCalc != null) {
			// Since an entity was passed, make sure it's in the DB
			MMeasureCalc foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_MeasureCalc", "PA_MeasureCalc_UU=?", get_TrxName())
							.setParameters(PA_MeasureCalc.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_MeasureCalc_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_MeasureCalc with UUID " + PA_MeasureCalc.getUUID());
			}
		} else {
			this.setPA_MeasureCalc_ID(0);
		}
	}

	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	@JsonProperty("PA_MeasureCalc")
	public ForeignEntityInput PA_MeasureCalc() {
		return mPA_MeasureCalc;
	}

	/**
	 * Set Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	@JsonProperty("PA_Ratio")
	public void setPA_RatioInput(ForeignEntityInput PA_Ratio) {
		this.mPA_Ratio = PA_Ratio;
		if (get_ID() != 0) {
			return;
		}
		if (PA_Ratio != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PA_Ratio foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Ratio", "PA_Ratio_UU=?", get_TrxName())
							.setParameters(PA_Ratio.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_Ratio_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Ratio with UUID " + PA_Ratio.getUUID());
			}
		} else {
			this.setPA_Ratio_ID(0);
		}
	}

	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	@JsonProperty("PA_Ratio")
	public ForeignEntityInput PA_Ratio() {
		return mPA_Ratio;
	}
	/**
	 * Set Ratio Element.
	 *
	 * @param PA_RatioElement_ID Performance Ratio Element
	 */

	public void setPA_RatioElement_ID(int PA_RatioElement_ID) {
		if (get_ID() == 0) {
			super.setPA_RatioElement_ID(PA_RatioElement_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setPA_RatioElement_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getPA_RatioElement_UU();
	}

	/**
	 * Set Ratio Used.
	 *
	 * @param PA_RatioUsed Performance Ratio Used
	 */
	@JsonProperty("PA_RatioUsed")
	public void setPA_RatioUsedInput(ForeignEntityInput PA_RatioUsed) {
		this.mPA_RatioUsed = PA_RatioUsed;
		if (PA_RatioUsed != null) {
			// Since an entity was passed, make sure it's in the DB
			X_PA_Ratio foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "PA_Ratio", "PA_Ratio_UU=?", get_TrxName())
							.setParameters(PA_RatioUsed.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPA_RatioUsed_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table PA_Ratio with UUID " + PA_RatioUsed.getUUID());
			}
		} else {
			this.setPA_RatioUsed_ID(0);
		}
	}

	/**
	 * Get Ratio Used.
	 *
	 * @return Performance Ratio Used
	 */
	@JsonProperty("PA_RatioUsed")
	public ForeignEntityInput PA_RatioUsed() {
		return mPA_RatioUsed;
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(I_AD_Ref_ListInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PostingType.getUUID());
			}
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get PostingType.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public I_AD_Ref_ListInput PostingType() {
		return mPostingType;
	}

	/**
	 * Set Element Type.
	 *
	 * @param RatioElementType Ratio Element Type
	 */
	@JsonProperty("RatioElementType")
	public void setRatioElementTypeInput(I_AD_Ref_ListInput RatioElementType) {
		this.mRatioElementType = RatioElementType;
		if (RatioElementType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RatioElementType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRatioElementType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RatioElementType.getUUID());
			}
		} else {
			this.setRatioElementType(null);
		}
	}

	/**
	 * Get Element Type.
	 *
	 * @return Ratio Element Type
	 */
	@JsonProperty("RatioElementType")
	public I_AD_Ref_ListInput RatioElementType() {
		return mRatioElementType;
	}

	/**
	 * Set Operand.
	 *
	 * @param RatioOperand Ratio Operand
	 */
	@JsonProperty("RatioOperand")
	public void setRatioOperandInput(I_AD_Ref_ListInput RatioOperand) {
		this.mRatioOperand = RatioOperand;
		if (RatioOperand != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(RatioOperand.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRatioOperand(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + RatioOperand.getUUID());
			}
		} else {
			this.setRatioOperand(null);
		}
	}

	/**
	 * Get Operand.
	 *
	 * @return Ratio Operand
	 */
	@JsonProperty("RatioOperand")
	public I_AD_Ref_ListInput RatioOperand() {
		return mRatioOperand;
	}
}
