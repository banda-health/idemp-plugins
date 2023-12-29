package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.MPeriod;
import org.compiere.model.MRefList;
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

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput A_Split_Type_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;
	 private I_A_AssetInput A_Asset_To;
	 private I_C_PeriodInput C_Period;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_SplitInput(String ID) {
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
		if (A_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Asset_ID(0);
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
	 * Set To Asset ID.
	 *
	 * @param A_Asset_To To Asset ID
	 */
	public void setA_Asset_To(I_A_AssetInput A_Asset_To) {
		this.A_Asset_To = A_Asset_To;
		MAsset foreignEntity;
		if (A_Asset_To != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Asset_To.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Asset_ID_To(foreignEntity.get_ID());
		} else {
			this.setA_Asset_ID_To(0);
		}
	}

	/**
	 * Get To Asset ID.
	 *
	 * @return To Asset ID
	 */
	public I_A_AssetInput getA_Asset_To() {
		return A_Asset_To;
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
	 * @param A_Split_Type_RL Split Type
	 */
	public void setA_Split_Type_RL(I_AD_Ref_ListInput A_Split_Type_RL) {
		this.A_Split_Type_RL = A_Split_Type_RL;
		MRefList foreignEntity;
		if (A_Split_Type_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(A_Split_Type_RL.getID())
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
	public I_AD_Ref_ListInput getA_Split_Type_RL() {
		return A_Split_Type_RL;
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
	 * Set Period.
	 *
	 * @param C_Period Period of the Calendar
	 */
	public void setC_Period(I_C_PeriodInput C_Period) {
		this.C_Period = C_Period;
		MPeriod foreignEntity;
		if (C_Period != null &&
				(foreignEntity = new Query(getCtx(), MPeriod.Table_Name, MPeriod.COLUMNNAME_C_Period_UU + "=?", get_TrxName())
						.setParameters(C_Period.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Period_ID(foreignEntity.get_ID());
		} else {
			this.setC_Period_ID(0);
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
	 * Set PostingType.
	 *
	 * @param PostingType_RL The type of posted amount for the transaction
	 */
	public void setPostingType_RL(I_AD_Ref_ListInput PostingType_RL) {
		this.PostingType_RL = PostingType_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&PostingType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(PostingType_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPostingType(foreignEntity.getValue());
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
