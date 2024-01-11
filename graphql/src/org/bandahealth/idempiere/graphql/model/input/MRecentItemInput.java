package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MRecentItemInput extends X_AD_RecentItemInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MRecentItemInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
