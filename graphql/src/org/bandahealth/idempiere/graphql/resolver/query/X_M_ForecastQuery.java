package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MForecast;

/**
 * Generated Query Resolver for M_Forecast - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ForecastQuery extends POQuery<MForecast> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MForecast.Table_Name;
	}

	public Connection<MForecast> M_ForecastGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
