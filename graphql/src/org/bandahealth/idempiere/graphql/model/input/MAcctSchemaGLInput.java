package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctSchemaGLInput extends X_C_AcctSchema_GLInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MAcctSchemaGLInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
