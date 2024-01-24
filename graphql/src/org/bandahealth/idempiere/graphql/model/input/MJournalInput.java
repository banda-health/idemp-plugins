package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MJournalInput extends X_GL_JournalInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_Journal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MJournalInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
