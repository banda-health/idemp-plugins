package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MViewColumnInput extends X_AD_ViewColumnInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ViewColumn_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MViewColumnInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
