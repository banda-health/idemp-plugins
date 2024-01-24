package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Customer_Acct;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Customer_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BP_Customer_AcctInput extends X_C_BP_Customer_Acct implements I_C_BP_Customer_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Prepayment_A;
	private ForeignEntityInput mC_Receivable_A;
	private ForeignEntityInput mC_Receivable_Services_A;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_BP_Customer_AcctInput(@JsonProperty("ID") String ID) {
		super(null, ModelUtil.getModelResultSet(new X_C_BP_Customer_Acct(null, (ResultSet) null, null), null, Table_Name, ID),
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
		setC_BP_Customer_Acct_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_BP_Customer_Acct_UU();
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
	 * Set Customer Prepayment.
	 *
	 * @param C_Prepayment_A Account for customer prepayments
	 */
	@JsonProperty("C_Prepayment_A")
	public void setC_Prepayment_AInput(ForeignEntityInput C_Prepayment_A) {
		this.mC_Prepayment_A = C_Prepayment_A;
		MAccount foreignEntity;
		if (C_Prepayment_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_Prepayment_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Prepayment_Acct(foreignEntity.get_ID());
		} else {
			super.setC_Prepayment_Acct(0);
		}
	}

	/**
	 * Get Customer Prepayment.
	 *
	 * @return Account for customer prepayments
	 */
	@JsonProperty("C_Prepayment_A")
	public ForeignEntityInput C_Prepayment_A() {
		return mC_Prepayment_A;
	}

	/**
	 * Set Customer Receivables.
	 *
	 * @param C_Receivable_A Account for Customer Receivables
	 */
	@JsonProperty("C_Receivable_A")
	public void setC_Receivable_AInput(ForeignEntityInput C_Receivable_A) {
		this.mC_Receivable_A = C_Receivable_A;
		MAccount foreignEntity;
		if (C_Receivable_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_Receivable_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Receivable_Acct(foreignEntity.get_ID());
		} else {
			super.setC_Receivable_Acct(0);
		}
	}

	/**
	 * Get Customer Receivables.
	 *
	 * @return Account for Customer Receivables
	 */
	@JsonProperty("C_Receivable_A")
	public ForeignEntityInput C_Receivable_A() {
		return mC_Receivable_A;
	}

	/**
	 * Set Receivable Services.
	 *
	 * @param C_Receivable_Services_A Customer Accounts Receivables Services Account
	 */
	@JsonProperty("C_Receivable_Services_A")
	public void setC_Receivable_Services_AInput(ForeignEntityInput C_Receivable_Services_A) {
		this.mC_Receivable_Services_A = C_Receivable_Services_A;
		MAccount foreignEntity;
		if (C_Receivable_Services_A != null &&
				(foreignEntity = new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
						.setParameters(C_Receivable_Services_A.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Receivable_Services_Acct(foreignEntity.get_ID());
		} else {
			super.setC_Receivable_Services_Acct(0);
		}
	}

	/**
	 * Get Receivable Services.
	 *
	 * @return Customer Accounts Receivables Services Account
	 */
	@JsonProperty("C_Receivable_Services_A")
	public ForeignEntityInput C_Receivable_Services_A() {
		return mC_Receivable_Services_A;
	}
}
