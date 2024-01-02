package org.bandahealth.idempiere.base.model;

import org.compiere.model.MInvoice;
import org.compiere.model.MInvoiceLine;

import java.sql.ResultSet;
import java.util.Properties;

public class MInvoiceLine_BH extends MInvoiceLine {

	/**
	 * Column name BH_NavButtons
	 */
	public static final String COLUMNNAME_BH_NavButtons = "BH_NavButtons";

	public MInvoiceLine_BH(Properties ctx, int C_InvoiceLine_ID, String trxName) {
		super(ctx, C_InvoiceLine_ID, trxName);
	}

	public MInvoiceLine_BH(MInvoice invoice) {
		super(invoice);
	}

	public MInvoiceLine_BH(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
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
}
