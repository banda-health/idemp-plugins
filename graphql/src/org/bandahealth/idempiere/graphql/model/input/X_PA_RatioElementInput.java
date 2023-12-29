package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MElementValue;
import org.compiere.model.MMeasureCalc;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_AD_Ref_ListInput RatioElementType_RL;
	 private I_AD_Ref_ListInput RatioOperand_RL;
	 private I_C_ElementValueInput Account;
	 private I_PA_MeasureCalcInput PA_MeasureCalc;
	 private I_PA_RatioInput PA_Ratio;
	 private I_PA_RatioInput PA_RatioUsed;

	/**
	 * Standard constructor
	 */
	public X_PA_RatioElementInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Account.
	 *
	 * @param Account Account used
	 */
	public void setAccount(I_C_ElementValueInput Account) {
		this.Account = Account;
		MElementValue foreignEntity;
		if (Account != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(Account.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAccount_ID(foreignEntity.get_ID());
		} else {
			this.setAccount_ID(0);
		}
	}

	/**
	 * Get Account.
	 *
	 * @return Account used
	 */
	public I_C_ElementValueInput getAccount() {
		return Account;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set Measure Calculation.
	 *
	 * @param PA_MeasureCalc Calculation method for measuring performance
	 */
	public void setPA_MeasureCalc(I_PA_MeasureCalcInput PA_MeasureCalc) {
		this.PA_MeasureCalc = PA_MeasureCalc;
		MMeasureCalc foreignEntity;
		if (PA_MeasureCalc != null &&
				(foreignEntity = new Query(getCtx(), MMeasureCalc.Table_Name, MMeasureCalc.COLUMNNAME_PA_MeasureCalc_UU + "=?", get_TrxName())
						.setParameters(PA_MeasureCalc.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_MeasureCalc_ID(foreignEntity.get_ID());
		} else {
			this.setPA_MeasureCalc_ID(0);
		}
	}

	/**
	 * Get Measure Calculation.
	 *
	 * @return Calculation method for measuring performance
	 */
	public I_PA_MeasureCalcInput getPA_MeasureCalc() {
		return PA_MeasureCalc;
	}

	/**
	 * Set Ratio.
	 *
	 * @param PA_Ratio Performance Ratio
	 */
	public void setPA_Ratio(I_PA_RatioInput PA_Ratio) {
		this.PA_Ratio = PA_Ratio;
		X_PA_Ratio foreignEntity;
		if (get_ID() == 0 &&PA_Ratio != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Ratio.Table_Name, X_PA_Ratio.COLUMNNAME_PA_Ratio_UU + "=?", get_TrxName())
						.setParameters(PA_Ratio.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_Ratio_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Ratio.
	 *
	 * @return Performance Ratio
	 */
	public I_PA_RatioInput getPA_Ratio() {
		return PA_Ratio;
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
	public void setPA_RatioUsed(I_PA_RatioInput PA_RatioUsed) {
		this.PA_RatioUsed = PA_RatioUsed;
		X_PA_Ratio foreignEntity;
		if (PA_RatioUsed != null &&
				(foreignEntity = new Query(getCtx(), X_PA_Ratio.Table_Name, X_PA_Ratio.COLUMNNAME_PA_Ratio_UU + "=?", get_TrxName())
						.setParameters(PA_RatioUsed.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPA_RatioUsed_ID(foreignEntity.get_ID());
		} else {
			this.setPA_RatioUsed_ID(0);
		}
	}

	/**
	 * Get Ratio Used.
	 *
	 * @return Performance Ratio Used
	 */
	public I_PA_RatioInput getPA_RatioUsed() {
		return PA_RatioUsed;
	}

	/**
	 * Set PostingType.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	public void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL) {
		this.PostingType_RL = PostingType_RL;
		MRefList foreignEntity;
		if (PostingType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType_RL.getID())
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
	public I_AD_Ref_ListInput getPostingType_RL() {
		return PostingType_RL;
	}

	/**
	 * Set Element Type.
	 *
	 * @param RatioElementType_RL Ratio Element Type
	 */
	public void setRatioElementType_RL(I_AD_Ref_ListInput RatioElementType_RL) {
		this.RatioElementType_RL = RatioElementType_RL;
		MRefList foreignEntity;
		if (RatioElementType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RatioElementType_RL.getID())
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
	public I_AD_Ref_ListInput getRatioElementType_RL() {
		return RatioElementType_RL;
	}

	/**
	 * Set Operand.
	 *
	 * @param RatioOperand_RL Ratio Operand
	 */
	public void setRatioOperand_RL(I_AD_Ref_ListInput RatioOperand_RL) {
		this.RatioOperand_RL = RatioOperand_RL;
		MRefList foreignEntity;
		if (RatioOperand_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(RatioOperand_RL.getID())
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
	public I_AD_Ref_ListInput getRatioOperand_RL() {
		return RatioOperand_RL;
	}
}
