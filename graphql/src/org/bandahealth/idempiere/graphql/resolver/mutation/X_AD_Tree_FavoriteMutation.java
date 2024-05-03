package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Tree_FavoriteInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Tree_FavoriteInput;
import org.compiere.model.MTreeFavorite;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Tree_Favorite - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Tree_FavoriteMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Tree_FavoriteInput.Table_Name;
	}

	public MTreeFavorite AD_Tree_FavoriteSave(I_AD_Tree_FavoriteInput Entity, DataFetchingEnvironment environment) {
		return (MTreeFavorite) super.save((X_AD_Tree_FavoriteInput) Entity, environment);
	}

	public List<MTreeFavorite> AD_Tree_FavoriteSaveMany(List<I_AD_Tree_FavoriteInput> Entities, DataFetchingEnvironment environment) {
		return super.saveMany(Entities.stream().map(entity -> (X_AD_Tree_FavoriteInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTreeFavorite) entity).collect(Collectors.toList());
	}

	public boolean AD_Tree_FavoriteDelete(List<String> UUs, DataFetchingEnvironment environment) {
		return super.delete(UUs, environment);
	}
}
