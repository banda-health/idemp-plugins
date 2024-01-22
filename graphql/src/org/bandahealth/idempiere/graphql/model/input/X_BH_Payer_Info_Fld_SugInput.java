package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldSug;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payer_Info_Fld_Sug - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Payer_Info_Fld_SugInput extends MBHPayerInfoFldSug implements I_BH_Payer_Info_Fld_SugInput {

	private ForeignEntityInput mAD_Org;
	private I_AD_Ref_ListInput mBH_PayerInfoFieldDataType;
	private I_AD_Ref_ListInput mBH_SubType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_Payer_Info_Fld_SugInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHPayerInfoFldSug(null, (ResultSet) null, null), null, Table_Name, ID),
				null);
		setID(ID);
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
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Payer_Info_Fld_Sug_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
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
		MRefList_BH foreignEntity;
		if (BH_PayerInfoFieldDataType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_PayerInfoFieldDataType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_PayerInfoFieldDataType(foreignEntity.getValue());
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
		MRefList_BH foreignEntity;
		if (BH_SubType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(BH_SubType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_SubType(foreignEntity.getValue());
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
