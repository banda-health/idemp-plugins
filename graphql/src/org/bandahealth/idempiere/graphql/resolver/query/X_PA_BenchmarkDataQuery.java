package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_BenchmarkData;

/**
 * Generated Query Resolver for PA_BenchmarkData - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PA_BenchmarkDataQuery extends POQuery<X_PA_BenchmarkData> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_BenchmarkData.Table_Name;
	}

	public Connection<X_PA_BenchmarkData> PA_BenchmarkDataGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
