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
import org.bandahealth.idempiere.graphql.resolver.model.X_C_PaymentResolver;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MBankTransfer;
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
 * @version Release 12 - $Id$
 */
public class X_C_PaymentInput extends MPayment_BH implements I_C_PaymentInput {

	private ForeignEntityInput mAD_Org;
	private ForeignEntityInput mBH_Visit;
	private ForeignEntityInput mC_Activity;
	private ForeignEntityInput mC_BP_BankAccount;
	private ForeignEntityInput mC_BPartner;
	private ForeignEntityInput mC_BankAccount;
	private ForeignEntityInput mC_BankTransfer;
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
	private ForeignEntityInput mCreditCardType;
	private ForeignEntityInput mDocAction;
	private ForeignEntityInput mDocStatus;
	private ForeignEntityInput mR_AvsAddr;
	private ForeignEntityInput mR_AvsZip;
	private ForeignEntityInput mRef_Payment;
	private ForeignEntityInput mReversal;
	private ForeignEntityInput mTenderType;
	private ForeignEntityInput mTrxType;
	private ForeignEntityInput mUser1;
	private ForeignEntityInput mUser2;

	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The C_Payment_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public X_C_PaymentInput(@JsonProperty("UU") String UU) {
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
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(ForeignEntityInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		if (BH_Visit != null) {
			// Since an entity was passed, make sure it's in the DB
			MBHVisit foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "BH_Visit", "BH_Visit_UU=?", get_TrxName())
							.setParameters(BH_Visit.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setBH_Visit_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table BH_Visit with UU " + BH_Visit.getUU());
			}
		} else {
			this.setBH_Visit_ID(0);
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
		if (C_Activity != null) {
			// Since an entity was passed, make sure it's in the DB
			MActivity foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Activity", "C_Activity_UU=?", get_TrxName())
							.setParameters(C_Activity.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Activity_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Activity with UU " + C_Activity.getUU());
			}
		} else {
			this.setC_Activity_ID(0);
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
		if (C_BankAccount != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankAccount_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankAccount", "C_BankAccount_UU=?", get_TrxName())
							.setParameters(C_BankAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BankAccount_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankAccount with UU " + C_BankAccount.getUU());
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
	 * Set Bank Transfer.
	 *
	 * @param C_BankTransfer Bank Transfer
	 */
	@JsonProperty("C_BankTransfer")
	public void setC_BankTransferInput(ForeignEntityInput C_BankTransfer) {
		this.mC_BankTransfer = C_BankTransfer;
		if (C_BankTransfer != null) {
			// Since an entity was passed, make sure it's in the DB
			MBankTransfer foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_BankTransfer", "C_BankTransfer_UU=?", get_TrxName())
							.setParameters(C_BankTransfer.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_BankTransfer_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_BankTransfer with UU " + C_BankTransfer.getUU());
			}
		} else {
			this.setC_BankTransfer_ID(0);
		}
	}

	/**
	 * Get Bank Transfer.
	 *
	 * @return Bank Transfer
	 */
	@JsonProperty("C_BankTransfer")
	public ForeignEntityInput C_BankTransfer() {
		return mC_BankTransfer;
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
							.setParameters(C_BP_BankAccount.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
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
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(ForeignEntityInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		if (C_Campaign != null) {
			// Since an entity was passed, make sure it's in the DB
			MCampaign foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Campaign", "C_Campaign_UU=?", get_TrxName())
							.setParameters(C_Campaign.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Campaign_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Campaign with UU " + C_Campaign.getUU());
			}
		} else {
			this.setC_Campaign_ID(0);
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
		if (C_CashBook != null) {
			// Since an entity was passed, make sure it's in the DB
			MCashBook foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_CashBook", "C_CashBook_UU=?", get_TrxName())
							.setParameters(C_CashBook.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_CashBook_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_CashBook with UU " + C_CashBook.getUU());
			}
		} else {
			this.setC_CashBook_ID(0);
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
		if (C_Charge != null) {
			// Since an entity was passed, make sure it's in the DB
			MCharge_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Charge", "C_Charge_UU=?", get_TrxName())
							.setParameters(C_Charge.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Charge_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Charge with UU " + C_Charge.getUU());
			}
		} else {
			this.setC_Charge_ID(0);
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
		if (C_ConversionType != null) {
			// Since an entity was passed, make sure it's in the DB
			MConversionType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ConversionType", "C_ConversionType_UU=?", get_TrxName())
							.setParameters(C_ConversionType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_ConversionType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ConversionType with UU " + C_ConversionType.getUU());
			}
		} else {
			this.setC_ConversionType_ID(0);
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
		if (C_Currency != null) {
			// Since an entity was passed, make sure it's in the DB
			MCurrency_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Currency", "C_Currency_UU=?", get_TrxName())
							.setParameters(C_Currency.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Currency_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Currency with UU " + C_Currency.getUU());
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
	 * Set Deposit Batch.
	 *
	 * @param C_DepositBatch Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public void setC_DepositBatchInput(ForeignEntityInput C_DepositBatch) {
		this.mC_DepositBatch = C_DepositBatch;
		if (get_ID() != 0) {
			return;
		}
		if (C_DepositBatch != null) {
			// Since an entity was passed, make sure it's in the DB
			MDepositBatch foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DepositBatch", "C_DepositBatch_UU=?", get_TrxName())
							.setParameters(C_DepositBatch.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_DepositBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DepositBatch with UU " + C_DepositBatch.getUU());
			}
		} else {
			this.setC_DepositBatch_ID(0);
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
		if (C_DocType != null) {
			// Since an entity was passed, make sure it's in the DB
			MDocType_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_DocType", "C_DocType_UU=?", get_TrxName())
							.setParameters(C_DocType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setC_DocType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_DocType with UU " + C_DocType.getUU());
			}
		} else {
			this.setC_DocType_ID(-1);
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
		if (C_Invoice != null) {
			// Since an entity was passed, make sure it's in the DB
			MInvoice_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Invoice", "C_Invoice_UU=?", get_TrxName())
							.setParameters(C_Invoice.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Invoice_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Invoice with UU " + C_Invoice.getUU());
			}
		} else {
			this.setC_Invoice_ID(0);
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
		if (C_Order != null) {
			// Since an entity was passed, make sure it's in the DB
			MOrder_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Order", "C_Order_UU=?", get_TrxName())
							.setParameters(C_Order.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Order_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Order with UU " + C_Order.getUU());
			}
		} else {
			this.setC_Order_ID(0);
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
	@JsonProperty("C_Payment_ID")
	public void setC_Payment_IDFromJson(int C_Payment_ID) {
		if (get_ID() == 0) {
			super.setC_Payment_ID(C_Payment_ID);
		}
	}

	/**
	 * Set UU.
	 *
	 * @param UU UU
	 */
	public void setUU(String UU) {
		setC_Payment_UU(UU);
	}

	/**
	 * Get UU.
	 *
	 * @return UU
	 */
	public String getUU() {
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
		if (C_PaymentBatch != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentBatch foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentBatch", "C_PaymentBatch_UU=?", get_TrxName())
							.setParameters(C_PaymentBatch.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_PaymentBatch_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentBatch with UU " + C_PaymentBatch.getUU());
			}
		} else {
			this.setC_PaymentBatch_ID(0);
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
		if (C_PaymentProcessor != null) {
			// Since an entity was passed, make sure it's in the DB
			MPaymentProcessor foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_PaymentProcessor", "C_PaymentProcessor_UU=?", get_TrxName())
							.setParameters(C_PaymentProcessor.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_PaymentProcessor with UU " + C_PaymentProcessor.getUU());
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
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType POS Tender Type
	 */
	@JsonProperty("C_POSTenderType")
	public void setC_POSTenderTypeInput(ForeignEntityInput C_POSTenderType) {
		this.mC_POSTenderType = C_POSTenderType;
		if (C_POSTenderType != null) {
			// Since an entity was passed, make sure it's in the DB
			X_C_POSTenderType foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_POSTenderType", "C_POSTenderType_UU=?", get_TrxName())
							.setParameters(C_POSTenderType.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_POSTenderType_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_POSTenderType with UU " + C_POSTenderType.getUU());
			}
		} else {
			this.setC_POSTenderType_ID(0);
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
		if (C_Project != null) {
			// Since an entity was passed, make sure it's in the DB
			MProject foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Project", "C_Project_UU=?", get_TrxName())
							.setParameters(C_Project.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setC_Project_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Project with UU " + C_Project.getUU());
			}
		} else {
			this.setC_Project_ID(0);
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
	public void setCreditCardTypeInput(ForeignEntityInput CreditCardType) {
		this.mCreditCardType = CreditCardType;
		if (CreditCardType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.CREDITCARDTYPE_UUIDS_BY_VALUE.containsValue(CreditCardType.getUU())) {
				throw new AdempiereException("The reference list UU of " + CreditCardType.getUU() +
						" is not in the list defined for the CreditCardType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(CreditCardType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setCreditCardType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + CreditCardType.getUU());
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
	public ForeignEntityInput CreditCardType() {
		return mCreditCardType;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction The targeted status of the document
	 */
	@JsonProperty("DocAction")
	public void setDocActionInput(ForeignEntityInput DocAction) {
		this.mDocAction = DocAction;
		if (DocAction != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.DOCACTION_UUIDS_BY_VALUE.containsValue(DocAction.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocAction.getUU() +
						" is not in the list defined for the DocAction column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocAction.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocAction(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocAction.getUU());
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
	public ForeignEntityInput DocAction() {
		return mDocAction;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus The current status of the document
	 */
	@JsonProperty("DocStatus")
	public void setDocStatusInput(ForeignEntityInput DocStatus) {
		this.mDocStatus = DocStatus;
		if (DocStatus != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.DOCSTATUS_UUIDS_BY_VALUE.containsValue(DocStatus.getUU())) {
				throw new AdempiereException("The reference list UU of " + DocStatus.getUU() +
						" is not in the list defined for the DocStatus column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(DocStatus.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setDocStatus(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + DocStatus.getUU());
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
	public ForeignEntityInput DocStatus() {
		return mDocStatus;
	}
	/**
	 * Set Approved.
	 *
	 * @param IsApproved Indicates if this document requires approval
	 */
	@JsonProperty("IsApproved")
	public void setIsApprovedFromJson(boolean IsApproved) {
		if (get_ID() == 0) {
			super.setIsApproved(IsApproved);
		}
	}
	/**
	 * Set Posted.
	 *
	 * @param Posted Posting status
	 */
	@JsonProperty("Posted")
	public void setPostedFromJson(boolean Posted) {
		if (get_ID() == 0) {
			super.setPosted(Posted);
		}
	}
	/**
	 * Set Authorization Code.
	 *
	 * @param R_AuthCode Authorization Code returned
	 */
	@JsonProperty("R_AuthCode")
	public void setR_AuthCodeFromJson(String R_AuthCode) {
		if (get_ID() == 0) {
			super.setR_AuthCode(R_AuthCode);
		}
	}
	/**
	 * Set Authorization Code (DC).
	 *
	 * @param R_AuthCode_DC Authorization Code Delayed Capture returned
	 */
	@JsonProperty("R_AuthCode_DC")
	public void setR_AuthCode_DCFromJson(String R_AuthCode_DC) {
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
	public void setR_AvsAddrInput(ForeignEntityInput R_AvsAddr) {
		this.mR_AvsAddr = R_AvsAddr;
		if (get_ID() != 0) {
			return;
		}
		if (R_AvsAddr != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.R_AVSADDR_UUIDS_BY_VALUE.containsValue(R_AvsAddr.getUU())) {
				throw new AdempiereException("The reference list UU of " + R_AvsAddr.getUU() +
						" is not in the list defined for the R_AvsAddr column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(R_AvsAddr.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_AvsAddr(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + R_AvsAddr.getUU());
			}
		} else {
			this.setR_AvsAddr(null);
		}
	}

	/**
	 * Get Address verified.
	 *
	 * @return This address has been verified
	 */
	@JsonProperty("R_AvsAddr")
	public ForeignEntityInput R_AvsAddr() {
		return mR_AvsAddr;
	}

	/**
	 * Set Zip verified.
	 *
	 * @param R_AvsZip The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public void setR_AvsZipInput(ForeignEntityInput R_AvsZip) {
		this.mR_AvsZip = R_AvsZip;
		if (get_ID() != 0) {
			return;
		}
		if (R_AvsZip != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.R_AVSZIP_UUIDS_BY_VALUE.containsValue(R_AvsZip.getUU())) {
				throw new AdempiereException("The reference list UU of " + R_AvsZip.getUU() +
						" is not in the list defined for the R_AvsZip column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(R_AvsZip.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setR_AvsZip(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + R_AvsZip.getUU());
			}
		} else {
			this.setR_AvsZip(null);
		}
	}

	/**
	 * Get Zip verified.
	 *
	 * @return The Zip Code has been verified
	 */
	@JsonProperty("R_AvsZip")
	public ForeignEntityInput R_AvsZip() {
		return mR_AvsZip;
	}
	/**
	 * Set CVV Match.
	 *
	 * @param R_CVV2Match Credit Card Verification Code Match
	 */
	@JsonProperty("R_CVV2Match")
	public void setR_CVV2MatchFromJson(boolean R_CVV2Match) {
		if (get_ID() == 0) {
			super.setR_CVV2Match(R_CVV2Match);
		}
	}
	/**
	 * Set Info.
	 *
	 * @param R_Info Response info
	 */
	@JsonProperty("R_Info")
	public void setR_InfoFromJson(String R_Info) {
		if (get_ID() == 0) {
			super.setR_Info(R_Info);
		}
	}
	/**
	 * Set Reference.
	 *
	 * @param R_PnRef Payment reference
	 */
	@JsonProperty("R_PnRef")
	public void setR_PnRefFromJson(String R_PnRef) {
		if (get_ID() == 0) {
			super.setR_PnRef(R_PnRef);
		}
	}
	/**
	 * Set Reference (DC).
	 *
	 * @param R_PnRef_DC Payment Reference Delayed Capture
	 */
	@JsonProperty("R_PnRef_DC")
	public void setR_PnRef_DCFromJson(String R_PnRef_DC) {
		if (get_ID() == 0) {
			super.setR_PnRef_DC(R_PnRef_DC);
		}
	}
	/**
	 * Set Response Message.
	 *
	 * @param R_RespMsg Response message
	 */
	@JsonProperty("R_RespMsg")
	public void setR_RespMsgFromJson(String R_RespMsg) {
		if (get_ID() == 0) {
			super.setR_RespMsg(R_RespMsg);
		}
	}
	/**
	 * Set Result.
	 *
	 * @param R_Result Result of transmission
	 */
	@JsonProperty("R_Result")
	public void setR_ResultFromJson(String R_Result) {
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
		if (get_ID() != 0) {
			return;
		}
		if (Ref_Payment != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(Ref_Payment.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setRef_Payment_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UU " + Ref_Payment.getUU());
			}
		} else {
			this.setRef_Payment_ID(0);
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
		if (Reversal != null) {
			// Since an entity was passed, make sure it's in the DB
			MPayment_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_Payment", "C_Payment_UU=?", get_TrxName())
							.setParameters(Reversal.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setReversal_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_Payment with UU " + Reversal.getUU());
			}
		} else {
			this.setReversal_ID(0);
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
	@JsonProperty("Swipe")
	public void setSwipeFromJson(String Swipe) {
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
	public void setTenderTypeInput(ForeignEntityInput TenderType) {
		this.mTenderType = TenderType;
		if (TenderType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.TENDERTYPE_UUIDS_BY_VALUE.containsValue(TenderType.getUU())) {
				throw new AdempiereException("The reference list UU of " + TenderType.getUU() +
						" is not in the list defined for the TenderType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TenderType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTenderType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + TenderType.getUU());
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
	public ForeignEntityInput TenderType() {
		return mTenderType;
	}

	/**
	 * Set Transaction Type.
	 *
	 * @param TrxType Type of credit card transaction
	 */
	@JsonProperty("TrxType")
	public void setTrxTypeInput(ForeignEntityInput TrxType) {
		this.mTrxType = TrxType;
		if (TrxType != null) {
			// Since an entity was passed, make sure it's in the list of acceptable values
			if (!X_C_PaymentResolver.TRXTYPE_UUIDS_BY_VALUE.containsValue(TrxType.getUU())) {
				throw new AdempiereException("The reference list UU of " + TrxType.getUU() +
						" is not in the list defined for the TrxType column");
			}
			// Now make sure it's in the DB
			MRefList_BH foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
							.setParameters(TrxType.getUU()).first()) != null && foreignEntity.get_ID() >= 0) {
				this.setTrxType(foreignEntity.getValue());
			} else {
				throw new AdempiereException(
						"Could not find entity in table " + MRefList_BH.Table_Name + " with UU " + TrxType.getUU());
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
	public ForeignEntityInput TrxType() {
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
		if (User1 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User1.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setUser1_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + User1.getUU());
			}
		} else {
			this.setUser1_ID(0);
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
		if (User2 != null) {
			// Since an entity was passed, make sure it's in the DB
			MElementValue foreignEntity;
			if ((foreignEntity =
					new Query(getCtx(), "C_ElementValue", "C_ElementValue_UU=?", get_TrxName())
							.setParameters(User2.getUU()).first()) != null && foreignEntity.get_ID() >= 1) {
				this.setUser2_ID(foreignEntity.get_ID());
			} else {
				throw new AdempiereException(
						"Could not find entity in table C_ElementValue with UU " + User2.getUU());
			}
		} else {
			this.setUser2_ID(0);
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
