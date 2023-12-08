package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Client;

public interface I_AD_ClientInput extends I_AD_Client {
	String getID();

	void setID(String ID);
}
