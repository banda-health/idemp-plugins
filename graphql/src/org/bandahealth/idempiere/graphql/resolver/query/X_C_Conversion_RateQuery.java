package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MConversionRate;

/**
 * Generated Query Resolver for C_Conversion_Rate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_Conversion_RateQuery extends POQuery<MConversionRate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MConversionRate.Table_Name;
	}

	public Connection<MConversionRate> C_Conversion_RateGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
