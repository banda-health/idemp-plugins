package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFld;
import org.bandahealth.idempiere.base.model.MBHPayerInfoFldVal;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_Payer_Info_Fld_Val - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_Payer_Info_Fld_ValInput extends MBHPayerInfoFldVal implements I_BH_Payer_Info_Fld_ValInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payer_Info_Fld;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_Payer_Info_Fld_ValInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHPayerInfoFldVal(null, (ResultSet) null, null), null, Table_Name, ID),
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
	/**
	 * Set Payer Info Values.
	 *
	 * @param BH_Payer_Info_Fld_Val_ID Payer Info Values
	 */

	public void setBH_Payer_Info_Fld_Val_ID(int BH_Payer_Info_Fld_Val_ID) {
		if (get_ID() == 0) {
			super.setBH_Payer_Info_Fld_Val_ID(BH_Payer_Info_Fld_Val_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_Payer_Info_Fld_Val_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_Payer_Info_Fld_Val_UU();
	}
}
