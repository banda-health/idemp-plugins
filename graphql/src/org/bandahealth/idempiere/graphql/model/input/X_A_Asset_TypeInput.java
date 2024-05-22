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
	private ForeignEntityInput mIsDepreciable;
	private ForeignEntityInput mIsInPosession;
	private ForeignEntityInput mIsOwned;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Asset_Type_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Asset_TypeInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Asset_Type_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
	 * Set Is Depreciable.
	 *
	 * @param IsDepreciable This asset CAN be depreciated
	 */
	@JsonProperty("IsDepreciable")
	public void setIsDepreciableInput(ForeignEntityInput IsDepreciable) {
		this.mIsDepreciable = IsDepreciable;
		if (IsDepreciable != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsDepreciable.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsDepreciable(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsDepreciable.getUU());
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
	public ForeignEntityInput IsDepreciable() {
		return mIsDepreciable;
	}

	/**
	 * Set In Possession.
	 *
	 * @param IsInPosession The asset is in the possession of the organization
	 */
	@JsonProperty("IsInPosession")
	public void setIsInPosessionInput(ForeignEntityInput IsInPosession) {
		this.mIsInPosession = IsInPosession;
		if (IsInPosession != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsInPosession.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsInPosession(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsInPosession.getUU());
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
	public ForeignEntityInput IsInPosession() {
		return mIsInPosession;
	}

	/**
	 * Set Owned.
	 *
	 * @param IsOwned The asset is owned by the organization
	 */
	@JsonProperty("IsOwned")
	public void setIsOwnedInput(ForeignEntityInput IsOwned) {
		this.mIsOwned = IsOwned;
		if (IsOwned != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(IsOwned.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setIsOwned(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + IsOwned.getUU());
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
	public ForeignEntityInput IsOwned() {
		return mIsOwned;
	}
}
