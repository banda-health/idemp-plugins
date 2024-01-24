package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MToolBarButtonInput extends X_AD_ToolBarButtonInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ToolBarButton_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MToolBarButtonInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
