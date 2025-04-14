package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.resolver.model.X_A_Depreciation_ForecastResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAsset;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_A_Depreciation_Forecast;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_ForecastInput extends X_A_Depreciation_Forecast implements I_A_Depreciation_ForecastInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mA_End_Asset;
	private ForeignEntityInput mA_Start_Asset;
	private ForeignEntityInput mPostingType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The A_Depreciation_Forecast_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_A_Depreciation_ForecastInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
	}
	/**
	 * Set Depreciation Forecast.
	 *
	 * @param A_Depreciation_Forecast_ID Depreciation Forecast
	 */
	@JsonProperty("A_Depreciation_Forecast_ID")
	public void setA_Depreciation_Forecast_IDFromJson(int A_Depreciation_Forecast_ID) {
		if (get_ID() == 0) {
			super.setA_Depreciation_Forecast_ID(A_Depreciation_Forecast_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setA_Depreciation_Forecast_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getA_Depreciation_Forecast_UU();
	}

	/**
	 * Set To Asset.
	 *
	 * @param A_End_Asset To Asset
	 */
	@JsonProperty("A_End_Asset")
	public void setA_End_AssetInput(ForeignEntityInput A_End_Asset) {
		this.mA_End_Asset = A_End_Asset;
		if (A_End_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_End_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_End_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_End_Asset.getUU());
			}
		} else {
			this.setA_End_Asset_ID(0);
		}
	}

	/**
	 * Get To Asset.
	 *
	 * @return To Asset
	 */
	@JsonProperty("A_End_Asset")
	public ForeignEntityInput A_End_Asset() {
		return mA_End_Asset;
	}

	/**
	 * Set From Asset.
	 *
	 * @param A_Start_Asset From Asset
	 */
	@JsonProperty("A_Start_Asset")
	public void setA_Start_AssetInput(ForeignEntityInput A_Start_Asset) {
		this.mA_Start_Asset = A_Start_Asset;
		if (A_Start_Asset != null) {
			// Since an entity was passed, make sure it's in the DB
			MAsset foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "A_Asset", "A_Asset_UU=?", get_TrxName())
							.setParameters(A_Start_Asset.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setA_Start_Asset_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table A_Asset with UU " + A_Start_Asset.getUU());
			}
		} else {
			this.setA_Start_Asset_ID(0);
		}
	}

	/**
	 * Get From Asset.
	 *
	 * @return From Asset
	 */
	@JsonProperty("A_Start_Asset")
	public ForeignEntityInput A_Start_Asset() {
		return mA_Start_Asset;
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within tenant
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(ForeignEntityInput AD_Org) {
		this.mAD_Org = AD_Org;
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
	 * Set Posting Type.
	 *
	 * @param PostingType The type of posted amount for the transaction
	 */
	@JsonProperty("PostingType")
	public void setPostingTypeInput(ForeignEntityInput PostingType) {
		this.mPostingType = PostingType;
		if (PostingType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_A_Depreciation_ForecastResolver.POSTINGTYPE_UUIDS_BY_VALUE.containsValue(PostingType.getUU())) {
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
