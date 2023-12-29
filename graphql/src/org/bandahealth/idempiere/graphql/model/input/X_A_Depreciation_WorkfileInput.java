package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MAsset;
import org.compiere.model.MDepreciationWorkfile;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_FundingMode;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Workfile - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_WorkfileInput extends MDepreciationWorkfile implements I_A_Depreciation_WorkfileInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Tip_Finantare_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;
	 private I_A_FundingModeInput A_FundingMode;
	 private I_C_AcctSchemaInput C_AcctSchema;

	/**
	 * Standard constructor
	 */
	public X_A_Depreciation_WorkfileInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	public void setA_Asset(I_A_AssetInput A_Asset) {
		this.A_Asset = A_Asset;
		MAsset foreignEntity;
		if (get_ID() == 0 &&A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Asset.
	 *
	 * @return Asset used internally or by customers
	 */
	public I_A_AssetInput getA_Asset() {
		return A_Asset;
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Workfile_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Workfile_UU();
	}

	/**
	 * Set Asset Funding Mode.
	 *
	 * @param A_FundingMode Asset Funding Mode
	 */
	public void setA_FundingMode(I_A_FundingModeInput A_FundingMode) {
		this.A_FundingMode = A_FundingMode;
		X_A_FundingMode foreignEntity;
		if (A_FundingMode != null &&
				(foreignEntity = new Query(getCtx(), X_A_FundingMode.Table_Name, X_A_FundingMode.COLUMNNAME_A_FundingMode_UU + "=?", get_TrxName())
						.setParameters(A_FundingMode.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_FundingMode_ID(foreignEntity.get_ID());
		} else {
			this.setA_FundingMode_ID(0);
		}
	}

	/**
	 * Get Asset Funding Mode.
	 *
	 * @return Asset Funding Mode
	 */
	public I_A_FundingModeInput getA_FundingMode() {
		return A_FundingMode;
	}

	/**
	 * Set Financing Type.
	 *
	 * @param A_Tip_Finantare_RL Financing Type
	 */
	public void setA_Tip_Finantare_RL(I_AD_Ref_ListInput A_Tip_Finantare_RL) {
		this.A_Tip_Finantare_RL = A_Tip_Finantare_RL;
		MRefList foreignEntity;
		if (A_Tip_Finantare_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Tip_Finantare_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Tip_Finantare(foreignEntity.getValue());
		} else {
			this.setA_Tip_Finantare(null);
		}
	}

	/**
	 * Get Financing Type.
	 *
	 * @return Financing Type
	 */
	public I_AD_Ref_ListInput getA_Tip_Finantare_RL() {
		return A_Tip_Finantare_RL;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	public void setC_AcctSchema(I_C_AcctSchemaInput C_AcctSchema) {
		this.C_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 &&C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), MAcctSchema.Table_Name, MAcctSchema.COLUMNNAME_C_AcctSchema_UU + "=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	public I_C_AcctSchemaInput getC_AcctSchema() {
		return C_AcctSchema;
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
}
