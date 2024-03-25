package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTreeFavoriteNode;

/**
 * Generated Query Resolver for AD_Tree_Favorite_Node - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Tree_Favorite_NodeQuery extends POQuery<MTreeFavoriteNode> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTreeFavoriteNode.Table_Name;
	}

	public Connection<MTreeFavoriteNode> AD_Tree_Favorite_NodeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
