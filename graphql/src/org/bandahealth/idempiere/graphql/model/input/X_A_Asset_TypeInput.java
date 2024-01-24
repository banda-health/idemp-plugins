package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_A_Asset_TypeInput extends MAssetType implements I_A_Asset_TypeInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mIsDepreciable;
	private I_AD_Ref_ListInput mIsInPosession;
	private I_AD_Ref_ListInput mIsOwned;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_A_Asset_TypeInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MAssetType(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
	}
	/**
	 * Set Asset Type.
	 *
	 * @param A_Asset_Type_ID Asset Type
	 */

	public void setA_Asset_Type_ID(int A_Asset_Type_ID) {
		if (get_ID() == 0) {
			super.setA_Asset_Type_ID(A_Asset_Type_ID);
		}
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
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 && AD_Org != null &&
				(foreignEntity = new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
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
	 * Set Is Depreciable.
	 *
	 * @param IsDepreciable This asset CAN be depreciated
	 */
	@JsonProperty("IsDepreciable")
	public void setIsDepreciableInput(I_AD_Ref_ListInput IsDepreciable) {
		this.mIsDepreciable = IsDepreciable;
		MRefList_BH foreignEntity;
		if (IsDepreciable != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsDepreciable.getID())
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
	@JsonProperty("IsDepreciable")
	public I_AD_Ref_ListInput IsDepreciable() {
		return mIsDepreciable;
	}

	/**
	 * Set In Possession.
	 *
	 * @param IsInPosession The asset is in the possession of the organization
	 */
	@JsonProperty("IsInPosession")
	public void setIsInPosessionInput(I_AD_Ref_ListInput IsInPosession) {
		this.mIsInPosession = IsInPosession;
		MRefList_BH foreignEntity;
		if (IsInPosession != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsInPosession.getID())
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
	@JsonProperty("IsInPosession")
	public I_AD_Ref_ListInput IsInPosession() {
		return mIsInPosession;
	}

	/**
	 * Set Owned.
	 *
	 * @param IsOwned The asset is owned by the organization
	 */
	@JsonProperty("IsOwned")
	public void setIsOwnedInput(I_AD_Ref_ListInput IsOwned) {
		this.mIsOwned = IsOwned;
		MRefList_BH foreignEntity;
		if (IsOwned != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(IsOwned.getID())
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
	@JsonProperty("IsOwned")
	public I_AD_Ref_ListInput IsOwned() {
		return mIsOwned;
	}
}
