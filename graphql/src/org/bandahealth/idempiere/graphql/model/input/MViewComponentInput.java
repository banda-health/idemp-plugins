package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MViewComponentInput extends X_AD_ViewComponentInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ViewComponent_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MViewComponentInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
