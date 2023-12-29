package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Cost_Collector;

/**
 * Generated Query Resolver for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Cost_CollectorQuery extends POQuery<X_PP_Cost_Collector> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_Collector.Table_Name;
	}

	public Connection<X_PP_Cost_Collector> PP_Cost_CollectorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
