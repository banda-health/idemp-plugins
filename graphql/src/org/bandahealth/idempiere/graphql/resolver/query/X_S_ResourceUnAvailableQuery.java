package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceUnAvailable;

/**
 * Generated Query Resolver for S_ResourceUnAvailable - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceUnAvailableQuery extends POQuery<MResourceUnAvailable> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceUnAvailable.Table_Name;
	}

	public Connection<MResourceUnAvailable> S_ResourceUnAvailableGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
