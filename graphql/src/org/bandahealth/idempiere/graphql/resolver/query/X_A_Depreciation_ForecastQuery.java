package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Depreciation_Forecast;

/**
 * Generated Query Resolver for A_Depreciation_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_A_Depreciation_ForecastQuery extends POQuery<X_A_Depreciation_Forecast> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Forecast.Table_Name;
	}

	public Connection<X_A_Depreciation_Forecast> A_Depreciation_ForecastGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
