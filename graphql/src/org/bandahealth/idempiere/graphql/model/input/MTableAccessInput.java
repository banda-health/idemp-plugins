package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTableAccessInput extends X_AD_Table_AccessInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Table_Access_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTableAccessInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
