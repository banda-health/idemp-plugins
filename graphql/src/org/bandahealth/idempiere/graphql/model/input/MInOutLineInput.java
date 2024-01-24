package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MInOutLineInput extends X_M_InOutLineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_InOutLine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MInOutLineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
