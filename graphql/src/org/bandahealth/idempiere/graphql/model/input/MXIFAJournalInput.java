package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MXIFAJournalInput extends X_I_FAJournalInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MXIFAJournalInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
