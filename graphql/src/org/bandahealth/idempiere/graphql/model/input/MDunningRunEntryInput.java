package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDunningRunEntryInput extends X_C_DunningRunEntryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_DunningRunEntry_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MDunningRunEntryInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
