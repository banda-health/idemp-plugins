package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecogService;

/**
 * Generated Query Resolver for C_RevenueRecog_Service - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_RevenueRecog_ServiceQuery extends POQuery<MRevenueRecogService> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecogService.Table_Name;
	}

	public Connection<MRevenueRecogService> C_RevenueRecog_ServiceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
