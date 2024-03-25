package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_I_Payment;

/**
 * Generated Query Resolver for I_Payment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_PaymentQuery extends POQuery<X_I_Payment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_Payment.Table_Name;
	}

	public Connection<X_I_Payment> I_PaymentGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
