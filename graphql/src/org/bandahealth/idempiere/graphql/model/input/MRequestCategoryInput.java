package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRequestCategoryInput extends X_R_CategoryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_Category_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRequestCategoryInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
