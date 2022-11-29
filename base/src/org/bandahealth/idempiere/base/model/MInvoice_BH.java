package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.PO;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

public class MInvoice_BH extends MInvoice {

	/**
	 * Mobile Account = A
	 */
	public static final String PAYMENTRULE_MobileAccount = "A";
	/**
	 * BH Cash Account = b
	 */
	public static final String PAYMENTRULE_BHCashAccount = "b";
	public static final String EXPENSE_InvoiceType = "e";
	public static final String INCOME_InvoiceType = "i";
	/**
	 * Column name BH_Processing
	 */
	public static final String COLUMNNAME_BH_Processing = "BH_Processing";
	public static final String COLUMNNAME_BH_VOIDED_REASON_ID = "BH_Voided_Reason_ID";
	/**
	 * Column name BH_IsExpense
	 */
	public static final String COLUMNNAME_BH_IsExpense = "BH_IsExpense";
	/**
	 * Column name BH_DocAction
	 */
	public static final String COLUMNNAME_BH_DocAction = "BH_DocAction";
	/**
	 * Column name BH_InvoiceType
	 */
	public static final String COLUMNNAME_BH_InvoiceType = "BH_InvoiceType";
	private static final long serialVersionUID = 1L;

	public MInvoice_BH(Properties ctx, int C_Invoice_ID, String trxName) {
		super(ctx, C_Invoice_ID, trxName);
	}

	public MInvoice_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MInvoice_BH(MOrder order, int C_DocTypeTarget_ID, Timestamp invoiceDate) {
		super(order, C_DocTypeTarget_ID, invoiceDate);
	}

	public MInvoice_BH(MInvoice invoice) {
		super(invoice.getCtx(), 0, invoice.get_TrxName());

		PO.copyValues(invoice, this, invoice.getAD_Client_ID(), invoice.getAD_Org_ID());
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
	 * Set BH_Processing.
	 *
	 * @param bhProcessing Whether this invoice is an expense or not
	 */
	public void setBH_Processing(boolean bhProcessing) {
		set_Value(COLUMNNAME_BH_Processing, bhProcessing);
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
	 * Set BH_IsExpense.
	 *
	 * @param bhIsExpense Whether this invoice is an expense or not
	 */
	public void setBH_IsExpense(boolean bhIsExpense) {
		set_Value(COLUMNNAME_BH_IsExpense, bhIsExpense);
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
	 * Set BH_DocAction.
	 *
	 * @param bhDocAction Get the code-set value of the doc action (not used in UI anywhere)
	 */
	public void setBH_DocAction(String bhDocAction) {
		set_Value(COLUMNNAME_BH_DocAction, bhDocAction);
	}

	/**
	 * Get BH_InvoiceType.
	 *
	 * @return BH_InvoiceType
	 */
	public String getBH_InvoiceType() {
		return (String) get_Value(COLUMNNAME_BH_InvoiceType);
	}

	/**
	 * Set BH_InvoiceType.
	 *
	 * @param invoiceType
	 */
	public void setBH_InvoiceType(String invoiceType) {
		set_Value(COLUMNNAME_BH_InvoiceType, invoiceType);
	}

	public int getBH_VoidedReasonID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_VOIDED_REASON_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	public void setBH_VoidedReasonID(int BH_VoidedReason_ID) {
		if (BH_VoidedReason_ID < 1) {
			set_Value(COLUMNNAME_BH_VOIDED_REASON_ID, null);
		} else {
			set_Value(COLUMNNAME_BH_VOIDED_REASON_ID, Integer.valueOf(BH_VoidedReason_ID));
		}
	}
}
