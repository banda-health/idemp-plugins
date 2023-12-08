package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_User;

public interface I_AD_UserInput extends I_AD_User {
	String getID();

	void setID(String ID);
}
