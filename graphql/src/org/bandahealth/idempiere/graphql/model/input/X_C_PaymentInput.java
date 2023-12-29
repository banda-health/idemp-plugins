package org.bandahealth.idempiere.graphql.model.input;

import java.math.BigDecimal;
import org.bandahealth.idempiere.base.model.MBHVisit;
import org.bandahealth.idempiere.base.model.MBPartner_BH;
import org.bandahealth.idempiere.base.model.MBankAccount_BH;
import org.bandahealth.idempiere.base.model.MCharge_BH;
import org.bandahealth.idempiere.base.model.MDocType_BH;
import org.bandahealth.idempiere.base.model.MInvoice_BH;
import org.bandahealth.idempiere.base.model.MOrder_BH;
import org.bandahealth.idempiere.base.model.MPayment_BH;
import org.bandahealth.idempiere.graphql.utils.ModelUtil;
import org.compiere.model.MActivity;
import org.compiere.model.MBPBankAccount;
import org.compiere.model.MCampaign;
import org.compiere.model.MCashBook;
import org.compiere.model.MConversionType;
import org.compiere.model.MCurrency;
import org.compiere.model.MDepositBatch;
import org.compiere.model.MElementValue;
import org.compiere.model.MOrg;
import org.compiere.model.MPaymentBatch;
import org.compiere.model.MPaymentProcessor;
import org.compiere.model.MProject;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.model.X_C_POSTenderType;
import org.compiere.model.X_C_Payment;
import org.compiere.util.Env;

