package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTreeFavoriteNodeInput extends X_AD_Tree_Favorite_NodeInput {
	/**
	 * Standard constructor
	 * 
	 * @param ID
	 */
	@JsonCreator
	public MTreeFavoriteNodeInput(@JsonProperty("ID") String ID) {
		super(ID);
	}
}
