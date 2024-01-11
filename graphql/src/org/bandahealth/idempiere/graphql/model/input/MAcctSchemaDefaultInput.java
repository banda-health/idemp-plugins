package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctSchemaDefaultInput extends X_C_AcctSchema_DefaultInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAcctSchemaDefaultInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
