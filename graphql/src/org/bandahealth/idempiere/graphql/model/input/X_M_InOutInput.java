package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bandahealth.idempiere.base.model.MInOut_BH;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.Optional;

public class X_M_InOutInput extends MInOut_BH implements I_M_InOutInput {

	public X_M_InOutInput() {
		super(Env.getCtx(), 0, null);
	}

	public X_M_InOutInput(@JsonProperty("ID") String ID) {
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
