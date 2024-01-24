package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MOrg;
import org.compiere.model.Query;
import org.compiere.model.X_AD_PrintFormat;
import org.compiere.model.X_C_BankAccountDoc;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BankAccountDoc - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_BankAccountDocInput extends X_C_BankAccountDoc implements I_C_BankAccountDocInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mCheck_PrintFormat;
	private I_AD_Ref_ListInput mPaymentRule;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BankAccountDoc_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BankAccountDocInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new X_C_BankAccountDoc(null, (ResultSet) null, null),
				null, Table_Name, UUID), null);
		setUUID(UUID);
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
		if (get_ID() == 0 && AD_Org != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
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
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public void setC_BankAccountInput(ForeignEntityInput C_BankAccount) {
		this.mC_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (get_ID() == 0 && C_BankAccount != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + C_BankAccount.getUUID());
			}
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public ForeignEntityInput C_BankAccount() {
		return mC_BankAccount;
	}
	/**
	 * Set Bank Account Document.
	 *
	 * @param C_BankAccountDoc_ID Checks, Transfers, etc.
	 */

	public void setC_BankAccountDoc_ID(int C_BankAccountDoc_ID) {
		if (get_ID() == 0) {
			super.setC_BankAccountDoc_ID(C_BankAccountDoc_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_BankAccountDoc_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_BankAccountDoc_UU();
	}

	/**
	 * Set Check Print Format.
	 *
	 * @param Check_PrintFormat Print Format for printing Checks
	 */
	@JsonProperty("Check_PrintFormat")
	public void setCheck_PrintFormatInput(ForeignEntityInput Check_PrintFormat) {
		this.mCheck_PrintFormat = Check_PrintFormat;
		X_AD_PrintFormat foreignEntity;
		if (Check_PrintFormat != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "AD_PrintFormat", "AD_PrintFormat_UU=?", get_TrxName())
							.setParameters(Check_PrintFormat.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCheck_PrintFormat_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_PrintFormat with UUID " + Check_PrintFormat.getUUID());
			}
		} else {
			super.setCheck_PrintFormat_ID(0);
		}
	}

	/**
	 * Get Check Print Format.
	 *
	 * @return Print Format for printing Checks
	 */
	@JsonProperty("Check_PrintFormat")
	public ForeignEntityInput Check_PrintFormat() {
		return mCheck_PrintFormat;
	}

	/**
	 * Set Payment Rule.
	 *
	 * @param PaymentRule How you pay the invoice
	 */
	@JsonProperty("PaymentRule")
	public void setPaymentRuleInput(I_AD_Ref_ListInput PaymentRule) {
		this.mPaymentRule = PaymentRule;
		MRefList_BH foreignEntity;
		if (PaymentRule != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(PaymentRule.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setPaymentRule(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + PaymentRule.getUUID());
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
	public I_AD_Ref_ListInput PaymentRule() {
		return mPaymentRule;
	}
}
