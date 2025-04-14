package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MAccount;
import org.compiere.model.MAcctSchema;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_C_BP_Customer_Acct;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BP_Customer_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_C_BP_Customer_AcctInput extends X_C_BP_Customer_Acct implements I_C_BP_Customer_AcctInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_AcctSchema;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_Prepayment_A;
	private ForeignEntityInput mC_Receivable_A;
	private ForeignEntityInput mC_Receivable_Services_A;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_BP_Customer_Acct_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BP_Customer_AcctInput(@JsonProperty("UU") String UU) {
		super(Env.getCtx(), ModelUtil.confirmUuidOrError(null, Table_Name, UU), null);
		setUU(UU);
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
	 * Set Accounting Schema.
	 *
	 * @param C_AcctSchema Rules for accounting
	 */
	@JsonProperty("C_AcctSchema")
	public void setC_AcctSchemaInput(ForeignEntityInput C_AcctSchema) {
		this.mC_AcctSchema = C_AcctSchema;
		if (get_ID() != 0) {
			return;
		}
		if (C_AcctSchema != null) {
			// Since an entity was passed, make sure it's in the DB
			MAcctSchema foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_AcctSchema", "C_AcctSchema_UU=?", get_TrxName())
							.setParameters(C_AcctSchema.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_AcctSchema_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_AcctSchema with UU " + C_AcctSchema.getUU());
			}
		} else {
			this.setC_AcctSchema_ID(0);
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
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_BP_Customer_Acct_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_BP_Customer_Acct_UU();
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (get_ID() != 0) {
			return;
		}
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UU " + C_BPartner.getUU());
			}
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner.
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
		if (C_Prepayment_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_Prepayment_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Prepayment_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + C_Prepayment_A.getUU());
			}
		} else {
			this.setC_Prepayment_Acct(0);
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
		if (C_Receivable_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_Receivable_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Receivable_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + C_Receivable_A.getUU());
			}
		} else {
			this.setC_Receivable_Acct(0);
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
		if (C_Receivable_Services_A != null) {
			// Since an entity was passed, make sure it's in the DB
			MAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ValidCombination", "C_ValidCombination_UU=?", get_TrxName())
							.setParameters(C_Receivable_Services_A.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Receivable_Services_Acct(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ValidCombination with UU " + C_Receivable_Services_A.getUU());
			}
		} else {
			this.setC_Receivable_Services_Acct(0);
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
