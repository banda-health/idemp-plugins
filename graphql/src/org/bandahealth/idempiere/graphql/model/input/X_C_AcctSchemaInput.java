package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MCostType;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_AcctSchema - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AcctSchemaInput extends MAcctSchema implements I_C_AcctSchemaInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mM_CostType;
	private I_AD_Ref_ListInput mCommitmentType;
	private I_AD_Ref_ListInput mCostingLevel;
	private I_AD_Ref_ListInput mCostingMethod;
	private I_AD_Ref_ListInput mGAAP;
	private I_AD_Ref_ListInput mTaxCorrectionType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AcctSchema_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_AcctSchemaInput(@JsonProperty("UUID") String UUID) {
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema_ID Rules for accounting
	 */

	public void setC_AcctSchema_ID(int C_AcctSchema_ID) {
		if (get_ID() == 0) {
			super.setC_AcctSchema_ID(C_AcctSchema_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_AcctSchema_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_AcctSchema_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		if (get_ID() != 0) {
			return;
		}
		if (C_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MPeriod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UUID " + C_Period.getUUID());
			}
		} else {
			this.setC_Period_ID(0);
		}
	}

	/**
	 * Get Period.
	 *
	 * @return Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public ForeignEntityInput C_Period() {
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
		if (CommitmentType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CommitmentType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCommitmentType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CommitmentType.getUUID());
			}
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
		if (CostingLevel != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CostingLevel.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCostingLevel(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CostingLevel.getUUID());
			}
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
		if (CostingMethod != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CostingMethod.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCostingMethod(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CostingMethod.getUUID());
			}
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
		if (GAAP != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(GAAP.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setGAAP(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + GAAP.getUUID());
			}
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
	public void setM_CostTypeInput(ForeignEntityInput M_CostType) {
		this.mM_CostType = M_CostType;
		if (M_CostType != null) {
			// Since an entity was passed, make sure it's in the DB
			MCostType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "M_CostType", "M_CostType_UU=?", get_TrxName())
							.setParameters(M_CostType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setM_CostType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table M_CostType with UUID " + M_CostType.getUUID());
			}
		} else {
			this.setM_CostType_ID(0);
		}
	}

	/**
	 * Get Cost Type.
	 *
	 * @return Type of Cost (e.g. Current, Plan, Future)
	 */
	@JsonProperty("M_CostType")
	public ForeignEntityInput M_CostType() {
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
		if (TaxCorrectionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TaxCorrectionType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTaxCorrectionType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TaxCorrectionType.getUUID());
			}
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
