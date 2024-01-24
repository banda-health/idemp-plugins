package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MToolBarButtonRestrictInput extends X_AD_ToolBarButtonRestrictInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_ToolBarButtonRestrict_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MToolBarButtonRestrictInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
