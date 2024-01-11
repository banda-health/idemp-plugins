package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MJournalBatchInput extends X_GL_JournalBatchInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MJournalBatchInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
