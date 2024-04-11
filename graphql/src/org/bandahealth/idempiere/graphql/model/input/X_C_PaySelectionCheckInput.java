package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MOrg;
import org.compiere.model.MPaySelection;
import org.compiere.model.MPaySelectionCheck;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_PaySelectionCheck - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaySelectionCheckInput extends MPaySelectionCheck implements I_C_PaySelectionCheckInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BP_BankAccount;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_PaySelection;
	private ForeignEntityInput mC_Payment;
	private ForeignEntityInput mPaymentRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_PaySelectionCheck_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaySelectionCheckInput(@JsonProperty("UU") String UU) {
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
	 * Set Partner Bank Account.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount")
	public void setC_BP_BankAccountInput(ForeignEntityInput C_BP_BankAccount) {
		this.mC_BP_BankAccount = C_BP_BankAccount;
		if (C_BP_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPBankAccount foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_BankAccount", "C_BP_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BP_BankAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_BP_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_BankAccount with UU " + C_BP_BankAccount.getUU());
			}
		} else {
			this.setC_BP_BankAccount_ID(0);
		}
	}

	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount")
	public ForeignEntityInput C_BP_BankAccount() {
		return mC_BP_BankAccount;
	}

	/**
	 * Set Business Partner.
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		if (C_BPartner != null) {
			// Since an entity was passed, make sure it's in the DB
			MBPartner_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
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
	 * Set Payment.
	 *
	 * @param C_Payment Payment identifier
	 */
	@JsonProperty("C_Payment")
	public void setC_PaymentInput(ForeignEntityInput C_Payment) {
		this.mC_Payment = C_Payment;
		if (C_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(C_Payment.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UU " + C_Payment.getUU());
			}
		} else {
			this.setC_Payment_ID(0);
		}
	}

	/**
	 * Get Payment.
	 *
	 * @return Payment identifier
	 */
	@JsonProperty("C_Payment")
	public ForeignEntityInput C_Payment() {
		return mC_Payment;
	}

	/**
	 * Set Payment Selection.
	 *
	 * @param C_PaySelection Payment Selection
	 */
	@JsonProperty("C_PaySelection")
	public void setC_PaySelectionInput(ForeignEntityInput C_PaySelection) {
		this.mC_PaySelection = C_PaySelection;
		if (get_ID() != 0) {
			return;
		}
		if (C_PaySelection != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaySelection foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaySelection", "C_PaySelection_UU=?", get_TrxName())
							.setParameters(C_PaySelection.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_PaySelection_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaySelection with UU " + C_PaySelection.getUU());
			}
		} else {
			this.setC_PaySelection_ID(0);
		}
	}

	/**
	 * Get Payment Selection.
	 *
	 * @return Payment Selection
	 */
	@JsonProperty("C_PaySelection")
	public ForeignEntityInput C_PaySelection() {
		return mC_PaySelection;
	}
	/**
	 * Set Pay Selection Check.
	 *
	 * @param C_PaySelectionCheck_ID Payment Selection Check
	 */

	public void setC_PaySelectionCheck_ID(int C_PaySelectionCheck_ID) {
		if (get_ID() == 0) {
			super.setC_PaySelectionCheck_ID(C_PaySelectionCheck_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_PaySelectionCheck_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
		return getC_PaySelectionCheck_UU();
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(ForeignEntityInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		if (PaymentRule != null) {
			// Since an entity was passed, make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRule.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setPaymentRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + PaymentRule.getUU());
			}
		} else {
			this.setPaymentRule(null);
		}
	}

	/**
	 * Get Payment Rule.
	 *
	 * @return How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public ForeignEntityInput PaymentRule() {
		return mPaymentRule;
	}
}
