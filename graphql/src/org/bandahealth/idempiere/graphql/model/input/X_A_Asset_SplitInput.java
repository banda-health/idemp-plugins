package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Asset_SplitResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Split;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_SplitInput extends X_A_Asset_Split implements I_A_Asset_SplitInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_Asset;
	private ForeignEntityInput mA_Asset_To;
	private ForeignEntityInput mA_Split_Type;
	private ForeignEntityInput mC_Period;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Asset_Split_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_SplitInput(@JsonProperty("UU") String UU) {
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
	 * Set To Asset ID.
	 *
	 * @param A_Asset_To To Asset ID
	 */
	@JsonProperty("A_Asset_To")
	public void setA_Asset_ToInput(ForeignEntityInput A_Asset_To) {
		this.mA_Asset_To = A_Asset_To;
		if (A_Asset_To != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Asset_To.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Asset_ID_To(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Asset_To.getUU());
			}
		} else {
			this.setA_Asset_ID_To(0);
		}
	}

	/**
	 * Get To Asset ID.
	 *
	 * @return To Asset ID
	 */
	@JsonProperty("A_Asset_To")
	public ForeignEntityInput A_Asset_To() {
		return mA_Asset_To;
	}
	/**
	 * Set Asset Split.
	 *
	 * @param A_Asset_Split_ID Asset Split
	 */
	@JsonProperty("A_Asset_Split_ID")
	public void setA_Asset_Split_IDFromJson(int A_Asset_Split_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Split_ID(A_Asset_Split_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Split_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Asset_Split_UU();
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
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (!is_new()) {
			return;
		}
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
	 * Set Split Type.
	 *
	 * @param A_Split_Type Split Type
	 */
	@JsonProperty("A_Split_Type")
	public void setA_Split_TypeInput(ForeignEntityInput A_Split_Type) {
		this.mA_Split_Type = A_Split_Type;
		if (A_Split_Type != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_SplitResolver.A_SPLIT_TYPE_UUIDS_BY_VALUE.containsValue(A_Split_Type.getUU())) {
				throw new AdempiereException("The reference list UU of " + A_Split_Type.getUU() +
						" is not in the list defined for the A_Split_Type column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(A_Split_Type.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setA_Split_Type(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + A_Split_Type.getUU());
			}
		} else {
			this.setA_Split_Type(null);
		}
	}

	/**
	 * Get Split Type.
	 *
	 * @return Split Type
	 */
	@JsonProperty("A_Split_Type")
	public ForeignEntityInput A_Split_Type() {
		return mA_Split_Type;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
		this.mC_Period = C_Period;
		if (C_Period != null) {
			// Since an entity was passed, make sure it's in the DB
			MPeriod foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Period", "C_Period_UU=?", get_TrxName())
							.setParameters(C_Period.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Period_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Period with UU " + C_Period.getUU());
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
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (!is_new()) {
			return;
		}
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Asset_SplitResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
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
