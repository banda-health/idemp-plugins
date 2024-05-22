package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctSchemaGLInput extends X_C_AcctSchema_GLInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AcctSchema_GL_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAcctSchemaGLInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
