package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_PA_Ratio;
import org.compiere.model.X_PA_RatioElement;
import org.compiere.util.Env;

/**
 * Generated Model for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_RatioElementInput extends X_PA_RatioElement implements I_PA_RatioElementInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mPostingType;
	 private I_AD_Ref_ListInput mRatioElementType;
	 private I_AD_Ref_ListInput mRatioOperand;
	 private I_C_ElementValueInput mAccount;
	 private I_PA_MeasureCalcInput mPA_MeasureCalc;
	 private I_PA_RatioInput mPA_Ratio;
	 private I_PA_RatioInput mPA_RatioUsed;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_PA_RatioElementInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	@JsonProperty("Account")
	public void setAccountInput(I_C_ElementValueInput Account) {
		this.mAccount = Account;
		MElementValue foreignEntity;
		if (Account != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAccount_ID(foreignEntity.get_ID());
		} else {
			super.setAccount_ID(0);
		}
	}

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	@JsonProperty("Account")
	public I_C_ElementValueInput Account() {
		return mAccount;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Measure Calculation.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	@JsonProperty("PA_MeasureCalc")
	public void setPA_MeasureCalcInput(I_PA_MeasureCalcInput PA_MeasureCalc) {
		this.mPA_MeasureCalc = PA_MeasureCalc;
		MMeasureCalc foreignEntity;
		if (PA_MeasureCalc != null &&
				(foreignEntity = new Query(getCtx(), MMeasureCalc.Table_Name, MMeasureCalc.COLUMNNAME_PA_MeasureCalc_UU + "=?", get_TrxName())
						.setParameters(PA_MeasureCalc.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_MeasureCalc_ID(foreignEntity.get_ID());
		} else {
			super.setPA_MeasureCalc_ID(0);
		}
	}

	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	@JsonProperty("PA_MeasureCalc")
	public I_PA_MeasureCalcInput PA_MeasureCalc() {
		return mPA_MeasureCalc;
	}

	/**
	 * Set Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	@JsonProperty("PA_Ratio")
	public void setPA_RatioInput(I_PA_RatioInput PA_Ratio) {
		this.mPA_Ratio = PA_Ratio;
		X_PA_Ratio foreignEntity;
		if (get_ID() == 0 &&PA_Ratio != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Ratio.Table_Name, X_PA_Ratio.COLUMNNAME_PA_Ratio_UU + "=?", get_TrxName())
						.setParameters(PA_Ratio.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_Ratio_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	@JsonProperty("PA_Ratio")
	public I_PA_RatioInput PA_Ratio() {
		return mPA_Ratio;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setPA_RatioElement_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getPA_RatioElement_UU();
	}

	/**
	 * Set Ratio Used.
	 *
	 * @param PA_RatioUsed Performance Ratio Used
	 */
	@JsonProperty("PA_RatioUsed")
	public void setPA_RatioUsedInput(I_PA_RatioInput PA_RatioUsed) {
		this.mPA_RatioUsed = PA_RatioUsed;
		X_PA_Ratio foreignEntity;
		if (PA_RatioUsed != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Ratio.Table_Name, X_PA_Ratio.COLUMNNAME_PA_Ratio_UU + "=?", get_TrxName())
						.setParameters(PA_RatioUsed.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setPA_RatioUsed_ID(foreignEntity.get_ID());
		} else {
			super.setPA_RatioUsed_ID(0);
		}
	}

	/**
	 * Get Ratio Used.
	 *
	 * @return Performance Ratio Used
	 */
	@JsonProperty("PA_RatioUsed")
	public I_PA_RatioInput PA_RatioUsed() {
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
		MRefList_BH foreignEntity;
		if (PostingType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (RatioElementType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RatioElementType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRatioElementType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (RatioOperand != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RatioOperand.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRatioOperand(foreignEntity.getValue());
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
