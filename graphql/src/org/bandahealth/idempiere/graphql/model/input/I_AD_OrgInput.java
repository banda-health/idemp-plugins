package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Org;

public interface I_AD_OrgInput extends I_AD_Org {
	String getID();

	void setID(String ID);
}
