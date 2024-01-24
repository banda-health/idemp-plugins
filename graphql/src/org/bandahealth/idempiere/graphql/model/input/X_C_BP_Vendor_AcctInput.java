package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Vendor_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Vendor_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BP_Vendor_AcctInput extends X_C_BP_Vendor_Acct implements I_C_BP_Vendor_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mV_Liability_A;
	private ForeignEntityInput mV_Liability_Services_A;
	private ForeignEntityInput mV_Prepayment_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_Vendor_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_BP_Vendor_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		MAcctSchema foreignEntity;
		if (get_ID() == 0 && C_AcctSchema != null &&
				(foreignEntity = new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
						.setParameters(C_AcctSchema.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_AcctSchema_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Accounting Schema.
	 *
	 * @return Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public ForeignEntityInput C_AcctSchema() {
		return mC_AcctSchema;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_BP_Vendor_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BP_Vendor_Acct_UU();
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

	/**
	 * Set Vendor Liability.
	 *
	 * @param V_Liability_A Account for Vendor Liability
	 */
	@JsonProperty("V_Liability_A")
	public void setV_Liability_AInput(ForeignEntityInput V_Liability_A) {
		this.mV_Liability_A = V_Liability_A;
		MAccount foreignEntity;
		if (V_Liability_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(V_Liability_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setV_Liability_Acct(foreignEntity.get_ID());
		} else {
			super.setV_Liability_Acct(0);
		}
	}

	/**
	 * Get Vendor Liability.
	 *
	 * @return Account for Vendor Liability
	 */
	@JsonProperty("V_Liability_A")
	public ForeignEntityInput V_Liability_A() {
		return mV_Liability_A;
	}

	/**
	 * Set Vendor Service Liability.
	 *
	 * @param V_Liability_Services_A Account for Vendor Service Liability
	 */
	@JsonProperty("V_Liability_Services_A")
	public void setV_Liability_Services_AInput(ForeignEntityInput V_Liability_Services_A) {
		this.mV_Liability_Services_A = V_Liability_Services_A;
		MAccount foreignEntity;
		if (V_Liability_Services_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(V_Liability_Services_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setV_Liability_Services_Acct(foreignEntity.get_ID());
		} else {
			super.setV_Liability_Services_Acct(0);
		}
	}

	/**
	 * Get Vendor Service Liability.
	 *
	 * @return Account for Vendor Service Liability
	 */
	@JsonProperty("V_Liability_Services_A")
	public ForeignEntityInput V_Liability_Services_A() {
		return mV_Liability_Services_A;
	}

	/**
	 * Set Vendor Prepayment.
	 *
	 * @param V_Prepayment_A Account for Vendor Prepayments
	 */
	@JsonProperty("V_Prepayment_A")
	public void setV_Prepayment_AInput(ForeignEntityInput V_Prepayment_A) {
		this.mV_Prepayment_A = V_Prepayment_A;
		MAccount foreignEntity;
		if (V_Prepayment_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(V_Prepayment_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setV_Prepayment_Acct(foreignEntity.get_ID());
		} else {
			super.setV_Prepayment_Acct(0);
		}
	}

	/**
	 * Get Vendor Prepayment.
	 *
	 * @return Account for Vendor Prepayments
	 */
	@JsonProperty("V_Prepayment_A")
	public ForeignEntityInput V_Prepayment_A() {
		return mV_Prepayment_A;
	}
}
