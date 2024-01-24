package org.bandahealth.idempiere.graphql.model.input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MTreeFavoriteInput extends X_AD_Tree_FavoriteInput {
	/**
	 * Standard constructor (don't forget to use @JsonCreator and @JsonProperty
	 * annotations from the super class since those aren't inherited)
	 *
	 * @param UUID The AD_Tree_Favorite_UU to fetch this entity from the DB
	 */
	@JsonCreator
	public MTreeFavoriteInput(@JsonProperty("UUID") String UUID) {
		super(UUID);
	}
}
