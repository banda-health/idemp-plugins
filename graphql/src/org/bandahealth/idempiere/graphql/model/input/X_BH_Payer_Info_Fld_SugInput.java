package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_BH_Payer_Info_Fld_SugInput extends MBHPayerInfoFldSug implements I_BH_Payer_Info_Fld_SugInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mBH_PayerInfoFieldDataType;
	private I_AD_Ref_ListInput mBH_SubType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_Payer_Info_Fld_Sug_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_BH_Payer_Info_Fld_SugInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UUID), null);
		setUUID(UUID);
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
	 * Set Payer Info Field Suggestion.
	 *
	 * @param BH_Payer_Info_Fld_Sug_ID Payer Info Field Suggestion
	 */

	public void setBH_Payer_Info_Fld_Sug_ID(int BH_Payer_Info_Fld_Sug_ID) {
		if (get_ID() == 0) {
			super.setBH_Payer_Info_Fld_Sug_ID(BH_Payer_Info_Fld_Sug_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setBH_Payer_Info_Fld_Sug_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getBH_Payer_Info_Fld_Sug_UU();
	}

	/**
	 * Set Payer Info Field Data Type.
	 *
	 * @param BH_PayerInfoFieldDataType Payer Info Field Data Type
	 */
	@JsonProperty("BH_PayerInfoFieldDataType")
	public void setBH_PayerInfoFieldDataTypeInput(I_AD_Ref_ListInput BH_PayerInfoFieldDataType) {
		this.mBH_PayerInfoFieldDataType = BH_PayerInfoFieldDataType;
		if (BH_PayerInfoFieldDataType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_PayerInfoFieldDataType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_PayerInfoFieldDataType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BH_PayerInfoFieldDataType.getUUID());
			}
		} else {
			this.setBH_PayerInfoFieldDataType(null);
		}
	}

	/**
	 * Get Payer Info Field Data Type.
	 *
	 * @return Payer Info Field Data Type
	 */
	@JsonProperty("BH_PayerInfoFieldDataType")
	public I_AD_Ref_ListInput BH_PayerInfoFieldDataType() {
		return mBH_PayerInfoFieldDataType;
	}

	/**
	 * Set Sub Type.
	 *
	 * @param BH_SubType Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public void setBH_SubTypeInput(I_AD_Ref_ListInput BH_SubType) {
		this.mBH_SubType = BH_SubType;
		if (BH_SubType != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(BH_SubType.getUUID()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setBH_SubType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + BH_SubType.getUUID());
			}
		} else {
			this.setBH_SubType(null);
		}
	}

	/**
	 * Get Sub Type.
	 *
	 * @return Meant to be a sub-type of the charge type
	 */
	@JsonProperty("BH_SubType")
	public I_AD_Ref_ListInput BH_SubType() {
		return mBH_SubType;
	}
}
