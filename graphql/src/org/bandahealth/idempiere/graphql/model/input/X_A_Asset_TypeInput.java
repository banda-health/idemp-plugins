package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetType;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

/**
 * Generated Model for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Asset_TypeInput extends MAssetType implements I_A_Asset_TypeInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput IsDepreciable_RL;
	 private I_AD_Ref_ListInput IsInPosession_RL;
	 private I_AD_Ref_ListInput IsOwned_RL;

	/**
	 * Standard constructor
	 */
	public X_A_Asset_TypeInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Asset_Type_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Asset_Type_UU();
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
	 * Set Is Depreciable.
	 *
	 * @param IsDepreciable_RL This asset CAN be depreciated
	 */
	public void setIsDepreciable_RL(I_AD_Ref_ListInput IsDepreciable_RL) {
		this.IsDepreciable_RL = IsDepreciable_RL;
		MRefList foreignEntity;
		if (IsDepreciable_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsDepreciable_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsDepreciable(foreignEntity.getValue());
		} else {
			this.setIsDepreciable(null);
		}
	}

	/**
	 * Get Is Depreciable.
	 *
	 * @return This asset CAN be depreciated
	 */
	public I_AD_Ref_ListInput getIsDepreciable_RL() {
		return IsDepreciable_RL;
	}

	/**
	 * Set In Possession.
	 *
	 * @param IsInPosession_RL The asset is in the possession of the organization
	 */
	public void setIsInPosession_RL(I_AD_Ref_ListInput IsInPosession_RL) {
		this.IsInPosession_RL = IsInPosession_RL;
		MRefList foreignEntity;
		if (IsInPosession_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsInPosession_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsInPosession(foreignEntity.getValue());
		} else {
			this.setIsInPosession(null);
		}
	}

	/**
	 * Get In Possession.
	 *
	 * @return The asset is in the possession of the organization
	 */
	public I_AD_Ref_ListInput getIsInPosession_RL() {
		return IsInPosession_RL;
	}

	/**
	 * Set Owned.
	 *
	 * @param IsOwned_RL The asset is owned by the organization
	 */
	public void setIsOwned_RL(I_AD_Ref_ListInput IsOwned_RL) {
		this.IsOwned_RL = IsOwned_RL;
		MRefList foreignEntity;
		if (IsOwned_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsOwned_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setIsOwned(foreignEntity.getValue());
		} else {
			this.setIsOwned(null);
		}
	}

	/**
	 * Get Owned.
	 *
	 * @return The asset is owned by the organization
	 */
	public I_AD_Ref_ListInput getIsOwned_RL() {
		return IsOwned_RL;
	}
}
