package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Order_Cost;

/**
 * Generated Query Resolver for PP_Order_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_PP_Order_CostQuery extends POQuery<X_PP_Order_Cost> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order_Cost.Table_Name;
	}

	public Connection<X_PP_Order_Cost> PP_Order_CostGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
