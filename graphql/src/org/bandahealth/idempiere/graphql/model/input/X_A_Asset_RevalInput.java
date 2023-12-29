package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MAssetReval;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Reval - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_RevalInput extends MAssetReval implements I_A_Asset_RevalInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput Posted_RL;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_Asset;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_RevalInput(String ID) {
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Reval_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Reval_UU();
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
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
	}

	/**
	 * Set Posted.
	 *
	 * @param Posted_RL Posting status
	 */
	public void setPosted_RL(I_AD_Ref_ListInput Posted_RL) {
		this.Posted_RL = Posted_RL;
		MRefList foreignEntity;
		if (Posted_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(Posted_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setPosted(foreignEntity.getValue());
		} else {
			this.setPosted(null);
		}
	}

	/**
	 * Get Posted.
	 *
	 * @return Posting status
	 */
	public I_AD_Ref_ListInput getPosted_RL() {
		return Posted_RL;
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
