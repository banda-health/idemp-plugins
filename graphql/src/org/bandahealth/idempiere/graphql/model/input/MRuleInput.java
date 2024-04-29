package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRuleInput extends X_AD_RuleInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Rule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRuleInput(@JsonProperty("UU") String UUID) {
		super(UUID);
	}
}
