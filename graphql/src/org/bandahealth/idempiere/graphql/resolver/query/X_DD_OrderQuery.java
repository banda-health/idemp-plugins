package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.eevolution.model.MDDOrder;

/**
 * Generated Query Resolver for DD_Order - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_DD_OrderQuery extends POQuery<MDDOrder> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDDOrder.Table_Name;
	}

	public Connection<MDDOrder> DD_OrderGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
