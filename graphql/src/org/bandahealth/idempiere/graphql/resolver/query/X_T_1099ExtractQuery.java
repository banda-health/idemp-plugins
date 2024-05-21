package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_T_1099Extract;

/**
 * Generated Query Resolver for T_1099Extract - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_T_1099ExtractQuery extends POQuery<X_T_1099Extract> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_T_1099Extract.Table_Name;
	}

	public Connection<X_T_1099Extract> T_1099ExtractGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
