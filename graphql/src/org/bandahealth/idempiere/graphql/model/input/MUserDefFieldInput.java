package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefFieldInput extends X_AD_UserDef_FieldInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Field_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserDefFieldInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
