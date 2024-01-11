package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentTransaction;

/**
 * Generated Query Resolver for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentTransactionQuery extends POQuery<MPaymentTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentTransaction.Table_Name;
	}

	public Connection<MPaymentTransaction> C_PaymentTransactionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
