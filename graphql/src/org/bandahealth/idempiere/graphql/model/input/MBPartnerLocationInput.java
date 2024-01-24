package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBPartnerLocationInput extends X_C_BPartner_LocationInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The C_BPartner_Location_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBPartnerLocationInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
