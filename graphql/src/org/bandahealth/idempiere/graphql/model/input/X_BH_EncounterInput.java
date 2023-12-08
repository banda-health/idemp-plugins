package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MBHEncounter;
import org.bandahealth.idempiere.base.model.MBHVoidedReason;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.Optional;

public class X_BH_EncounterInput extends MBHEncounter implements I_BH_EncounterInput {

	public X_BH_EncounterInput() {
		super(Env.getCtx(), 0, null);
	}

	public X_BH_EncounterInput(@JsonProperty("ID") String ID) {
		super(Env.getCtx(), Optional.ofNullable(
						(IdObject) new Query(Env.getCtx(), Table_Name, Table_Name + "_uu=?", null).setParameters(ID).first())
				.orElse(() -> 0).get_ID(), null);
	}

	@Override
	public String getID() {
		return (String) get_Value(getUUIDColumnName());
	}

	@Override
	public void setID(String ID) {
		set_ValueOfColumn(getUUIDColumnName(), ID);
	}
}
