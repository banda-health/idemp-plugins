package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MUserDefInfoRelatedInput extends X_AD_UserDef_Info_RelatedInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_UserDef_Info_Related_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MUserDefInfoRelatedInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
