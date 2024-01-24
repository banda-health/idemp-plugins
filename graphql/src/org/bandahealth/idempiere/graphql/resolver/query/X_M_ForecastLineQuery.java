package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MForecastLine;

/**
 * Generated Query Resolver for M_ForecastLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_M_ForecastLineQuery extends POQuery<MForecastLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MForecastLine.Table_Name;
	}

	public Connection<MForecastLine> M_ForecastLineGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
