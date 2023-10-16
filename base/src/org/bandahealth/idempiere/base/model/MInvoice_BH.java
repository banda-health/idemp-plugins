package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;
import org.compiere.model.MOrder;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.util.DB;
import org.compiere.util.Env;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
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
	public static final String COLUMNNAME_BH_VOIDED_REASON_ID = "BH_Voided_Reason_ID";
	/**
	 * Column name BH_Visit_ID
	 */
	public static final String COLUMNNAME_BH_Visit_ID = "BH_Visit_ID";
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

	public I_BH_Visit getBH_Visit() throws RuntimeException {
		return (I_BH_Visit) MTable.get(getCtx(), I_BH_Visit.Table_Name)
				.getPO(getBH_Visit_ID(), get_TrxName());
	}

	/**
	 * Set Visit.
	 *
	 * @param BH_Visit_ID Visit
	 */
	public void setBH_Visit_ID(int BH_Visit_ID) {
		if (BH_Visit_ID < 1)
			set_Value(COLUMNNAME_BH_Visit_ID, null);
		else
			set_Value(COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/**
	 * Get Visit.
	 *
	 * @return Visit
	 */
	public int getBH_Visit_ID() {
		Integer ii = (Integer) get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}

	/**
	 * Copy the payment, typically meant to be done when a visit is reactivated and all old payments are reversed.
	 * Largely copied from
	 * {@link MInvoice#copyFrom(MInvoice, Timestamp, Timestamp, int, boolean, boolean, String, boolean, String)}
	 *
	 * @return The new, unsaved payment
	 */
	public MInvoice_BH copy() {
		MInvoice_BH newInvoice = new MInvoice_BH(getCtx(), 0, get_TrxName());
		PO.copyValues(this, newInvoice, getAD_Client_ID(), getAD_Org_ID());
		newInvoice.set_ValueNoCheck("C_Invoice_ID", I_ZERO);
		newInvoice.set_ValueNoCheck("DocumentNo", null);
		//
		newInvoice.setDocStatus(DOCSTATUS_Drafted);    //	Draft
		newInvoice.setDocAction(DOCACTION_Complete);
		//
		newInvoice.setC_DocType_ID(0);
		newInvoice.setC_DocTypeTarget_ID(getC_DocTypeTarget_ID());
		newInvoice.setIsSOTrx(isSOTrx());
		//
		newInvoice.setDateInvoiced(getDateInvoiced());
		newInvoice.setDateAcct(getDateAcct());
		newInvoice.setDatePrinted(null);
		newInvoice.setIsPrinted(false);
		//
		newInvoice.setIsApproved(false);
		newInvoice.setC_Payment_ID(0);
		newInvoice.setC_CashLine_ID(0);
		newInvoice.setIsPaid(false);
		newInvoice.setIsInDispute(false);
		//
		//	Amounts are updated by trigger when adding lines
		newInvoice.setGrandTotal(Env.ZERO);
		newInvoice.setTotalLines(Env.ZERO);
		//
		newInvoice.setIsTransferred(false);
		newInvoice.setPosted(false);
		newInvoice.setProcessed(false);
		//[ 1633721 ] Reverse Documents- Processing=Y
		newInvoice.setProcessing(false);
		//	delete references
		newInvoice.setIsSelfService(false);

		// Banda-specific fields
		newInvoice.setBH_Visit_ID(getBH_Visit_ID());

		newInvoice.saveEx();

		// Document action typically set to complete, even though we may not be completing it yet
		newInvoice.setDocAction(DOCACTION_None);

		List<MInvoiceLine> invoiceLines = Arrays.asList(getLines(true));
		invoiceLines.forEach(invoiceLine -> {
			MInvoiceLine newInvoiceLine = new MInvoiceLine(getCtx(), 0, get_TrxName());
			PO.copyValues(invoiceLine, newInvoiceLine);
			newInvoiceLine.setInvoice(newInvoice);
			newInvoiceLine.setC_Invoice_ID(newInvoice.getC_Invoice_ID());
			newInvoiceLine.setProcessed(false);
			newInvoiceLine.saveEx();

			Object[] parameters = new Object[]{newInvoiceLine.getC_InvoiceLine_ID(), invoiceLine.getC_InvoiceLine_ID()};
			DB.executeUpdate("UPDATE bh_bp_specific_payer_info SET c_invoiceline_id = ? WHERE c_invoiceline_id = ?",
					parameters, false, get_TrxName());
		});

		return newInvoice;
	}
}
