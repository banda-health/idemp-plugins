package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MJournalGeneratorSourceInput extends X_GL_JournalGeneratorSourceInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MJournalGeneratorSourceInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
