package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostType;
import org.compiere.model.MCurrency;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_AcctSchemaInput extends MAcctSchema implements I_C_AcctSchemaInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CommitmentType_RL;
	 private I_AD_Ref_ListInput CostingLevel_RL;
	 private I_AD_Ref_ListInput CostingMethod_RL;
	 private I_AD_Ref_ListInput GAAP_RL;
	 private I_AD_Ref_ListInput TaxCorrectionType_RL;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_PeriodInput C_Period;
	 private I_M_CostTypeInput M_CostType;

	/**
	 * Standard constructor
	 */
	public X_C_AcctSchemaInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
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
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	public void setC_Period(I_C_PeriodInput C_Period) {
		this.C_Period = C_Period;
		MPeriod foreignEntity;
		if (get_ID() == 0 &&C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Period_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	public I_C_PeriodInput getC_Period() {
		return C_Period;
	}

	/**
	 * Set Commitment Type.
	 *
	 * @param CommitmentType_RL Create Commitment and/or Reservations for Budget Control
	 */
	public void setCommitmentType_RL(I_AD_Ref_ListInput CommitmentType_RL) {
		this.CommitmentType_RL = CommitmentType_RL;
		MRefList foreignEntity;
		if (CommitmentType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CommitmentType_RL.getID())
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
	public I_AD_Ref_ListInput getCommitmentType_RL() {
		return CommitmentType_RL;
	}

	/**
	 * Set Costing Level.
	 *
	 * @param CostingLevel_RL The lowest level to accumulate Costing Information
	 */
	public void setCostingLevel_RL(I_AD_Ref_ListInput CostingLevel_RL) {
		this.CostingLevel_RL = CostingLevel_RL;
		MRefList foreignEntity;
		if (CostingLevel_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingLevel_RL.getID())
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
	public I_AD_Ref_ListInput getCostingLevel_RL() {
		return CostingLevel_RL;
	}

	/**
	 * Set Costing Method.
	 *
	 * @param CostingMethod_RL Indicates how Costs will be calculated
	 */
	public void setCostingMethod_RL(I_AD_Ref_ListInput CostingMethod_RL) {
		this.CostingMethod_RL = CostingMethod_RL;
		MRefList foreignEntity;
		if (CostingMethod_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CostingMethod_RL.getID())
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
	public I_AD_Ref_ListInput getCostingMethod_RL() {
		return CostingMethod_RL;
	}

	/**
	 * Set GAAP.
	 *
	 * @param GAAP_RL Generally Accepted Accounting Principles
	 */
	public void setGAAP_RL(I_AD_Ref_ListInput GAAP_RL) {
		this.GAAP_RL = GAAP_RL;
		MRefList foreignEntity;
		if (GAAP_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(GAAP_RL.getID())
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
	public I_AD_Ref_ListInput getGAAP_RL() {
		return GAAP_RL;
	}

	/**
	 * Set Cost Type.
	 *
	 * @param M_CostType Type of Cost (e.g. Current, Plan, Future)
	 */
	public void setM_CostType(I_M_CostTypeInput M_CostType) {
		this.M_CostType = M_CostType;
		MCostType foreignEntity;
		if (M_CostType != null &&
				(foreignEntity = new Query(getCtx(), MCostType.Table_Name, MCostType.COLUMNNAME_M_CostType_UU + "=?", get_TrxName())
						.setParameters(M_CostType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setM_CostType_ID(foreignEntity.get_ID());
		} else {
			this.setM_CostType_ID(0);
		}
	}

	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	public I_M_CostTypeInput getM_CostType() {
		return M_CostType;
	}

	/**
	 * Set Tax Correction.
	 *
	 * @param TaxCorrectionType_RL Type of Tax Correction
	 */
	public void setTaxCorrectionType_RL(I_AD_Ref_ListInput TaxCorrectionType_RL) {
		this.TaxCorrectionType_RL = TaxCorrectionType_RL;
		MRefList foreignEntity;
		if (TaxCorrectionType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TaxCorrectionType_RL.getID())
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
	public I_AD_Ref_ListInput getTaxCorrectionType_RL() {
		return TaxCorrectionType_RL;
	}
}
