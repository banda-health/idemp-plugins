package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MLdapProcessorLogInput extends X_AD_LdapProcessorLogInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_LdapProcessorLog_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MLdapProcessorLogInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
