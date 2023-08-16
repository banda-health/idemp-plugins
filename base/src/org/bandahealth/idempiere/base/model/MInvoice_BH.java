package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInvoice;
import org.compiere.model.MOrder;
import org.compiere.model.MTable;
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

	public I_BH_Visit getBH_Visit() throws RuntimeException
	{
		return (I_BH_Visit) MTable.get(getCtx(), I_BH_Visit.Table_Name)
				.getPO(getBH_Visit_ID(), get_TrxName());	}

	/** Set Visit.
	 @param BH_Visit_ID Visit	  */
	public void setBH_Visit_ID (int BH_Visit_ID)
	{
		if (BH_Visit_ID < 1)
			set_Value (COLUMNNAME_BH_Visit_ID, null);
		else
			set_Value (COLUMNNAME_BH_Visit_ID, Integer.valueOf(BH_Visit_ID));
	}

	/** Get Visit.
	 @return Visit	  */
	public int getBH_Visit_ID ()
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_BH_Visit_ID);
		if (ii == null)
			return 0;
		return ii.intValue();
	}
}
