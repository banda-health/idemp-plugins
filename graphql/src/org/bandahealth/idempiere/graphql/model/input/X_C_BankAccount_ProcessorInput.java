package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MBankAccountProcessor;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_BankAccount_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_BankAccount_ProcessorInput extends MBankAccountProcessor implements I_C_BankAccount_ProcessorInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_PaymentProcessor;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BankAccount_Processor_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_BankAccount_ProcessorInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MBankAccountProcessor(null, (ResultSet) null, null),
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
		if (get_ID() != 0) {
			return;
		}
		if (AD_Org != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrg foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "AD_Org", "AD_Org_UU=?", get_TrxName())
							.setParameters(AD_Org.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setAD_Org_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table AD_Org with UUID " + AD_Org.getUUID());
			}
		} else {
			this.setAD_Org_ID(0);
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
		if (get_ID() != 0) {
			return;
		}
		if (C_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + C_BankAccount.getUUID());
			}
		} else {
			this.setC_BankAccount_ID(0);
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
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_BankAccount_Processor_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_BankAccount_Processor_UU();
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public ForeignEntityInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public void setC_PaymentProcessorInput(ForeignEntityInput C_PaymentProcessor) {
		this.mC_PaymentProcessor = C_PaymentProcessor;
		if (get_ID() != 0) {
			return;
		}
		if (C_PaymentProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentProcessor", "C_PaymentProcessor_UU=?", get_TrxName())
							.setParameters(C_PaymentProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentProcessor with UUID " + C_PaymentProcessor.getUUID());
			}
		} else {
			this.setC_PaymentProcessor_ID(0);
		}
	}

	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public ForeignEntityInput C_PaymentProcessor() {
		return mC_PaymentProcessor;
	}
	/**
	 * Set Accept AMEX.
	 *
	 * @param IsPPAcceptAMEX Accept AMEX
	 */

	public void setIsPPAcceptAMEX(boolean IsPPAcceptAMEX) {
		if (get_ID() == 0) {
			super.setIsPPAcceptAMEX(IsPPAcceptAMEX);
		}
	}
	/**
	 * Set Accept ATM.
	 *
	 * @param IsPPAcceptATM Accept ATM
	 */

	public void setIsPPAcceptATM(boolean IsPPAcceptATM) {
		if (get_ID() == 0) {
			super.setIsPPAcceptATM(IsPPAcceptATM);
		}
	}
	/**
	 * Set Accept Check.
	 *
	 * @param IsPPAcceptCheck Accept Check
	 */

	public void setIsPPAcceptCheck(boolean IsPPAcceptCheck) {
		if (get_ID() == 0) {
			super.setIsPPAcceptCheck(IsPPAcceptCheck);
		}
	}
	/**
	 * Set Accept Corporate.
	 *
	 * @param IsPPAcceptCorporate Accept Corporate
	 */

	public void setIsPPAcceptCorporate(boolean IsPPAcceptCorporate) {
		if (get_ID() == 0) {
			super.setIsPPAcceptCorporate(IsPPAcceptCorporate);
		}
	}
	/**
	 * Set Accept Diners.
	 *
	 * @param IsPPAcceptDiners Accept Diners
	 */

	public void setIsPPAcceptDiners(boolean IsPPAcceptDiners) {
		if (get_ID() == 0) {
			super.setIsPPAcceptDiners(IsPPAcceptDiners);
		}
	}
	/**
	 * Set Accept Direct Debit.
	 *
	 * @param IsPPAcceptDirectDebit Accept Direct Debit
	 */

	public void setIsPPAcceptDirectDebit(boolean IsPPAcceptDirectDebit) {
		if (get_ID() == 0) {
			super.setIsPPAcceptDirectDebit(IsPPAcceptDirectDebit);
		}
	}
	/**
	 * Set Accept Direct Deposit.
	 *
	 * @param IsPPAcceptDirectDeposit Accept Direct Deposit
	 */

	public void setIsPPAcceptDirectDeposit(boolean IsPPAcceptDirectDeposit) {
		if (get_ID() == 0) {
			super.setIsPPAcceptDirectDeposit(IsPPAcceptDirectDeposit);
		}
	}
	/**
	 * Set Accept Discover.
	 *
	 * @param IsPPAcceptDiscover Accept Discover
	 */

	public void setIsPPAcceptDiscover(boolean IsPPAcceptDiscover) {
		if (get_ID() == 0) {
			super.setIsPPAcceptDiscover(IsPPAcceptDiscover);
		}
	}
	/**
	 * Set Accept MasterCard.
	 *
	 * @param IsPPAcceptMC Accept MasterCard
	 */

	public void setIsPPAcceptMC(boolean IsPPAcceptMC) {
		if (get_ID() == 0) {
			super.setIsPPAcceptMC(IsPPAcceptMC);
		}
	}
	/**
	 * Set Accept Visa.
	 *
	 * @param IsPPAcceptVisa Accept Visa
	 */

	public void setIsPPAcceptVisa(boolean IsPPAcceptVisa) {
		if (get_ID() == 0) {
			super.setIsPPAcceptVisa(IsPPAcceptVisa);
		}
	}
}
