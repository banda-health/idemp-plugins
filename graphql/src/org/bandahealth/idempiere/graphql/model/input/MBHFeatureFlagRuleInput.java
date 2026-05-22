package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHFeatureFlagRuleInput extends X_BH_Feature_Flag_RuleInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Feature_Flag_Rule_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHFeatureFlagRuleInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}
