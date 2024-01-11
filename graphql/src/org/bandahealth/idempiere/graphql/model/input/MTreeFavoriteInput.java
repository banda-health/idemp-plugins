package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTreeFavoriteInput extends X_AD_Tree_FavoriteInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTreeFavoriteInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
