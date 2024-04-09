package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_RequestTypeUpdates;

/**
 * Generated Query Resolver for R_RequestTypeUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestTypeUpdatesQuery extends POQuery<X_R_RequestTypeUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_RequestTypeUpdates.Table_Name;
	}

	public Connection<X_R_RequestTypeUpdates> R_RequestTypeUpdatesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
