package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.compiere.model.MRefList;
import org.compiere.model.Query;
import org.compiere.util.Env;

import java.util.Optional;

public class X_AD_Ref_ListInput extends MRefList implements I_AD_Ref_ListInput {

	public X_AD_Ref_ListInput() {
		super(Env.getCtx(), 0, null);
	}

	public X_AD_Ref_ListInput(@JsonProperty("ID") String ID) {
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
