package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MMessageInput extends X_AD_MessageInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Message_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MMessageInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
