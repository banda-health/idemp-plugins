package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MBHBPartnerTagsInput extends X_BH_BPartner_TagsInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UU The BH_BPartner_Tags_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MBHBPartnerTagsInput(@JsonProperty("UU") String UU) {
		super(UU);
	}
}
