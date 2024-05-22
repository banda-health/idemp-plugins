package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_R_GroupUpdates;

/**
 * Generated Query Resolver for R_GroupUpdates - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_GroupUpdatesQuery extends POQuery<X_R_GroupUpdates> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_R_GroupUpdates.Table_Name;
	}

	public Connection<X_R_GroupUpdates> R_GroupUpdatesGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
