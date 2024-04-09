package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.X_PP_Order;

/**
 * Generated Query Resolver for PP_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_OrderQuery extends POQuery<X_PP_Order> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PP_Order.Table_Name;
	}

	public Connection<X_PP_Order> PP_OrderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
