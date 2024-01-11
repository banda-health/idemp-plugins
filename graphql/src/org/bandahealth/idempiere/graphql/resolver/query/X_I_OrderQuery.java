package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Order;

/**
 * Generated Query Resolver for I_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_I_OrderQuery extends POQuery<X_I_Order> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Order.Table_Name;
	}

	public Connection<X_I_Order> I_OrderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
