package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MPOSTerminalInput extends X_U_POSTerminalInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The U_POSTerminal_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MPOSTerminalInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
