package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MDepreciationWorkfile;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_FundingMode;
import org.compiere.util.Env;

import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 * Generated Model for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_WorkfileInput extends MDepreciationWorkfile implements I_A_Depreciation_WorkfileInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_FundingMode;
	private ForeignEntityInput mC_AcctSchema;
	private I_AD_Ref_ListInput mA_Tip_Finantare;
	private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Depreciation_Workfile_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_WorkfileInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (get_ID() != 0) {
			return;
		}
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UUID " + A_Asset.getUUID());
			}
		} else {
			this.setA_Asset_ID(0);
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public ForeignEntityInput A_Asset() {
		return mA_Asset;
	}
	/**
	 * Set Remaining Amt.
	 *
	 * @param A_Asset_Remaining Remaining Amt
	 */

	public void setA_Asset_Remaining(BigDecimal A_Asset_Remaining) {
		if (get_ID() == 0) {
			super.setA_Asset_Remaining(A_Asset_Remaining);
		}
	}
	/**
	 * Set Remaining Amt (fiscal).
	 *
	 * @param A_Asset_Remaining_F Remaining Amt (fiscal)
	 */

	public void setA_Asset_Remaining_F(BigDecimal A_Asset_Remaining_F) {
		if (get_ID() == 0) {
			super.setA_Asset_Remaining_F(A_Asset_Remaining_F);
		}
	}
	/**
	 * Set A_Depreciation_Workfile_ID.
	 *
	 * @param A_Depreciation_Workfile_ID A_Depreciation_Workfile_ID
	 */

	public void setA_Depreciation_Workfile_ID(int A_Depreciation_Workfile_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Workfile_ID(A_Depreciation_Workfile_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Depreciation_Workfile_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Depreciation_Workfile_UU();
	}
	/**
	 * Set SL Expense/Period.
	 *
	 * @param A_Expense_SL SL Expense/Period
	 */

	public void setA_Expense_SL(BigDecimal A_Expense_SL) {
		if (get_ID() == 0) {
			super.setA_Expense_SL(A_Expense_SL);
		}
	}
	/**
	 * Set SL Expense/Period (fiscal).
	 *
	 * @param A_Expense_SL_F SL Expense/Period (fiscal)
	 */

	public void setA_Expense_SL_F(BigDecimal A_Expense_SL_F) {
		if (get_ID() == 0) {
			super.setA_Expense_SL_F(A_Expense_SL_F);
		}
	}

	/**
	 * Set Asset Funding Mode.
	 *
	 * @param A_FundingMode Asset Funding Mode
	 */
	@JsonProperty("A_FundingMode")
	public void setA_FundingModeInput(ForeignEntityInput A_FundingMode) {
		this.mA_FundingMode = A_FundingMode;
		if (A_FundingMode != null) {
			// Since an entity was passed, make sure it's in the DB
			X_A_FundingMode foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_FundingMode", "A_FundingMode_UU=?", get_TrxName())
							.setParameters(A_FundingMode.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_FundingMode_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_FundingMode with UUID " + A_FundingMode.getUUID());
			}
		} else {
			this.setA_FundingMode_ID(0);
		}
	}

	/**
	 * Get Asset Funding Mode.
	 *
	 * @return Asset Funding Mode
	 */
	@JsonProperty("A_FundingMode")
	public ForeignEntityInput A_FundingMode() {
		return mA_FundingMode;
	}
	/**
	 * Set Life periods (max).
	 *
	 * @param A_Life_Period_Max Life periods (max)
	 */

	public void setA_Life_Period_Max(int A_Life_Period_Max) {
		if (get_ID() == 0) {
			super.setA_Life_Period_Max(A_Life_Period_Max);
		}
	}
	/**
	 * Set Life periods (min).
	 *
	 * @param A_Life_Period_Min Life periods (min)
	 */

	public void setA_Life_Period_Min(int A_Life_Period_Min) {
		if (get_ID() == 0) {
			super.setA_Life_Period_Min(A_Life_Period_Min);
		}
	}

	/**
	 * Set Financing Type.
	 *
	 * @param A_Tip_Finantare Financing Type
	 */
	@JsonProperty("A_Tip_Finantare")
	public void setA_Tip_FinantareInput(I_AD_Ref_ListInput A_Tip_Finantare) {
		this.mA_Tip_Finantare = A_Tip_Finantare;
		if (A_Tip_Finantare != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Tip_Finantare.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setA_Tip_Finantare(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + A_Tip_Finantare.getUUID());
			}
		} else {
			this.setA_Tip_Finantare(null);
		}
	}

	/**
	 * Get Financing Type.
	 *
	 * @return Financing Type
	 */
	@JsonProperty("A_Tip_Finantare")
	public I_AD_Ref_ListInput A_Tip_Finantare() {
		return mA_Tip_Finantare;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UUID " + C_AcctSchema.getUUID());
			}
		} else {
			this.setC_AcctSchema_ID(0);
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
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
}
