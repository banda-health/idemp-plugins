package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTreeFavorite;

/**
 * Generated Query Resolver for AD_Tree_Favorite - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Tree_FavoriteQuery extends POQuery<MTreeFavorite> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTreeFavorite.Table_Name;
	}

	public Connection<MTreeFavorite> AD_Tree_FavoriteGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
