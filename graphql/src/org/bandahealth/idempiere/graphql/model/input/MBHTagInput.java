package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHTagInput extends X_BH_TagInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_Tag_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHTagInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}
