package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAssetType;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Asset_Type - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Asset_TypeInput extends MAssetType implements I_A_Asset_TypeInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mIsDepreciable;
	private I_AD_Ref_ListInput mIsInPosession;
	private I_AD_Ref_ListInput mIsOwned;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The A_Asset_Type_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_TypeInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setA_Asset_Type_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getA_Asset_Type_UU();
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * @return Organizational entity within tenant
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
		if (IsDepreciable != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsDepreciable.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsDepreciable(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsDepreciable.getUUID());
			}
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
		if (IsInPosession != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsInPosession.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsInPosession(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsInPosession.getUUID());
			}
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
		if (IsOwned != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsOwned.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsOwned(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + IsOwned.getUUID());
			}
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
