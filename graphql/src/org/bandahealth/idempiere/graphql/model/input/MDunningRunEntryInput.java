package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDunningRunEntryInput extends X_C_DunningRunEntryInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDunningRunEntryInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
