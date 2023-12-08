package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Payment;

public interface I_C_PaymentInput extends I_C_Payment {
	String getID();

	void setID(String ID);
}
