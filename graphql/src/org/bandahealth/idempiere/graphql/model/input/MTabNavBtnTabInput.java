package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTabNavBtnTabInput extends X_BH_TabNavBtn_TabInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The BH_TabNavBtn_Tab_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTabNavBtnTabInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
