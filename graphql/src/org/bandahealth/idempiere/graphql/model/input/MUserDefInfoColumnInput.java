package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefInfoColumnInput extends X_AD_UserDef_Info_ColumnInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MUserDefInfoColumnInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