/**
 * Generated Model for C_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentInput extends X_C_Payment implements I_C_PaymentInput {

	 private I_AD_OrgInput AD_Org;
	 private I_AD_Ref_ListInput CreditCardType_RL;
	 private I_AD_Ref_ListInput DocAction_RL;
	 private I_AD_Ref_ListInput DocStatus_RL;
	 private I_AD_Ref_ListInput R_AvsAddr_RL;
	 private I_AD_Ref_ListInput R_AvsZip_RL;
	 private I_AD_Ref_ListInput TenderType_RL;
	 private I_AD_Ref_ListInput TrxType_RL;
	 private I_BH_VisitInput BH_Visit;
	 private I_C_ActivityInput C_Activity;
	 private I_C_BP_BankAccountInput C_BP_BankAccount;
	 private I_C_BPartnerInput C_BPartner;
	 private I_C_BankAccountInput C_BankAccount;
	 private I_C_CampaignInput C_Campaign;
	 private I_C_CashBookInput C_CashBook;
	 private I_C_ChargeInput C_Charge;
	 private I_C_ConversionTypeInput C_ConversionType;
	 private I_C_CurrencyInput C_Currency;
	 private I_C_DepositBatchInput C_DepositBatch;
	 private I_C_DocTypeInput C_DocType;
	 private I_C_ElementValueInput User1;
	 private I_C_ElementValueInput User2;
	 private I_C_InvoiceInput C_Invoice;
	 private I_C_OrderInput C_Order;
	 private I_C_POSTenderTypeInput C_POSTenderType;
	 private I_C_PaymentBatchInput C_PaymentBatch;
	 private I_C_PaymentInput Ref_Payment;
	 private I_C_PaymentInput Reversal;
	 private I_C_PaymentProcessorInput C_PaymentProcessor;
	 private I_C_ProjectInput C_Project;

	/**
	 * Standard constructor
	 */
	public X_C_PaymentInput(String ID) {
		super(Env.getCtx(), ModelUtil.getEntityIDFromUuidOrError(null, Table_Name, ID), null);
		setID(ID);
	}

	/**
	 * Set Organization.
	 *
	 * @param AD_Org Organizational entity within client
	 */
	public void setAD_Org(I_AD_OrgInput AD_Org) {
		this.AD_Org = AD_Org;
		MOrg foreignEntity;
		if (get_ID() == 0 &&AD_Org != null &&
				(foreignEntity = new Query(getCtx(), MOrg.Table_Name, MOrg.COLUMNNAME_AD_Org_UU + "=?", get_TrxName())
						.setParameters(AD_Org.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setAD_Org_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Organization.
	 *
	 * @return Organizational entity within client
	 */
	public I_AD_OrgInput getAD_Org() {
		return AD_Org;
	}

	/**
	 * Set BH_NavButtons.
	 *
	 * @param BH_NavButtons Element to allow buttons to be displayed that trigger tab navigation
	 */
	public void setBH_NavButtons(Object BH_NavButtons) {
		set_Value(COLUMNNAME_BH_NavButtons, BH_NavButtons);
	}


	/**
	 * Get BH_NavButtons.
	 *
	 * @return Element to allow buttons to be displayed that trigger tab navigation
	 */
	public Object getBH_NavButtons() {
 		return get_Value(COLUMNNAME_BH_NavButtons);
	}


	/**
	 * Set Tender Amount.
	 *
	 * @param BH_tender_amount Tender Amount
	 */
	public void setBH_tender_amount(BigDecimal BH_tender_amount) {
		set_Value(COLUMNNAME_BH_tender_amount, BH_tender_amount);
	}


	/**
	 * Get Tender Amount.
	 *
	 * @return Tender Amount
	 */
	public BigDecimal getBH_tender_amount() {
 		BigDecimal columnValue = (BigDecimal) get_Value(COLUMNNAME_BH_tender_amount);
		if (columnValue == null) {
			return Env.ZERO;
		}
		return columnValue;
	}


	/**
	 * Set Visit.
	 *
	 * @param BH_Visit Visit
	 */
	public void setBH_Visit(I_BH_VisitInput BH_Visit) {
		this.BH_Visit = BH_Visit;
		MBHVisit foreignEntity;
		if (BH_Visit != null &&
				(foreignEntity = new Query(getCtx(), MBHVisit.Table_Name, MBHVisit.COLUMNNAME_BH_Visit_UU + "=?", get_TrxName())
						.setParameters(BH_Visit.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setBH_Visit_ID(foreignEntity.get_ID());
		} else {
			this.setBH_Visit_ID(0);
		}
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public I_BH_VisitInput getBH_Visit() {
		return BH_Visit;
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (BH_Visit_ID < 1) {
			set_Value(COLUMNNAME_BH_Visit_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_Visit_ID, BH_Visit_ID);
		}
	}


	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public int getBH_Visit_ID() {
 		Integer columnValue = (Integer) get_Value(COLUMNNAME_BH_Visit_ID);
		if (columnValue == null) {
			return 0;
		}
		return columnValue;
	}


	/**
	 * Set Activity.
	 *
	 * @param C_Activity Business Activity
	 */
	public void setC_Activity(I_C_ActivityInput C_Activity) {
		this.C_Activity = C_Activity;
		MActivity foreignEntity;
		if (C_Activity != null &&
				(foreignEntity = new Query(getCtx(), MActivity.Table_Name, MActivity.COLUMNNAME_C_Activity_UU + "=?", get_TrxName())
						.setParameters(C_Activity.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Activity_ID(foreignEntity.get_ID());
		} else {
			this.setC_Activity_ID(0);
		}
	}

	/**
	 * Get Activity.
	 *
	 * @return Business Activity
	 */
	public I_C_ActivityInput getC_Activity() {
		return C_Activity;
	}

	/**
	 * Set Bank Account.
	 *
	 * @param C_BankAccount Account at the Bank
	 */
	public void setC_BankAccount(I_C_BankAccountInput C_BankAccount) {
		this.C_BankAccount = C_BankAccount;
		MBankAccount_BH foreignEntity;
		if (C_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBankAccount_BH.Table_Name, MBankAccount_BH.COLUMNNAME_C_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BankAccount_ID(foreignEntity.get_ID());
		} else {
			this.setC_BankAccount_ID(0);
		}
	}

	/**
	 * Get Bank Account.
	 *
	 * @return Account at the Bank
	 */
	public I_C_BankAccountInput getC_BankAccount() {
		return C_BankAccount;
	}

	/**
	 * Set Partner Bank Account.
	 *
	 * @param C_BP_BankAccount Bank Account of the Business Partner
	 */
	public void setC_BP_BankAccount(I_C_BP_BankAccountInput C_BP_BankAccount) {
		this.C_BP_BankAccount = C_BP_BankAccount;
		MBPBankAccount foreignEntity;
		if (C_BP_BankAccount != null &&
				(foreignEntity = new Query(getCtx(), MBPBankAccount.Table_Name, MBPBankAccount.COLUMNNAME_C_BP_BankAccount_UU + "=?", get_TrxName())
						.setParameters(C_BP_BankAccount.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BP_BankAccount_ID(foreignEntity.get_ID());
		} else {
			this.setC_BP_BankAccount_ID(0);
		}
	}

	/**
	 * Get Partner Bank Account.
	 *
	 * @return Bank Account of the Business Partner
	 */
	public I_C_BP_BankAccountInput getC_BP_BankAccount() {
		return C_BP_BankAccount;
	}

	/**
	 * Set Business Partner .
	 *
	 * @param C_BPartner Identifies a Business Partner
	 */
	public void setC_BPartner(I_C_BPartnerInput C_BPartner) {
		this.C_BPartner = C_BPartner;
		MBPartner_BH foreignEntity;
		if (C_BPartner != null &&
				(foreignEntity = new Query(getCtx(), MBPartner_BH.Table_Name, MBPartner_BH.COLUMNNAME_C_BPartner_UU + "=?", get_TrxName())
						.setParameters(C_BPartner.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_BPartner_ID(foreignEntity.get_ID());
		} else {
			this.setC_BPartner_ID(0);
		}
	}

	/**
	 * Get Business Partner .
	 *
	 * @return Identifies a Business Partner
	 */
	public I_C_BPartnerInput getC_BPartner() {
		return C_BPartner;
	}

	/**
	 * Set Campaign.
	 *
	 * @param C_Campaign Marketing Campaign
	 */
	public void setC_Campaign(I_C_CampaignInput C_Campaign) {
		this.C_Campaign = C_Campaign;
		MCampaign foreignEntity;
		if (C_Campaign != null &&
				(foreignEntity = new Query(getCtx(), MCampaign.Table_Name, MCampaign.COLUMNNAME_C_Campaign_UU + "=?", get_TrxName())
						.setParameters(C_Campaign.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Campaign_ID(foreignEntity.get_ID());
		} else {
			this.setC_Campaign_ID(0);
		}
	}

	/**
	 * Get Campaign.
	 *
	 * @return Marketing Campaign
	 */
	public I_C_CampaignInput getC_Campaign() {
		return C_Campaign;
	}

	/**
	 * Set Cash Book.
	 *
	 * @param C_CashBook Cash Book for recording petty cash transactions
	 */
	public void setC_CashBook(I_C_CashBookInput C_CashBook) {
		this.C_CashBook = C_CashBook;
		MCashBook foreignEntity;
		if (C_CashBook != null &&
				(foreignEntity = new Query(getCtx(), MCashBook.Table_Name, MCashBook.COLUMNNAME_C_CashBook_UU + "=?", get_TrxName())
						.setParameters(C_CashBook.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_CashBook_ID(foreignEntity.get_ID());
		} else {
			this.setC_CashBook_ID(0);
		}
	}

	/**
	 * Get Cash Book.
	 *
	 * @return Cash Book for recording petty cash transactions
	 */
	public I_C_CashBookInput getC_CashBook() {
		return C_CashBook;
	}

	/**
	 * Set Charge.
	 *
	 * @param C_Charge Additional document charges
	 */
	public void setC_Charge(I_C_ChargeInput C_Charge) {
		this.C_Charge = C_Charge;
		MCharge_BH foreignEntity;
		if (C_Charge != null &&
				(foreignEntity = new Query(getCtx(), MCharge_BH.Table_Name, MCharge_BH.COLUMNNAME_C_Charge_UU + "=?", get_TrxName())
						.setParameters(C_Charge.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Charge_ID(foreignEntity.get_ID());
		} else {
			this.setC_Charge_ID(0);
		}
	}

	/**
	 * Get Charge.
	 *
	 * @return Additional document charges
	 */
	public I_C_ChargeInput getC_Charge() {
		return C_Charge;
	}

	/**
	 * Set Currency Type.
	 *
	 * @param C_ConversionType Currency Conversion Rate Type
	 */
	public void setC_ConversionType(I_C_ConversionTypeInput C_ConversionType) {
		this.C_ConversionType = C_ConversionType;
		MConversionType foreignEntity;
		if (C_ConversionType != null &&
				(foreignEntity = new Query(getCtx(), MConversionType.Table_Name, MConversionType.COLUMNNAME_C_ConversionType_UU + "=?", get_TrxName())
						.setParameters(C_ConversionType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_ConversionType_ID(foreignEntity.get_ID());
		} else {
			this.setC_ConversionType_ID(0);
		}
	}

	/**
	 * Get Currency Type.
	 *
	 * @return Currency Conversion Rate Type
	 */
	public I_C_ConversionTypeInput getC_ConversionType() {
		return C_ConversionType;
	}

	/**
	 * Set Currency.
	 *
	 * @param C_Currency The Currency for this record
	 */
	public void setC_Currency(I_C_CurrencyInput C_Currency) {
		this.C_Currency = C_Currency;
		MCurrency foreignEntity;
		if (C_Currency != null &&
				(foreignEntity = new Query(getCtx(), MCurrency.Table_Name, MCurrency.COLUMNNAME_C_Currency_UU + "=?", get_TrxName())
						.setParameters(C_Currency.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Currency_ID(foreignEntity.get_ID());
		} else {
			this.setC_Currency_ID(0);
		}
	}

	/**
	 * Get Currency.
	 *
	 * @return The Currency for this record
	 */
	public I_C_CurrencyInput getC_Currency() {
		return C_Currency;
	}

	/**
	 * Set Deposit Batch.
	 *
	 * @param C_DepositBatch Deposit Batch
	 */
	public void setC_DepositBatch(I_C_DepositBatchInput C_DepositBatch) {
		this.C_DepositBatch = C_DepositBatch;
		MDepositBatch foreignEntity;
		if (get_ID() == 0 &&C_DepositBatch != null &&
				(foreignEntity = new Query(getCtx(), MDepositBatch.Table_Name, MDepositBatch.COLUMNNAME_C_DepositBatch_UU + "=?", get_TrxName())
						.setParameters(C_DepositBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DepositBatch_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Deposit Batch.
	 *
	 * @return Deposit Batch
	 */
	public I_C_DepositBatchInput getC_DepositBatch() {
		return C_DepositBatch;
	}
	/**
	 * Set Deposit Batch.
	 *
	 * @param C_DepositBatch_ID Deposit Batch
	 */

	public void setC_DepositBatch_ID(int C_DepositBatch_ID) {
		if (get_ID() == 0) {
			super.setC_DepositBatch_ID(C_DepositBatch_ID);
		}
	}

	/**
	 * Set Document Type.
	 *
	 * @param C_DocType Document type or rules
	 */
	public void setC_DocType(I_C_DocTypeInput C_DocType) {
		this.C_DocType = C_DocType;
		MDocType_BH foreignEntity;
		if (C_DocType != null &&
				(foreignEntity = new Query(getCtx(), MDocType_BH.Table_Name, MDocType_BH.COLUMNNAME_C_DocType_UU + "=?", get_TrxName())
						.setParameters(C_DocType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_DocType_ID(foreignEntity.get_ID());
		} else {
			this.setC_DocType_ID(0);
		}
	}

	/**
	 * Get Document Type.
	 *
	 * @return Document type or rules
	 */
	public I_C_DocTypeInput getC_DocType() {
		return C_DocType;
	}

	/**
	 * Set Invoice.
	 *
	 * @param C_Invoice Invoice Identifier
	 */
	public void setC_Invoice(I_C_InvoiceInput C_Invoice) {
		this.C_Invoice = C_Invoice;
		MInvoice_BH foreignEntity;
		if (C_Invoice != null &&
				(foreignEntity = new Query(getCtx(), MInvoice_BH.Table_Name, MInvoice_BH.COLUMNNAME_C_Invoice_UU + "=?", get_TrxName())
						.setParameters(C_Invoice.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Invoice_ID(foreignEntity.get_ID());
		} else {
			this.setC_Invoice_ID(0);
		}
	}

	/**
	 * Get Invoice.
	 *
	 * @return Invoice Identifier
	 */
	public I_C_InvoiceInput getC_Invoice() {
		return C_Invoice;
	}

	/**
	 * Set Order.
	 *
	 * @param C_Order Order
	 */
	public void setC_Order(I_C_OrderInput C_Order) {
		this.C_Order = C_Order;
		MOrder_BH foreignEntity;
		if (C_Order != null &&
				(foreignEntity = new Query(getCtx(), MOrder_BH.Table_Name, MOrder_BH.COLUMNNAME_C_Order_UU + "=?", get_TrxName())
						.setParameters(C_Order.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Order_ID(foreignEntity.get_ID());
		} else {
			this.setC_Order_ID(0);
		}
	}

	/**
	 * Get Order.
	 *
	 * @return Order
	 */
	public I_C_OrderInput getC_Order() {
		return C_Order;
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
	public void setC_PaymentBatch(I_C_PaymentBatchInput C_PaymentBatch) {
		this.C_PaymentBatch = C_PaymentBatch;
		MPaymentBatch foreignEntity;
		if (C_PaymentBatch != null &&
				(foreignEntity = new Query(getCtx(), MPaymentBatch.Table_Name, MPaymentBatch.COLUMNNAME_C_PaymentBatch_UU + "=?", get_TrxName())
						.setParameters(C_PaymentBatch.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentBatch_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentBatch_ID(0);
		}
	}

	/**
	 * Get Payment Batch.
	 *
	 * @return Payment batch for EFT
	 */
	public I_C_PaymentBatchInput getC_PaymentBatch() {
		return C_PaymentBatch;
	}

	/**
	 * Set Payment Processor.
	 *
	 * @param C_PaymentProcessor Payment processor for electronic payments
	 */
	public void setC_PaymentProcessor(I_C_PaymentProcessorInput C_PaymentProcessor) {
		this.C_PaymentProcessor = C_PaymentProcessor;
		MPaymentProcessor foreignEntity;
		if (C_PaymentProcessor != null &&
				(foreignEntity = new Query(getCtx(), MPaymentProcessor.Table_Name, MPaymentProcessor.COLUMNNAME_C_PaymentProcessor_UU + "=?", get_TrxName())
						.setParameters(C_PaymentProcessor.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_PaymentProcessor_ID(foreignEntity.get_ID());
		} else {
			this.setC_PaymentProcessor_ID(0);
		}
	}

	/**
	 * Get Payment Processor.
	 *
	 * @return Payment processor for electronic payments
	 */
	public I_C_PaymentProcessorInput getC_PaymentProcessor() {
		return C_PaymentProcessor;
	}

	/**
	 * Set POS Tender Type.
	 *
	 * @param C_POSTenderType POS Tender Type
	 */
	public void setC_POSTenderType(I_C_POSTenderTypeInput C_POSTenderType) {
		this.C_POSTenderType = C_POSTenderType;
		X_C_POSTenderType foreignEntity;
		if (C_POSTenderType != null &&
				(foreignEntity = new Query(getCtx(), X_C_POSTenderType.Table_Name, X_C_POSTenderType.COLUMNNAME_C_POSTenderType_UU + "=?", get_TrxName())
						.setParameters(C_POSTenderType.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_POSTenderType_ID(foreignEntity.get_ID());
		} else {
			this.setC_POSTenderType_ID(0);
		}
	}

	/**
	 * Get POS Tender Type.
	 *
	 * @return POS Tender Type
	 */
	public I_C_POSTenderTypeInput getC_POSTenderType() {
		return C_POSTenderType;
	}

	/**
	 * Set Project.
	 *
	 * @param C_Project Financial Project
	 */
	public void setC_Project(I_C_ProjectInput C_Project) {
		this.C_Project = C_Project;
		MProject foreignEntity;
		if (C_Project != null &&
				(foreignEntity = new Query(getCtx(), MProject.Table_Name, MProject.COLUMNNAME_C_Project_UU + "=?", get_TrxName())
						.setParameters(C_Project.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setC_Project_ID(foreignEntity.get_ID());
		} else {
			this.setC_Project_ID(0);
		}
	}

	/**
	 * Get Project.
	 *
	 * @return Financial Project
	 */
	public I_C_ProjectInput getC_Project() {
		return C_Project;
	}

	/**
	 * Set Credit Card.
	 *
	 * @param CreditCardType_RL Credit Card (Visa, MC, AmEx)
	 */
	public void setCreditCardType_RL(I_AD_Ref_ListInput CreditCardType_RL) {
		this.CreditCardType_RL = CreditCardType_RL;
		MRefList foreignEntity;
		if (CreditCardType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(CreditCardType_RL.getID())
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
	public I_AD_Ref_ListInput getCreditCardType_RL() {
		return CreditCardType_RL;
	}

	/**
	 * Set Document Action.
	 *
	 * @param DocAction_RL The targeted status of the document
	 */
	public void setDocAction_RL(I_AD_Ref_ListInput DocAction_RL) {
		this.DocAction_RL = DocAction_RL;
		MRefList foreignEntity;
		if (DocAction_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocAction_RL.getID())
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
	public I_AD_Ref_ListInput getDocAction_RL() {
		return DocAction_RL;
	}

	/**
	 * Set Document Status.
	 *
	 * @param DocStatus_RL The current status of the document
	 */
	public void setDocStatus_RL(I_AD_Ref_ListInput DocStatus_RL) {
		this.DocStatus_RL = DocStatus_RL;
		MRefList foreignEntity;
		if (DocStatus_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(DocStatus_RL.getID())
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
	public I_AD_Ref_ListInput getDocStatus_RL() {
		return DocStatus_RL;
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
	 * @param R_AvsAddr_RL This address has been verified
	 */
	public void setR_AvsAddr_RL(I_AD_Ref_ListInput R_AvsAddr_RL) {
		this.R_AvsAddr_RL = R_AvsAddr_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&R_AvsAddr_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsAddr_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsAddr(foreignEntity.getValue());
		}
	}

	/**
	 * Get Address verified.
	 *
	 * @return This address has been verified
	 */
	public I_AD_Ref_ListInput getR_AvsAddr_RL() {
		return R_AvsAddr_RL;
	}

	/**
	 * Set Zip verified.
	 *
	 * @param R_AvsZip_RL The Zip Code has been verified
	 */
	public void setR_AvsZip_RL(I_AD_Ref_ListInput R_AvsZip_RL) {
		this.R_AvsZip_RL = R_AvsZip_RL;
		MRefList foreignEntity;
		if (get_ID() == 0 &&R_AvsZip_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(R_AvsZip_RL.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setR_AvsZip(foreignEntity.getValue());
		}
	}

	/**
	 * Get Zip verified.
	 *
	 * @return The Zip Code has been verified
	 */
	public I_AD_Ref_ListInput getR_AvsZip_RL() {
		return R_AvsZip_RL;
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
	public void setRef_Payment(I_C_PaymentInput Ref_Payment) {
		this.Ref_Payment = Ref_Payment;
		MPayment_BH foreignEntity;
		if (get_ID() == 0 &&Ref_Payment != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(Ref_Payment.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setRef_Payment_ID(foreignEntity.get_ID());
		}
	}

	/**
	 * Get Referenced Payment.
	 *
	 * @return Referenced Payment
	 */
	public I_C_PaymentInput getRef_Payment() {
		return Ref_Payment;
	}
	/**
	 * Set Referenced Payment.
	 *
	 * @param Ref_Payment_ID Referenced Payment
	 */

	public void setRef_Payment_ID(int Ref_Payment_ID) {
		if (get_ID() == 0) {
			super.setRef_Payment_ID(Ref_Payment_ID);
		}
	}

	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal ID of document reversal
	 */
	public void setReversal(I_C_PaymentInput Reversal) {
		this.Reversal = Reversal;
		MPayment_BH foreignEntity;
		if (Reversal != null &&
				(foreignEntity = new Query(getCtx(), MPayment_BH.Table_Name, MPayment_BH.COLUMNNAME_C_Payment_UU + "=?", get_TrxName())
						.setParameters(Reversal.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setReversal_ID(foreignEntity.get_ID());
		} else {
			this.setReversal_ID(0);
		}
	}

	/**
	 * Get Reversal ID.
	 *
	 * @return ID of document reversal
	 */
	public I_C_PaymentInput getReversal() {
		return Reversal;
	}
	/**
	 * Set Reversal ID.
	 *
	 * @param Reversal_ID ID of document reversal
	 */

	public void setReversal_ID(int Reversal_ID) {
		if (get_ID() == 0) {
			super.setReversal_ID(Reversal_ID);
		}
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
	 * @param TenderType_RL Method of Payment
	 */
	public void setTenderType_RL(I_AD_Ref_ListInput TenderType_RL) {
		this.TenderType_RL = TenderType_RL;
		MRefList foreignEntity;
		if (TenderType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TenderType_RL.getID())
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
	public I_AD_Ref_ListInput getTenderType_RL() {
		return TenderType_RL;
	}

	/**
	 * Set Transaction Type.
	 *
	 * @param TrxType_RL Type of credit card transaction
	 */
	public void setTrxType_RL(I_AD_Ref_ListInput TrxType_RL) {
		this.TrxType_RL = TrxType_RL;
		MRefList foreignEntity;
		if (TrxType_RL != null &&
				(foreignEntity = new Query(getCtx(), MRefList.Table_Name, MRefList.COLUMNNAME_AD_Ref_List_UU + "=?", get_TrxName())
						.setParameters(TrxType_RL.getID())
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
	public I_AD_Ref_ListInput getTrxType_RL() {
		return TrxType_RL;
	}

	/**
	 * Set User Element List 1.
	 *
	 * @param User1 User defined list element #1
	 */
	public void setUser1(I_C_ElementValueInput User1) {
		this.User1 = User1;
		MElementValue foreignEntity;
		if (User1 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User1.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser1_ID(foreignEntity.get_ID());
		} else {
			this.setUser1_ID(0);
		}
	}

	/**
	 * Get User Element List 1.
	 *
	 * @return User defined list element #1
	 */
	public I_C_ElementValueInput getUser1() {
		return User1;
	}
	/**
	 * Set User Element List 1.
	 *
	 * @param User1_ID User defined list element #1
	 */

	public void setUser1_ID(int User1_ID) {
		if (get_ID() == 0) {
			super.setUser1_ID(User1_ID);
		}
	}

	/**
	 * Set User Element List 2.
	 *
	 * @param User2 User defined list element #2
	 */
	public void setUser2(I_C_ElementValueInput User2) {
		this.User2 = User2;
		MElementValue foreignEntity;
		if (User2 != null &&
				(foreignEntity = new Query(getCtx(), MElementValue.Table_Name, MElementValue.COLUMNNAME_C_ElementValue_UU + "=?", get_TrxName())
						.setParameters(User2.getID())
						.first()) != null && foreignEntity.get_ID() != 0) {
			this.setUser2_ID(foreignEntity.get_ID());
		} else {
			this.setUser2_ID(0);
		}
	}

	/**
	 * Get User Element List 2.
	 *
	 * @return User defined list element #2
	 */
	public I_C_ElementValueInput getUser2() {
		return User2;
	}
	/**
	 * Set User Element List 2.
	 *
	 * @param User2_ID User defined list element #2
	 */

	public void setUser2_ID(int User2_ID) {
		if (get_ID() == 0) {
			super.setUser2_ID(User2_ID);
		}
	}
}
