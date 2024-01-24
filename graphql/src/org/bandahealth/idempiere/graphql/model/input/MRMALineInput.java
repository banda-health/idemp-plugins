package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRMALineInput extends X_M_RMALineInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The M_RMALine_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRMALineInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
