package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Cost_Collector;

/**
 * Generated Query Resolver for PP_Cost_Collector - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Cost_CollectorQuery extends POQuery<X_PP_Cost_Collector> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_Collector.Table_Name;
	}

	public Connection<X_PP_Cost_Collector> PP_Cost_CollectorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
