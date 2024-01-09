package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.Query;
import org.compiere.model.X_A_Asset_Split;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Split - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_SplitInput extends X_A_Asset_Split implements I_A_Asset_SplitInput {

	 private ForeignEntityInput mAD_Org;
	 private ForeignEntityInput mA_Asset;
	 private ForeignEntityInput mA_Asset_To;
	 private ForeignEntityInput mC_Period;
	 private I_AD_Ref_ListInput mA_Split_Type;
	 private I_AD_Ref_ListInput mPostingType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_SplitInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Asset.
	 *
	 * @param A_Asset Asset used internally or by customers
	 */
	@JsonProperty("A_Asset")
	public void setA_AssetInput(ForeignEntityInput A_Asset) {
		this.mA_Asset = A_Asset;
		MAsset foreignEntity;
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID(0);
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
		MAsset foreignEntity;
		if (A_Asset_To != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset_To.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setA_Asset_ID_To(foreignEntity.get_ID());
		} else {
			super.setA_Asset_ID_To(0);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Split_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Split_UU();
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
	 * Set Split Type.
	 *
	 * @param A_Split_Type Split Type
	 */
	@JsonProperty("A_Split_Type")
	public void setA_Split_TypeInput(I_AD_Ref_ListInput A_Split_Type) {
		this.mA_Split_Type = A_Split_Type;
		MRefList_BH foreignEntity;
		if (A_Split_Type != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Split_Type.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Split_Type(foreignEntity.getValue());
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
	public I_AD_Ref_ListInput A_Split_Type() {
		return mA_Split_Type;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
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
	public ForeignEntityInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	@JsonProperty("C_Period")
	public void setC_PeriodInput(ForeignEntityInput C_Period) {
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
	public ForeignEntityInput C_Period() {
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
		if (get_ID() == 0 &&PostingType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
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
