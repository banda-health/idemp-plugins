package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostType;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchemaInput extends MAcctSchema implements I_C_AcctSchemaInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mCommitmentType;
	 private I_AD_Ref_ListInput mCostingLevel;
	 private I_AD_Ref_ListInput mCostingMethod;
	 private I_AD_Ref_ListInput mGAAP;
	 private I_AD_Ref_ListInput mTaxCorrectionType;
	 private I_C_CurrencyInput mC_Currency;
	 private I_C_PeriodInput mC_Period;
	 private I_M_CostTypeInput mM_CostType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_AcctSchemaInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_AcctSchema_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_AcctSchema_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(I_C_CurrencyInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			super.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public I_C_CurrencyInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(I_C_PeriodInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (get_ID() == 0 &&C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Period_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public I_C_PeriodInput C_Period() {
		return mC_Period;
	}

	/**
	 * Set Commitment Type.
	 *
	 * @param CommitmentType Create Commitment and/or Reservations for Budget Control
	 */
	@JsonProperty("CommitmentType")
	public void setCommitmentTypeInput(I_AD_Ref_ListInput CommitmentType) {
		this.mCommitmentType = CommitmentType;
		MRefList_BH foreignEntity;
		if (CommitmentType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CommitmentType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCommitmentType(foreignEntity.getValue());
		} else {
			this.setCommitmentType(null);
		}
	}

	/**
	 * Get Commitment Type.
	 *
	 * @return Create Commitment and/or Reservations for Budget Control
	 */
	@JsonProperty("CommitmentType")
	public I_AD_Ref_ListInput CommitmentType() {
		return mCommitmentType;
	}

	/**
	 * Set Costing Level.
	 *
	 * @param CostingLevel The lowest level to accumulate Costing Information
	 */
	@JsonProperty("CostingLevel")
	public void setCostingLevelInput(I_AD_Ref_ListInput CostingLevel) {
		this.mCostingLevel = CostingLevel;
		MRefList_BH foreignEntity;
		if (CostingLevel != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingLevel.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostingLevel(foreignEntity.getValue());
		} else {
			this.setCostingLevel(null);
		}
	}

	/**
	 * Get Costing Level.
	 *
	 * @return The lowest level to accumulate Costing Information
	 */
	@JsonProperty("CostingLevel")
	public I_AD_Ref_ListInput CostingLevel() {
		return mCostingLevel;
	}

	/**
	 * Set Costing Method.
	 *
	 * @param CostingMethod Indicates how Costs will be calculated
	 */
	@JsonProperty("CostingMethod")
	public void setCostingMethodInput(I_AD_Ref_ListInput CostingMethod) {
		this.mCostingMethod = CostingMethod;
		MRefList_BH foreignEntity;
		if (CostingMethod != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingMethod.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCostingMethod(foreignEntity.getValue());
		} else {
			this.setCostingMethod(null);
		}
	}

	/**
	 * Get Costing Method.
	 *
	 * @return Indicates how Costs will be calculated
	 */
	@JsonProperty("CostingMethod")
	public I_AD_Ref_ListInput CostingMethod() {
		return mCostingMethod;
	}

	/**
	 * Set GAAP.
	 *
	 * @param GAAP Generally Accepted Accounting Principles
	 */
	@JsonProperty("GAAP")
	public void setGAAPInput(I_AD_Ref_ListInput GAAP) {
		this.mGAAP = GAAP;
		MRefList_BH foreignEntity;
		if (GAAP != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(GAAP.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setGAAP(foreignEntity.getValue());
		} else {
			this.setGAAP(null);
		}
	}

	/**
	 * Get GAAP.
	 *
	 * @return Generally Accepted Accounting Principles
	 */
	@JsonProperty("GAAP")
	public I_AD_Ref_ListInput GAAP() {
		return mGAAP;
	}

	/**
	 * Set Cost Type.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public void setM_CostTypeInput(I_M_CostTypeInput M_CostType) {
		this.mM_CostType = M_CostType;
		MCostType foreignEntity;
		if (M_CostType != null &&
				(foreignEntity = new Query(getCtx(), MCostType.Table_Name, MCostType.COLUMNNAME_M_CostType_UU + "=?", get_TrxName())
						.setParameters(M_CostType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setM_CostType_ID(foreignEntity.get_ID());
		} else {
			super.setM_CostType_ID(0);
		}
	}

	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public I_M_CostTypeInput M_CostType() {
		return mM_CostType;
	}

	/**
	 * Set Tax Correction.
	 *
	 * @param TaxCorrectionType Type of Tax Correction
	 */
	@JsonProperty("TaxCorrectionType")
	public void setTaxCorrectionTypeInput(I_AD_Ref_ListInput TaxCorrectionType) {
		this.mTaxCorrectionType = TaxCorrectionType;
		MRefList_BH foreignEntity;
		if (TaxCorrectionType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TaxCorrectionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTaxCorrectionType(foreignEntity.getValue());
		} else {
			this.setTaxCorrectionType(null);
		}
	}

	/**
	 * Get Tax Correction.
	 *
	 * @return Type of Tax Correction
	 */
	@JsonProperty("TaxCorrectionType")
	public I_AD_Ref_ListInput TaxCorrectionType() {
		return mTaxCorrectionType;
	}
}
