package org.bandahealth.idempiere.base.model;

import org.compiere.model.MBankAccount;
import org.compiere.model.MDocType;
import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.DocAction;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MInvoice_BH extends MInvoice {
	
	private static final long serialVersionUID = 1L;

	/** Mobile Account = A */
	public static final String PAYMENTRULE_MobileAccount = "A";

	/**
	 * Column name BH_Processing
	 */
	public static final String COLUMNNAME_BH_Processing = "BH_Processing";

	/**
	 * Set BH_Processing.
	 *
	 * @param bhProcessing Whether this invoice is an expense or not
	 */
	public void setBH_Processing(boolean bhProcessing) {
		set_Value(COLUMNNAME_BH_Processing, bhProcessing);
	}

	/**
	 * Get BH_Processing.
	 *
	 * @return BH_Processing
	 */
	public boolean getBH_Processing() {
		Object bhProcessing = get_Value(COLUMNNAME_BH_Processing);
		if (bhProcessing == null) {
			return false;
		}
		return (boolean) bhProcessing;
	}

	/**
	 * Column name BH_IsExpense
	 */
	public static final String COLUMNNAME_BH_IsExpense = "BH_IsExpense";

	/**
	 * Set BH_IsExpense.
	 *
	 * @param bhIsExpense Whether this invoice is an expense or not
	 */
	public void setBH_IsExpense(boolean bhIsExpense) {
		set_Value(COLUMNNAME_BH_IsExpense, bhIsExpense);
	}

	/**
	 * Get BH_IsExpense.
	 *
	 * @return BH_IsExpense
	 */
	public boolean getBH_IsExpense() {
		Object bhIsExpense = get_Value(COLUMNNAME_BH_IsExpense);
		if (bhIsExpense == null) {
			return false;
		}
		return (boolean) bhIsExpense;
	}

	/**
	 * Column name BH_DocAction
	 */
	public static final String COLUMNNAME_BH_DocAction = "BH_DocAction";

	/**
	 * Set BH_DocAction.
	 *
	 * @param bhDocAction Get the code-set value of the doc action (not used in UI anywhere)
	 */
	public void setBH_DocAction(String bhDocAction) {
		set_Value(COLUMNNAME_BH_DocAction, bhDocAction);
	}

	/**
	 * Get BH_DocAction.
	 *
	 * @return BH_DocAction
	 */
	public String getBH_DocAction() {
		return (String) get_Value(COLUMNNAME_BH_DocAction);
	}

	/**
	 * 	Get Process Message
	 *	@return clear text error message
	 */
	@Override
	public String getProcessMsg()
	{
		return super.getProcessMsg();
	}	//	getProcessMsg

	/**
	 * Set process message
	 * @param processMsg
	 */
	@Override
	public void setProcessMessage(String processMsg)
	{
		super.setProcessMessage(processMsg);
	}

	public MInvoice_BH(Properties ctx, int C_Invoice_ID, String trxName) {
		super(ctx, C_Invoice_ID, trxName);
	}
	
	public MInvoice_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	public MInvoice_BH(MOrder order, int C_DocTypeTarget_ID, Timestamp invoiceDate) {
		super(order, C_DocTypeTarget_ID, invoiceDate);
	}
	
	/**
	 * 	Complete Document
	 * 	@return new status (Complete, In Progress, Invalid, Waiting ..)
	 */
	@Override
	public String completeIt() {
		StringBuilder info = new StringBuilder();
		// Only do any additional logic if their not paying via cash
		if (getBH_IsExpense()) {
			//	Create Payment if not paying via Cash
			if (PAYMENTRULE_MobileAccount.equals(getPaymentRule())) {
				String createMobilePaymentStatus = createMobilePayment(info);
				if (!createMobilePaymentStatus.equals(DocAction.ACTION_Complete)) {
					return createMobilePaymentStatus;
				}
			}
		}
		String docStatus = super.completeIt();
		info.append(getProcessMsg());
		setProcessMessage(info.toString());
		return docStatus;
	}
	
	/**
	 * Create a payment for the expenses using a mobile account
	 * This was copied from MInvoice.java with some slight modifications
	 */
	private String createMobilePayment(StringBuilder info) {
		// First, get the accounts that can be used with this payment
		String whereClause = "AD_Org_ID=? AND C_Currency_ID=?";
		MBankAccount defaultBankAccount = new Query(getCtx(),MBankAccount.Table_Name,whereClause,get_TrxName())
				.setParameters(getAD_Org_ID(), getC_Currency_ID())
				.setOnlyActiveRecords(true)
				.setOrderBy("IsDefault DESC")
				.first();
		whereClause = "AD_Org_ID=? AND C_Currency_ID=? AND " + MBankAccount.COLUMNNAME_BankAccountType + "=?";
		MBankAccount mobileBankAccount = new Query(getCtx(),MBankAccount.Table_Name,whereClause,get_TrxName())
				.setParameters(
						getAD_Org_ID(),
						getC_Currency_ID(),
						MBankAccount_BH.BANKACCOUNTTYPE_Mobile
				)
				.setOnlyActiveRecords(true)
				.first();
		// If no accounts, we have a problem
		if (mobileBankAccount == null && defaultBankAccount == null) {
			setProcessMessage("@NoAccountOrgCurrency@");
			return DocAction.STATUS_Invalid;
		}
		// We should only ever come this route if paying by mobile, so prefer that, if an account exists
		MBankAccount bankAccountToUse = mobileBankAccount;
		if (mobileBankAccount == null) {
			bankAccountToUse = defaultBankAccount;
		}

		// Since we're dealing with expenses, they'll only be AP Payments
		String docBaseType = MDocType.DOCBASETYPE_APPayment;

		MDocType[] doctypes = MDocType.getOfDocBaseType(getCtx(), docBaseType);
		if (doctypes == null || doctypes.length == 0) {
			setProcessMessage("No document type ");
			return DocAction.STATUS_Invalid;
		}
		MDocType doctype = null;
		for (MDocType doc : doctypes) {
			if (doc.getAD_Org_ID() == this.getAD_Org_ID()) {
				doctype = doc;
				break;
			}
		}
		if (doctype == null) {
			doctype = doctypes[0];
		}

		// Create the payment
		MPayment_BH payment = new MPayment_BH(getCtx(), 0, get_TrxName());
		payment.setAD_Org_ID(getAD_Org_ID());
		payment.setTenderType(MPayment_BH.TENDERTYPE_MPesa);
		payment.setC_BankAccount_ID(bankAccountToUse.getC_BankAccount_ID());
		payment.setC_BPartner_ID(getC_BPartner_ID());
		payment.setC_Invoice_ID(getC_Invoice_ID());
		payment.setC_Currency_ID(getC_Currency_ID());
		payment.setC_DocType_ID(doctype.getC_DocType_ID());
		if (isCreditMemo()) {
			payment.setPayAmt(getGrandTotal().negate());
		} else {
			payment.setPayAmt(getGrandTotal());
		}
		payment.setIsPrepayment(false);
		payment.setDateAcct(getDateAcct());
		payment.setDateTrx(getDateInvoiced());

		//	Save payment
		payment.saveEx();

		payment.setDocAction(MPayment_BH.DOCACTION_Complete);
		if (!payment.processIt(MPayment_BH.DOCACTION_Complete)) {
			setProcessMessage("Cannot Complete the Payment : [" + payment.getProcessMsg() + "] " + payment);
			return DocAction.STATUS_Invalid;
		}

		payment.saveEx();
		info.append("@C_Payment_ID@: " + payment.getDocumentInfo());

		// IDEMPIERE-2588 - add the allocation generation with the payment
		if (payment.getJustCreatedAllocInv() != null) {
			addDocsPostProcess(payment.getJustCreatedAllocInv());
		}

		testAllocation(true);

		return DocAction.ACTION_Complete;
	}

	/**
	 * Copied from MInvoice.java
	 * @param doc
	 */
	private void addDocsPostProcess(PO doc) {
		getDocsPostProcess().add(doc);
	}
}
