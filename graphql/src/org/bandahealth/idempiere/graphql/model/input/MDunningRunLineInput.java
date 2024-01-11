package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MDunningRunLineInput extends X_C_DunningRunLineInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MDunningRunLineInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
