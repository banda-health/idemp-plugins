package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Forecast;
import org.compiere.util.Env;

/**
 * Generated Model for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_A_Depreciation_ForecastInput extends X_A_Depreciation_Forecast implements I_A_Depreciation_ForecastInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput PostingType_RL;
	 private I_A_AssetInput A_End_Asset;
	 private I_A_AssetInput A_Start_Asset;

	/**
	 * Standard constructor
	 */
	public X_A_Depreciation_ForecastInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}
	/**
	 * Set Depreciation Forecast.
	 *
	 * @param A_Depreciation_Forecast_ID Depreciation Forecast
	 */

	public void setA_Depreciation_Forecast_ID(int A_Depreciation_Forecast_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Forecast_ID(A_Depreciation_Forecast_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setA_Depreciation_Forecast_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getA_Depreciation_Forecast_UU();
	}

	/**
	 * Set To Asset.
	 *
	 * @param A_End_Asset To Asset
	 */
	public void setA_End_Asset(I_A_AssetInput A_End_Asset) {
		this.A_End_Asset = A_End_Asset;
		MAsset foreignEntity;
		if (A_End_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_End_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_End_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_End_Asset_ID(0);
		}
	}

	/**
	 * Get To Asset.
	 *
	 * @return To Asset
	 */
	public I_A_AssetInput getA_End_Asset() {
		return A_End_Asset;
	}
	/**
	 * Set To Asset.
	 *
	 * @param A_End_Asset_ID To Asset
	 */

	public void setA_End_Asset_ID(int A_End_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_End_Asset_ID(A_End_Asset_ID);
		}
	}

	/**
	 * Set From Asset.
	 *
	 * @param A_Start_Asset From Asset
	 */
	public void setA_Start_Asset(I_A_AssetInput A_Start_Asset) {
		this.A_Start_Asset = A_Start_Asset;
		MAsset foreignEntity;
		if (A_Start_Asset != null &&
				(foreignEntity = new Query(getCtx(), MAsset.Table_Name, MAsset.COLUMNNAME_A_Asset_UU + "=?", get_TrxName())
						.setParameters(A_Start_Asset.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setA_Start_Asset_ID(foreignEntity.get_ID());
		} else {
			this.setA_Start_Asset_ID(0);
		}
	}

	/**
	 * Get From Asset.
	 *
	 * @return From Asset
	 */
	public I_A_AssetInput getA_Start_Asset() {
		return A_Start_Asset;
	}
	/**
	 * Set From Asset.
	 *
	 * @param A_Start_Asset_ID From Asset
	 */

	public void setA_Start_Asset_ID(int A_Start_Asset_ID) {
		if (get_ID() == 0) {
			super.setA_Start_Asset_ID(A_Start_Asset_ID);
		}
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		} else {
			this.setAD_Org_ID(0);
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
