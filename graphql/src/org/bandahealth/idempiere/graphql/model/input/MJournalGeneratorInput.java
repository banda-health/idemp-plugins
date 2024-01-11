package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MJournalGeneratorInput extends X_GL_JournalGeneratorInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MJournalGeneratorInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
