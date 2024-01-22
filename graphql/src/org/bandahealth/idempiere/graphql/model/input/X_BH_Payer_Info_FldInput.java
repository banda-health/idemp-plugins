package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payer_Info_Fld - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Payer_Info_FldInput extends MBHPayerInfoFld implements I_BH_Payer_Info_FldInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payer;
	private I_AD_Ref_ListInput mBH_PayerInfoFieldDataType;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_Payer_Info_FldInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHPayerInfoFld(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Payer ID.
	 *
	 * @param BH_Payer Payer ID
	 */
	@JsonProperty("BH_Payer")
	public void setBH_PayerInput(ForeignEntityInput BH_Payer) {
		this.mBH_Payer = BH_Payer;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && BH_Payer != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(BH_Payer.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Payer_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payer ID.
	 *
	 * @return Payer ID
	 */
	@JsonProperty("BH_Payer")
	public ForeignEntityInput BH_Payer() {
		return mBH_Payer;
	}
	/**
	 * Set Payer Info Field.
	 *
	 * @param BH_Payer_Info_Fld_ID Payer Info Field
	 */

	public void setBH_Payer_Info_Fld_ID(int BH_Payer_Info_Fld_ID) {
		if (get_ID() == 0) {
			super.setBH_Payer_Info_Fld_ID(BH_Payer_Info_Fld_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Payer_Info_Fld_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Payer_Info_Fld_UU();
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
}
