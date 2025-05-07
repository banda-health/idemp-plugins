package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Depreciation_WorkfileResolver;
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
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_WorkfileInput extends MDepreciationWorkfile implements I_A_Depreciation_WorkfileInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_FundingMode;
	private ForeignEntityInput mA_Tip_Finantare;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Depreciation_Workfile_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_WorkfileInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		if (!is_new()) {
			return;
		}
		if (A_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset.getUU());
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
	@JsonProperty("A_Asset_Remaining")
	public void setA_Asset_RemainingFromJson(BigDecimal A_Asset_Remaining) {
		if (get_ID() == 0) {
			super.setA_Asset_Remaining(A_Asset_Remaining);
		}
	}
	/**
	 * Set Remaining Amt (fiscal).
	 *
	 * @param A_Asset_Remaining_F Remaining Amt (fiscal)
	 */
	@JsonProperty("A_Asset_Remaining_F")
	public void setA_Asset_Remaining_FFromJson(BigDecimal A_Asset_Remaining_F) {
		if (get_ID() == 0) {
			super.setA_Asset_Remaining_F(A_Asset_Remaining_F);
		}
	}
	/**
	 * Set A_Depreciation_Workfile_ID.
	 *
	 * @param A_Depreciation_Workfile_ID A_Depreciation_Workfile_ID
	 */
	@JsonProperty("A_Depreciation_Workfile_ID")
	public void setA_Depreciation_Workfile_IDFromJson(int A_Depreciation_Workfile_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Workfile_ID(A_Depreciation_Workfile_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Depreciation_Workfile_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Depreciation_Workfile_UU();
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
							.setParameters(A_FundingMode.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_FundingMode_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_FundingMode with UU " + A_FundingMode.getUU());
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
	 * Set Financing Type.
	 *
	 * @param A_Tip_Finantare Financing Type
	 */
	@JsonProperty("A_Tip_Finantare")
	public void setA_Tip_FinantareInput(ForeignEntityInput A_Tip_Finantare) {
		this.mA_Tip_Finantare = A_Tip_Finantare;
		if (A_Tip_Finantare != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Depreciation_WorkfileResolver.A_TIP_FINANTARE_UUIDS_BY_VALUE.containsValue(A_Tip_Finantare.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Tip_Finantare.getUU() +
						" is not in the list defined for the A_Tip_Finantare column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Tip_Finantare.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Tip_Finantare(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Tip_Finantare.getUU());
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
	public ForeignEntityInput A_Tip_Finantare() {
		return mA_Tip_Finantare;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UU " + AD_Org.getUU());
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
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (!is_new()) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
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
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Depreciation_WorkfileResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
				throw new AdempiereException("The reference list UU of " + PostingType.getUU() +
						" is not in the list defined for the PostingType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PostingType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPostingType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PostingType.getUU());
			}
		} else {
			this.setPostingType(null);
		}
	}

	/**
	 * Get Posting Type.
	 *
	 * @return The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public ForeignEntityInput PostingType() {
		return mPostingType;
	}
}
