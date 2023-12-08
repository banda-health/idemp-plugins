package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_C_Order;

public interface I_C_OrderInput extends I_C_Order {
	String getID();

	void setID(String ID);
}
