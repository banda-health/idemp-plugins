package org.bandahealth.idempiere.graphql.model.input;

import org.bandahealth.idempiere.base.model.I_BH_Encounter;
import org.compiere.model.I_AD_Org;

public interface I_BH_EncounterInput extends I_BH_Encounter {
	String getID();

	void setID(String ID);
}
