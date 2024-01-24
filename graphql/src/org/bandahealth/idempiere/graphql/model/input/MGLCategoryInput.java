package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MGLCategoryInput extends X_GL_CategoryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The GL_Category_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MGLCategoryInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
