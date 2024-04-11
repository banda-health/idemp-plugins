package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MStatusCategoryInput extends X_R_StatusCategoryInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The R_StatusCategory_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MStatusCategoryInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
