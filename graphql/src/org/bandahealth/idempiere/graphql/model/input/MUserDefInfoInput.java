package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefInfoInput extends X_AD_UserDef_InfoInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Info_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserDefInfoInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
