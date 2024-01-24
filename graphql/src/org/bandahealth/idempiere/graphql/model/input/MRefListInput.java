package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRefListInput extends X_AD_Ref_ListInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Ref_List_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MRefListInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
