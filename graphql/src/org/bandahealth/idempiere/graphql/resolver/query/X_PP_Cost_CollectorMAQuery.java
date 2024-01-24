package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Cost_CollectorMA;

/**
 * Generated Query Resolver for PP_Cost_CollectorMA - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_PP_Cost_CollectorMAQuery extends POQuery<X_PP_Cost_CollectorMA> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Cost_CollectorMA.Table_Name;
	}

	public Connection<X_PP_Cost_CollectorMA> PP_Cost_CollectorMAGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
