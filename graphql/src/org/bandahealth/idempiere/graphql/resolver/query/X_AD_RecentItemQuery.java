package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRecentItem;

/**
 * Generated Query Resolver for AD_RecentItem - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RecentItemQuery extends POQuery<MRecentItem> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRecentItem.Table_Name;
	}

	public Connection<MRecentItem> AD_RecentItemGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
