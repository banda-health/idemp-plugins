package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adempiere.exceptions.AdempiereException;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MCurrency_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.base.model.MRefList_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashBook;
import org.compiere.model.MConversionType;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentBatch;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.MProject;
import org.compiere.model.Query;
import org.compiere.model.X_C_POSTenderType;
import org.compiere.util.Env;

import java.sql.ResultSet;

/**
 * Generated Model for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentInput extends MPayment_BH implements I_C_PaymentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Visit;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BP_BankAccount;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_Campaign;
	private ForeignEntityInput mC_CashBook;
	private ForeignEntityInput mC_Charge;
	private ForeignEntityInput mC_ConversionType;
	private ForeignEntityInput mC_Currency;
	private ForeignEntityInput mC_DepositBatch;
	private ForeignEntityInput mC_DocType;
	private ForeignEntityInput mC_Invoice;
	private ForeignEntityInput mC_Order;
	private ForeignEntityInput mC_POSTenderType;
	private ForeignEntityInput mC_PaymentBatch;
	private ForeignEntityInput mC_PaymentProcessor;
	private ForeignEntityInput mC_Project;
	private ForeignEntityInput mRef_Payment;
	private ForeignEntityInput mReversal;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;
	private I_AD_Ref_ListInput mCreditCardType;
	private I_AD_Ref_ListInput mDocAction;
	private I_AD_Ref_ListInput mDocStatus;
	private I_AD_Ref_ListInput mR_AvsAddr;
	private I_AD_Ref_ListInput mR_AvsZip;
	private I_AD_Ref_ListInput mTenderType;
	private I_AD_Ref_ListInput mTrxType;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_Payment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaymentInput(@JsonProperty("UUID") String UUID) {
		super(Env.getCtx(), ModelUtil.getModelResultSet(new MPayment_BH(null, (ResultSet) null, null),
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
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(ForeignEntityInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "BH_Visit", "BH_Visit_UU=?", get_TrxName())
							.setParameters(BH_Visit.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setBH_Visit_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit with UUID " + BH_Visit.getUUID());
			}
		} else {
			super.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	@JsonProperty("BH_Visit")
	public ForeignEntityInput BH_Visit() {
		return mBH_Visit;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(ForeignEntityInput C_Activity) {
		this.mC_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UUID " + C_Activity.getUUID());
			}
		} else {
			super.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	@JsonProperty("C_Activity")
	public ForeignEntityInput C_Activity() {
		return mC_Activity;
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
		if (C_BankAccount != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UUID " + C_BankAccount.getUUID());
			}
		} else {
			super.setC_BankAccount_ID(0);
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
	 * Set Partner Bank Account.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount")
	public void setC_BP_BankAccountInput(ForeignEntityInput C_BP_BankAccount) {
		this.mC_BP_BankAccount = C_BP_BankAccount;
		MBPBankAccount foreignEntity;
		if (C_BP_BankAccount != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BP_BankAccount", "C_BP_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BP_BankAccount.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BP_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BP_BankAccount with UUID " + C_BP_BankAccount.getUUID());
			}
		} else {
			super.setC_BP_BankAccount_ID(0);
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
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(ForeignEntityInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_BPartner", "C_BPartner_UU=?", get_TrxName())
							.setParameters(C_BPartner.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_BPartner_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BPartner with UUID " + C_BPartner.getUUID());
			}
		} else {
			super.setC_BPartner_ID(0);
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
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(ForeignEntityInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UUID " + C_Campaign.getUUID());
			}
		} else {
			super.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public ForeignEntityInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public void setC_CashBookInput(ForeignEntityInput C_CashBook) {
		this.mC_CashBook = C_CashBook;
		MCashBook foreignEntity;
		if (C_CashBook != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(C_CashBook.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_CashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UUID " + C_CashBook.getUUID());
			}
		} else {
			super.setC_CashBook_ID(0);
		}
	}

	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public ForeignEntityInput C_CashBook() {
		return mC_CashBook;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(ForeignEntityInput C_Charge) {
		this.mC_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UUID " + C_Charge.getUUID());
			}
		} else {
			super.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	@JsonProperty("C_Charge")
	public ForeignEntityInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(ForeignEntityInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UUID " + C_ConversionType.getUUID());
			}
		} else {
			super.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public ForeignEntityInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(ForeignEntityInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UUID " + C_Currency.getUUID());
			}
		} else {
			super.setC_Currency_ID(0);
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
	 * Set Deposit Batch.
	 *
	 * @param C_DepositBatch Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public void setC_DepositBatchInput(ForeignEntityInput C_DepositBatch) {
		this.mC_DepositBatch = C_DepositBatch;
		MDepositBatch foreignEntity;
		if (get_ID() == 0 && C_DepositBatch != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DepositBatch", "C_DepositBatch_UU=?", get_TrxName())
							.setParameters(C_DepositBatch.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DepositBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DepositBatch with UUID " + C_DepositBatch.getUUID());
			}
		}
	}

	/**
	 * Get Deposit Batch.
	 *
	 * @return Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public ForeignEntityInput C_DepositBatch() {
		return mC_DepositBatch;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(ForeignEntityInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UUID " + C_DocType.getUUID());
			}
		} else {
			super.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	@JsonProperty("C_DocType")
	public ForeignEntityInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(ForeignEntityInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UUID " + C_Invoice.getUUID());
			}
		} else {
			super.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public ForeignEntityInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(ForeignEntityInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UUID " + C_Order.getUUID());
			}
		} else {
			super.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	@JsonProperty("C_Order")
	public ForeignEntityInput C_Order() {
		return mC_Order;
	}
	/**
	 * Set Payment.
	 *
	 * @param C_Payment_ID Payment identifier
	 */

	public void setC_Payment_ID(int C_Payment_ID) {
		if (get_ID() == 0) {
			super.setC_Payment_ID(C_Payment_ID);
		}
	}

	/**
	 * Set UUID.
	 *
	 * @param UUID UUID
	 */
	public void setUUID(String UUID) {
		setC_Payment_UU(UUID);
	}

	/**
	 * Get UUID.
	 *
	 * @return UUID
	 */
	public String getUUID() {
		return getC_Payment_UU();
	}

	/**
	 * Set Payment Batch.
	 *
	 * @param C_PaymentBatch Payment batch for EFT
	 */
	@JsonProperty("C_PaymentBatch")
	public void setC_PaymentBatchInput(ForeignEntityInput C_PaymentBatch) {
		this.mC_PaymentBatch = C_PaymentBatch;
		MPaymentBatch foreignEntity;
		if (C_PaymentBatch != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentBatch", "C_PaymentBatch_UU=?", get_TrxName())
							.setParameters(C_PaymentBatch.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaymentBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentBatch with UUID " + C_PaymentBatch.getUUID());
			}
		} else {
			super.setC_PaymentBatch_ID(0);
		}
	}

	/**
	 * Get Payment Batch.
	 *
	 * @return Payment batch for EFT
	 */
	@JsonProperty("C_PaymentBatch")
	public ForeignEntityInput C_PaymentBatch() {
		return mC_PaymentBatch;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public void setC_PaymentProcessorInput(ForeignEntityInput C_PaymentProcessor) {
		this.mC_PaymentProcessor = C_PaymentProcessor;
		MPaymentProcessor foreignEntity;
		if (C_PaymentProcessor != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentProcessor", "C_PaymentProcessor_UU=?", get_TrxName())
							.setParameters(C_PaymentProcessor.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentProcessor with UUID " + C_PaymentProcessor.getUUID());
			}
		} else {
			super.setC_PaymentProcessor_ID(0);
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
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType POS Tender Type
	 */
	@JsonProperty("C_POSTenderType")
	public void setC_POSTenderTypeInput(ForeignEntityInput C_POSTenderType) {
		this.mC_POSTenderType = C_POSTenderType;
		X_C_POSTenderType foreignEntity;
		if (C_POSTenderType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_POSTenderType", "C_POSTenderType_UU=?", get_TrxName())
							.setParameters(C_POSTenderType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_POSTenderType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POSTenderType with UUID " + C_POSTenderType.getUUID());
			}
		} else {
			super.setC_POSTenderType_ID(0);
		}
	}

	/**
	 * Get POS Tender Type.
	 *
	 * @return POS Tender Type
	 */
	@JsonProperty("C_POSTenderType")
	public ForeignEntityInput C_POSTenderType() {
		return mC_POSTenderType;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(ForeignEntityInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UUID " + C_Project.getUUID());
			}
		} else {
			super.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	@JsonProperty("C_Project")
	public ForeignEntityInput C_Project() {
		return mC_Project;
	}

	/**
	 * Set Credit Card.
	 *
	 * @param CreditCardType Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public void setCreditCardTypeInput(I_AD_Ref_ListInput CreditCardType) {
		this.mCreditCardType = CreditCardType;
		MRefList_BH foreignEntity;
		if (CreditCardType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CreditCardType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setCreditCardType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + CreditCardType.getUUID());
			}
		} else {
			this.setCreditCardType(null);
		}
	}

	/**
	 * Get Credit Card.
	 *
	 * @return Credit Card (Visa, MC, AmEx)
	 */
	@JsonProperty("CreditCardType")
	public I_AD_Ref_ListInput CreditCardType() {
		return mCreditCardType;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(I_AD_Ref_ListInput DocAction) {
		this.mDocAction = DocAction;
		MRefList_BH foreignEntity;
		if (DocAction != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocAction.getUUID());
			}
		} else {
			this.setDocAction(null);
		}
	}

	/**
	 * Get Document Action.
	 *
	 * @return The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public I_AD_Ref_ListInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(I_AD_Ref_ListInput DocStatus) {
		this.mDocStatus = DocStatus;
		MRefList_BH foreignEntity;
		if (DocStatus != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + DocStatus.getUUID());
			}
		} else {
			this.setDocStatus(null);
		}
	}

	/**
	 * Get Document Status.
	 *
	 * @return The current status of the document
	 */
	@JsonProperty("DocStatus")
	public I_AD_Ref_ListInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Approved.
	 *
	 * @param IsApproved Indicates if this document requires approval
	 */

	public void setIsApproved(boolean IsApproved) {
		if (get_ID() == 0) {
			super.setIsApproved(IsApproved);
		}
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */

	public void setPosted(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}
	/**
	 * Set Authorization Code.
	 *
	 * @param R_AuthCode Authorization Code returned
	 */

	public void setR_AuthCode(String R_AuthCode) {
		if (get_ID() == 0) {
			super.setR_AuthCode(R_AuthCode);
		}
	}
	/**
	 * Set Authorization Code (DC).
	 *
	 * @param R_AuthCode_DC Authorization Code Delayed Capture returned
	 */

	public void setR_AuthCode_DC(String R_AuthCode_DC) {
		if (get_ID() == 0) {
			super.setR_AuthCode_DC(R_AuthCode_DC);
		}
	}

	/**
	 * Set Address verified.
	 *
	 * @param R_AvsAddr This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public void setR_AvsAddrInput(I_AD_Ref_ListInput R_AvsAddr) {
		this.mR_AvsAddr = R_AvsAddr;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&R_AvsAddr != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(R_AvsAddr.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_AvsAddr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + R_AvsAddr.getUUID());
			}
		}
	}

	/**
	 * Get Address verified.
	 *
	 * @return This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public I_AD_Ref_ListInput R_AvsAddr() {
		return mR_AvsAddr;
	}

	/**
	 * Set Zip verified.
	 *
	 * @param R_AvsZip The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public void setR_AvsZipInput(I_AD_Ref_ListInput R_AvsZip) {
		this.mR_AvsZip = R_AvsZip;
		MRefList_BH foreignEntity;
		if (get_ID() == 0 &&R_AvsZip != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(R_AvsZip.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setR_AvsZip(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + R_AvsZip.getUUID());
			}
		}
	}

	/**
	 * Get Zip verified.
	 *
	 * @return The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public I_AD_Ref_ListInput R_AvsZip() {
		return mR_AvsZip;
	}
	/**
	 * Set CVV Match.
	 *
	 * @param R_CVV2Match Credit Card Verification Code Match
	 */

	public void setR_CVV2Match(boolean R_CVV2Match) {
		if (get_ID() == 0) {
			super.setR_CVV2Match(R_CVV2Match);
		}
	}
	/**
	 * Set Info.
	 *
	 * @param R_Info Response info
	 */

	public void setR_Info(String R_Info) {
		if (get_ID() == 0) {
			super.setR_Info(R_Info);
		}
	}
	/**
	 * Set Reference.
	 *
	 * @param R_PnRef Payment reference
	 */

	public void setR_PnRef(String R_PnRef) {
		if (get_ID() == 0) {
			super.setR_PnRef(R_PnRef);
		}
	}
	/**
	 * Set Reference (DC).
	 *
	 * @param R_PnRef_DC Payment Reference Delayed Capture
	 */

	public void setR_PnRef_DC(String R_PnRef_DC) {
		if (get_ID() == 0) {
			super.setR_PnRef_DC(R_PnRef_DC);
		}
	}
	/**
	 * Set Response Message.
	 *
	 * @param R_RespMsg Response message
	 */

	public void setR_RespMsg(String R_RespMsg) {
		if (get_ID() == 0) {
			super.setR_RespMsg(R_RespMsg);
		}
	}
	/**
	 * Set Result.
	 *
	 * @param R_Result Result of transmission
	 */

	public void setR_Result(String R_Result) {
		if (get_ID() == 0) {
			super.setR_Result(R_Result);
		}
	}

	/**
	 * Set Referenced Payment.
	 *
	 * @param Ref_Payment Referenced Payment
	 */
	@JsonProperty("Ref_Payment")
	public void setRef_PaymentInput(ForeignEntityInput Ref_Payment) {
		this.mRef_Payment = Ref_Payment;
		MPayment_BH foreignEntity;
		if (get_ID() == 0 && Ref_Payment != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(Ref_Payment.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setRef_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + Ref_Payment.getUUID());
			}
		}
	}

	/**
	 * Get Referenced Payment.
	 *
	 * @return Referenced Payment
	 */
	@JsonProperty("Ref_Payment")
	public ForeignEntityInput Ref_Payment() {
		return mRef_Payment;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(ForeignEntityInput Reversal) {
		this.mReversal = Reversal;
		MPayment_BH foreignEntity;
		if (Reversal != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(Reversal.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setReversal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UUID " + Reversal.getUUID());
			}
		} else {
			super.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	@JsonProperty("Reversal")
	public ForeignEntityInput Reversal() {
		return mReversal;
	}
	/**
	 * Set Swipe.
	 *
	 * @param Swipe Track 1 and 2 of the Credit Card
	 */

	public void setSwipe(String Swipe) {
		if (get_ID() == 0) {
			super.setSwipe(Swipe);
		}
	}

	/**
	 * Set Tender type.
	 *
	 * @param TenderType Method of Payment
	 */
	@JsonProperty("TenderType")
	public void setTenderTypeInput(I_AD_Ref_ListInput TenderType) {
		this.mTenderType = TenderType;
		MRefList_BH foreignEntity;
		if (TenderType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TenderType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTenderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TenderType.getUUID());
			}
		} else {
			this.setTenderType(null);
		}
	}

	/**
	 * Get Tender type.
	 *
	 * @return Method of Payment
	 */
	@JsonProperty("TenderType")
	public I_AD_Ref_ListInput TenderType() {
		return mTenderType;
	}

	/**
	 * Set Transaction Type.
	 *
	 * @param TrxType Type of credit card transaction
	 */
	@JsonProperty("TrxType")
	public void setTrxTypeInput(I_AD_Ref_ListInput TrxType) {
		this.mTrxType = TrxType;
		MRefList_BH foreignEntity;
		if (TrxType != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TrxType.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setTrxType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UUID " + TrxType.getUUID());
			}
		} else {
			this.setTrxType(null);
		}
	}

	/**
	 * Get Transaction Type.
	 *
	 * @return Type of credit card transaction
	 */
	@JsonProperty("TrxType")
	public I_AD_Ref_ListInput TrxType() {
		return mTrxType;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	@JsonProperty("User1")
	public void setUser1Input(ForeignEntityInput User1) {
		this.mUser1 = User1;
		MElementValue foreignEntity;
		if (User1 != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User1.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User1.getUUID());
			}
		} else {
			super.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	@JsonProperty("User1")
	public ForeignEntityInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(ForeignEntityInput User2) {
		this.mUser2 = User2;
		MElementValue foreignEntity;
		if (User2 != null) {
			// If an entity was passed, make sure it's there
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User2.getUUID()).first()) != null && foreignEntity.get_ID() != 0) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UUID " + User2.getUUID());
			}
		} else {
			super.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	@JsonProperty("User2")
	public ForeignEntityInput User2() {
		return mUser2;
	}
}
