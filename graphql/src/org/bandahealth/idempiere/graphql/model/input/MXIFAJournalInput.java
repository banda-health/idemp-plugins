package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MXIFAJournalInput extends X_I_FAJournalInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The I_FAJournal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MXIFAJournalInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
