package org.bandahealth.idempiere.graphql.resolver.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.input.I_AD_Tree_Favorite_NodeInput;
import org.bandahealth.idempiere.graphql.model.input.X_AD_Tree_Favorite_NodeInput;
import org.compiere.model.MTreeFavoriteNode;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generated Query Resolver for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Tree_Favorite_NodeMutation extends POMutation implements GraphQLMutationResolver {
	@Override
	protected String getTableName() {
		return X_AD_Tree_Favorite_NodeInput.Table_Name;
	}

	public MTreeFavoriteNode AD_Tree_Favorite_NodeSave(I_AD_Tree_Favorite_NodeInput entity, DataFetchingEnvironment environment) {
		return (MTreeFavoriteNode) super.save((X_AD_Tree_Favorite_NodeInput) entity, environment);
	}

	public List<MTreeFavoriteNode> AD_Tree_Favorite_NodeSaveMany(List<I_AD_Tree_Favorite_NodeInput> entities, DataFetchingEnvironment environment) {
		return super.saveMany(entities.stream().map(entity -> (X_AD_Tree_Favorite_NodeInput) entity).collect(Collectors.toList()),
				environment).stream().map(entity -> (MTreeFavoriteNode) entity).collect(Collectors.toList());
	}

	public boolean AD_Tree_Favorite_NodeDelete(List<String> uuids, DataFetchingEnvironment environment) {
		return super.delete(uuids, environment);
	}
}
