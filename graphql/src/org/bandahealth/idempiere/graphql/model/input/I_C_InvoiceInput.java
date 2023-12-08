package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Invoice;

public interface I_C_InvoiceInput extends I_C_Invoice {
	String getID();

	void setID(String ID);
}
