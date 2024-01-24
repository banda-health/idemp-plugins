package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_POSPayment;

/**
 * Generated Query Resolver for C_POSPayment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_POSPaymentQuery extends POQuery<X_C_POSPayment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_POSPayment.Table_Name;
	}

	public Connection<X_C_POSPayment> C_POSPaymentGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
