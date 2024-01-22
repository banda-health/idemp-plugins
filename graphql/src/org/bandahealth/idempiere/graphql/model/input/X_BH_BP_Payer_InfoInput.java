package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHBPPayerInfo;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;

import java.sql.ResultSet;

/**
 * Generated Model for BH_BP_Payer_Info - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_BH_BP_Payer_InfoInput extends MBHBPPayerInfo implements I_BH_BP_Payer_InfoInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Payer;
	private ForeignEntityInput mC_BPartner;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_BH_BP_Payer_InfoInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new MBHBPPayerInfo(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Business Partner Payer Information.
	 *
	 * @param BH_BP_Payer_Info_ID Business Partner Payer Information
	 */

	public void setBH_BP_Payer_Info_ID(int BH_BP_Payer_Info_ID) {
		if (get_ID() == 0) {
			super.setBH_BP_Payer_Info_ID(BH_BP_Payer_Info_ID);
		}
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setBH_BP_Payer_Info_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getBH_BP_Payer_Info_UU();
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (get_ID() == 0 && C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public ForeignEntityInput C_BPartner() {
		return mC_BPartner;
	}
}
