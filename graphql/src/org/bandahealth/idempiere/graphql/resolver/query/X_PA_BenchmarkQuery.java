package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_Benchmark;

/**
 * Generated Query Resolver for PA_Benchmark - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_BenchmarkQuery extends POQuery<X_PA_Benchmark> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_Benchmark.Table_Name;
	}

	public Connection<X_PA_Benchmark> PA_BenchmarkGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
