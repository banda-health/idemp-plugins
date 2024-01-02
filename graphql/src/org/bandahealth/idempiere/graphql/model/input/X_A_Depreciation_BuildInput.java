package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MDepreciationBuild;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Build - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_BuildInput extends MDepreciationBuild implements I_A_Depreciation_BuildInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mPostingType;
	 private I_A_AssetInput mA_End_Asset;
	 private I_A_AssetInput mA_Start_Asset;
	 private I_C_PeriodInput mC_Period;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Depreciation_BuildInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Build_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Build_UU();
	}

	/**
	 * Set To Asset.
	 *
	 * @param A_End_Asset To Asset
	 */
	@JsonProperty("A_End_Asset")
	public void setA_End_AssetInput(I_A_AssetInput A_End_Asset) {
		this.mA_End_Asset = A_End_Asset;
		MAsset foreignEntity;
		if (A_End_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_End_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_End_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_End_Asset_ID(0);
		}
	}

	/**
	 * Get To Asset.
	 *
	 * @return To Asset
	 */
	@JsonProperty("A_End_Asset")
	public I_A_AssetInput A_End_Asset() {
		return mA_End_Asset;
	}

	/**
	 * Set From Asset.
	 *
	 * @param A_Start_Asset From Asset
	 */
	@JsonProperty("A_Start_Asset")
	public void setA_Start_AssetInput(I_A_AssetInput A_Start_Asset) {
		this.mA_Start_Asset = A_Start_Asset;
		MAsset foreignEntity;
		if (A_Start_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Start_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Start_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Start_Asset_ID(0);
		}
	}

	/**
	 * Get From Asset.
	 *
	 * @return From Asset
	 */
	@JsonProperty("A_Start_Asset")
	public I_A_AssetInput A_Start_Asset() {
		return mA_Start_Asset;
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
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			super.setAD_Org_ID(0);
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(I_C_PeriodInput C_Period) {
		this.mC_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Period_ID(foreignEntity.get_ID());
		} else {
			super.setC_Period_ID(0);
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
}
