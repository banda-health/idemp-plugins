package org.bandahealth.idempiere.graphql.model.input;

import org.compiere.model.I_AD_Ref_List;

public interface I_AD_Ref_ListInput extends I_AD_Ref_List {
	String getID();

	void setID(String ID);
}
