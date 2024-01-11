package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHBPGeneralPayerInfo;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_BP_General_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_BH_BP_General_Payer_InfoInput extends MBHBPGeneralPayerInfo implements I_BH_BP_General_Payer_InfoInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_BP_Payer_Info;
	private ForeignEntityInput mBH_Payer_Info_Fld;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_BP_General_Payer_InfoInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHBPGeneralPayerInfo(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Business Partner General Payer Info.
	 *
	 * @param BH_BP_General_Payer_Info_ID Business Partner General Payer Info
	 */

	public void setBH_BP_General_Payer_Info_ID(int BH_BP_General_Payer_Info_ID) {
		if (get_ID() == 0) {
			super.setBH_BP_General_Payer_Info_ID(BH_BP_General_Payer_Info_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_BP_General_Payer_Info_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_BP_General_Payer_Info_UU();
	}

	/**
	 * Set Business Partner Payer Information.
	 *
	 * @param BH_BP_Payer_Info Business Partner Payer Information
	 */
	@JsonProperty("BH_BP_Payer_Info")
	public void setBH_BP_Payer_InfoInput(ForeignEntityInput BH_BP_Payer_Info) {
		this.mBH_BP_Payer_Info = BH_BP_Payer_Info;
		MBHBPPayerInfo foreignEntity;
		if (get_ID() == 0 && BH_BP_Payer_Info != null &&
				(foreignEntity = new Query(getCtx(), "BH_BP_Payer_Info", "BH_BP_Payer_Info_UU=?", get_TrxName())
						.setParameters(BH_BP_Payer_Info.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_BP_Payer_Info_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner Payer Information.
	 *
	 * @return Business Partner Payer Information
	 */
	@JsonProperty("BH_BP_Payer_Info")
	public ForeignEntityInput BH_BP_Payer_Info() {
		return mBH_BP_Payer_Info;
	}

	/**
	 * Set Payer Info Field.
	 *
	 * @param BH_Payer_Info_Fld Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld")
	public void setBH_Payer_Info_FldInput(ForeignEntityInput BH_Payer_Info_Fld) {
		this.mBH_Payer_Info_Fld = BH_Payer_Info_Fld;
		MBHPayerInfoFld foreignEntity;
		if (get_ID() == 0 && BH_Payer_Info_Fld != null &&
				(foreignEntity = new Query(getCtx(), "BH_Payer_Info_Fld", "BH_Payer_Info_Fld_UU=?", get_TrxName())
						.setParameters(BH_Payer_Info_Fld.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Payer_Info_Fld_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Payer Info Field.
	 *
	 * @return Payer Info Field
	 */
	@JsonProperty("BH_Payer_Info_Fld")
	public ForeignEntityInput BH_Payer_Info_Fld() {
		return mBH_Payer_Info_Fld;
	}
}
