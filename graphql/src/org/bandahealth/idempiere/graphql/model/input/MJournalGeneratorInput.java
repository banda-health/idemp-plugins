package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MJournalGeneratorInput extends X_GL_JournalGeneratorInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_JournalGenerator_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MJournalGeneratorInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
