package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MAcctSchemaDefaultInput extends X_C_AcctSchema_DefaultInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_AcctSchema_Default_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MAcctSchemaDefaultInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
