package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MWebPropertiesInput extends X_U_Web_PropertiesInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The U_Web_Properties_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MWebPropertiesInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
