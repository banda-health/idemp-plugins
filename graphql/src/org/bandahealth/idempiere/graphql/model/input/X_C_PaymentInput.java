package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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

/**
 * Generated Model for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentInput extends MPayment_BH implements I_C_PaymentInput {

	 private I_AD_OrgInput mAD_Org;
	 private I_AD_Ref_ListInput mCreditCardType;
	 private I_AD_Ref_ListInput mDocAction;
	 private I_AD_Ref_ListInput mDocStatus;
	 private I_AD_Ref_ListInput mR_AvsAddr;
	 private I_AD_Ref_ListInput mR_AvsZip;
	 private I_AD_Ref_ListInput mTenderType;
	 private I_AD_Ref_ListInput mTrxType;
	 private I_BH_VisitInput mBH_Visit;
	 private I_C_ActivityInput mC_Activity;
	 private I_C_BP_BankAccountInput mC_BP_BankAccount;
	 private I_C_BPartnerInput mC_BPartner;
	 private I_C_BankAccountInput mC_BankAccount;
	 private I_C_CampaignInput mC_Campaign;
	 private I_C_CashBookInput mC_CashBook;
	 private I_C_ChargeInput mC_Charge;
	 private I_C_ConversionTypeInput mC_ConversionType;
	 private I_C_CurrencyInput mC_Currency;
	 private I_C_DepositBatchInput mC_DepositBatch;
	 private I_C_DocTypeInput mC_DocType;
	 private I_C_ElementValueInput mUser1;
	 private I_C_ElementValueInput mUser2;
	 private I_C_InvoiceInput mC_Invoice;
	 private I_C_OrderInput mC_Order;
	 private I_C_POSTenderTypeInput mC_POSTenderType;
	 private I_C_PaymentBatchInput mC_PaymentBatch;
	 private I_C_PaymentInput mRef_Payment;
	 private I_C_PaymentInput mReversal;
	 private I_C_PaymentProcessorInput mC_PaymentProcessor;
	 private I_C_ProjectInput mC_Project;

	/**
	 * Standard constructor
	 */
	@JsonCreator
	public X_C_PaymentInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	@JsonProperty("AD_Org")
	public void setAD_OrgInput(I_AD_OrgInput AD_Org) {
		this.mAD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
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
	public I_AD_OrgInput AD_Org() {
		return mAD_Org;
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	@JsonProperty("BH_Visit")
	public void setBH_VisitInput(I_BH_VisitInput BH_Visit) {
		this.mBH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null &&
				(foreignEntity = new Query(getCtx(), MBHVisit.Table_Name, MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", get_TrxName())
						.setParameters(BH_Visit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setBH_Visit_ID(foreignEntity.get_ID());
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
	public I_BH_VisitInput BH_Visit() {
		return mBH_Visit;
	}

	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	@JsonProperty("C_Activity")
	public void setC_ActivityInput(I_C_ActivityInput C_Activity) {
		this.mC_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Activity_ID(foreignEntity.get_ID());
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
	public I_C_ActivityInput C_Activity() {
		return mC_Activity;
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	@JsonProperty("C_BankAccount")
	public void setC_BankAccountInput(I_C_BankAccountInput C_BankAccount) {
		this.mC_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBankAccount_BH.Table_Name, MBankAccount_BH.COLUMNNAME_C_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BankAccount_ID(foreignEntity.get_ID());
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
	public I_C_BankAccountInput C_BankAccount() {
		return mC_BankAccount;
	}

	/**
	 * Set Partner Bank Account.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	@JsonProperty("C_BP_BankAccount")
	public void setC_BP_BankAccountInput(I_C_BP_BankAccountInput C_BP_BankAccount) {
		this.mC_BP_BankAccount = C_BP_BankAccount;
		MBPBankAccount foreignEntity;
		if (C_BP_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBPBankAccount.Table_Name, MBPBankAccount.COLUMNNAME_C_BP_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BP_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BP_BankAccount_ID(foreignEntity.get_ID());
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
	public I_C_BP_BankAccountInput C_BP_BankAccount() {
		return mC_BP_BankAccount;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	@JsonProperty("C_BPartner")
	public void setC_BPartnerInput(I_C_BPartnerInput C_BPartner) {
		this.mC_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_BPartner_ID(foreignEntity.get_ID());
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
	public I_C_BPartnerInput C_BPartner() {
		return mC_BPartner;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	@JsonProperty("C_Campaign")
	public void setC_CampaignInput(I_C_CampaignInput C_Campaign) {
		this.mC_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Campaign_ID(foreignEntity.get_ID());
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
	public I_C_CampaignInput C_Campaign() {
		return mC_Campaign;
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	@JsonProperty("C_CashBook")
	public void setC_CashBookInput(I_C_CashBookInput C_CashBook) {
		this.mC_CashBook = C_CashBook;
		MCashBook foreignEntity;
		if (C_CashBook != null &&
				(foreignEntity = new Query(getCtx(), MCashBook.Table_Name, MCashBook.COLUMNNAME_C_CashBook_UU + "=?", get_TrxName())
						.setParameters(C_CashBook.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_CashBook_ID(foreignEntity.get_ID());
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
	public I_C_CashBookInput C_CashBook() {
		return mC_CashBook;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	@JsonProperty("C_Charge")
	public void setC_ChargeInput(I_C_ChargeInput C_Charge) {
		this.mC_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Charge_ID(foreignEntity.get_ID());
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
	public I_C_ChargeInput C_Charge() {
		return mC_Charge;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	@JsonProperty("C_ConversionType")
	public void setC_ConversionTypeInput(I_C_ConversionTypeInput C_ConversionType) {
		this.mC_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null &&
				(foreignEntity = new Query(getCtx(), MConversionType.Table_Name, MConversionType.COLUMNNAME_C_ConversionType_UU + "=?", get_TrxName())
						.setParameters(C_ConversionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_ConversionType_ID(foreignEntity.get_ID());
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
	public I_C_ConversionTypeInput C_ConversionType() {
		return mC_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	@JsonProperty("C_Currency")
	public void setC_CurrencyInput(I_C_CurrencyInput C_Currency) {
		this.mC_Currency = C_Currency;
		MCurrency_BH foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency_BH.Table_Name, MCurrency_BH.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Currency_ID(foreignEntity.get_ID());
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
	public I_C_CurrencyInput C_Currency() {
		return mC_Currency;
	}

	/**
	 * Set Deposit Batch.
	 *
	 * @param C_DepositBatch Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public void setC_DepositBatchInput(I_C_DepositBatchInput C_DepositBatch) {
		this.mC_DepositBatch = C_DepositBatch;
		MDepositBatch foreignEntity;
		if (get_ID() == 0 &&C_DepositBatch != null &&
				(foreignEntity = new Query(getCtx(), MDepositBatch.Table_Name, MDepositBatch.COLUMNNAME_C_DepositBatch_UU + "=?", get_TrxName())
						.setParameters(C_DepositBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DepositBatch_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Deposit Batch.
	 *
	 * @return Deposit Batch
	 */
	@JsonProperty("C_DepositBatch")
	public I_C_DepositBatchInput C_DepositBatch() {
		return mC_DepositBatch;
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	@JsonProperty("C_DocType")
	public void setC_DocTypeInput(I_C_DocTypeInput C_DocType) {
		this.mC_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_DocType_ID(foreignEntity.get_ID());
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
	public I_C_DocTypeInput C_DocType() {
		return mC_DocType;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	@JsonProperty("C_Invoice")
	public void setC_InvoiceInput(I_C_InvoiceInput C_Invoice) {
		this.mC_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Invoice_ID(foreignEntity.get_ID());
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
	public I_C_InvoiceInput C_Invoice() {
		return mC_Invoice;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	@JsonProperty("C_Order")
	public void setC_OrderInput(I_C_OrderInput C_Order) {
		this.mC_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Order_ID(foreignEntity.get_ID());
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
	public I_C_OrderInput C_Order() {
		return mC_Order;
	}

	/**
	 * Set ID.
	 *
	 * @param ID ID
	 */
	public void setID(String ID) {
		setC_Payment_UU(ID);
	}

	/**
	 * Get ID.
	 *
	 * @return ID
	 */
	public String getID() {
		return getC_Payment_UU();
	}

	/**
	 * Set Payment Batch.
	 *
	 * @param C_PaymentBatch Payment batch for EFT
	 */
	@JsonProperty("C_PaymentBatch")
	public void setC_PaymentBatchInput(I_C_PaymentBatchInput C_PaymentBatch) {
		this.mC_PaymentBatch = C_PaymentBatch;
		MPaymentBatch foreignEntity;
		if (C_PaymentBatch != null &&
				(foreignEntity = new Query(getCtx(), MPaymentBatch.Table_Name, MPaymentBatch.COLUMNNAME_C_PaymentBatch_UU + "=?", get_TrxName())
						.setParameters(C_PaymentBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaymentBatch_ID(foreignEntity.get_ID());
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
	public I_C_PaymentBatchInput C_PaymentBatch() {
		return mC_PaymentBatch;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	@JsonProperty("C_PaymentProcessor")
	public void setC_PaymentProcessorInput(I_C_PaymentProcessorInput C_PaymentProcessor) {
		this.mC_PaymentProcessor = C_PaymentProcessor;
		MPaymentProcessor foreignEntity;
		if (C_PaymentProcessor != null &&
				(foreignEntity = new Query(getCtx(), MPaymentProcessor.Table_Name, MPaymentProcessor.COLUMNNAME_C_PaymentProcessor_UU + "=?", get_TrxName())
						.setParameters(C_PaymentProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_PaymentProcessor_ID(foreignEntity.get_ID());
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
	public I_C_PaymentProcessorInput C_PaymentProcessor() {
		return mC_PaymentProcessor;
	}

	/**
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType POS Tender Type
	 */
	@JsonProperty("C_POSTenderType")
	public void setC_POSTenderTypeInput(I_C_POSTenderTypeInput C_POSTenderType) {
		this.mC_POSTenderType = C_POSTenderType;
		X_C_POSTenderType foreignEntity;
		if (C_POSTenderType != null &&
				(foreignEntity = new Query(getCtx(), X_C_POSTenderType.Table_Name, X_C_POSTenderType.COLUMNNAME_C_POSTenderType_UU + "=?", get_TrxName())
						.setParameters(C_POSTenderType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_POSTenderType_ID(foreignEntity.get_ID());
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
	public I_C_POSTenderTypeInput C_POSTenderType() {
		return mC_POSTenderType;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	@JsonProperty("C_Project")
	public void setC_ProjectInput(I_C_ProjectInput C_Project) {
		this.mC_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setC_Project_ID(foreignEntity.get_ID());
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
	public I_C_ProjectInput C_Project() {
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
		if (CreditCardType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CreditCardType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setCreditCardType(foreignEntity.getValue());
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
		if (DocAction != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocAction(foreignEntity.getValue());
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
		if (DocStatus != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setDocStatus(foreignEntity.getValue());
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
		if (get_ID() == 0 &&R_AvsAddr != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsAddr.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsAddr(foreignEntity.getValue());
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
		if (get_ID() == 0 &&R_AvsZip != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsZip.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsZip(foreignEntity.getValue());
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
	public void setRef_PaymentInput(I_C_PaymentInput Ref_Payment) {
		this.mRef_Payment = Ref_Payment;
		MPayment_BH foreignEntity;
		if (get_ID() == 0 &&Ref_Payment != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(Ref_Payment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setRef_Payment_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Referenced Payment.
	 *
	 * @return Referenced Payment
	 */
	@JsonProperty("Ref_Payment")
	public I_C_PaymentInput Ref_Payment() {
		return mRef_Payment;
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	@JsonProperty("Reversal")
	public void setReversalInput(I_C_PaymentInput Reversal) {
		this.mReversal = Reversal;
		MPayment_BH foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setReversal_ID(foreignEntity.get_ID());
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
	public I_C_PaymentInput Reversal() {
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
		if (TenderType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TenderType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTenderType(foreignEntity.getValue());
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
		if (TrxType != null &&
				(foreignEntity = new Query(getCtx(), MRefList_BH.Table_Name, MRefList_BH.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TrxType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setTrxType(foreignEntity.getValue());
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
	public void setUser1Input(I_C_ElementValueInput User1) {
		this.mUser1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser1_ID(foreignEntity.get_ID());
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
	public I_C_ElementValueInput User1() {
		return mUser1;
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	@JsonProperty("User2")
	public void setUser2Input(I_C_ElementValueInput User2) {
		this.mUser2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			super.setUser2_ID(foreignEntity.get_ID());
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
	public I_C_ElementValueInput User2() {
		return mUser2;
	}
}
