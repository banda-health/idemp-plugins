package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MJournalLineInput extends X_GL_JournalLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_JournalLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MJournalLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
