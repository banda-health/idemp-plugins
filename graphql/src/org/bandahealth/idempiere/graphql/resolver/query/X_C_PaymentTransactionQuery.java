package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentTransaction;

/**
 * Generated Query Resolver for C_PaymentTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentTransactionQuery extends POQuery<MPaymentTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentTransaction.Table_Name;
	}

	public Connection<MPaymentTransaction> C_PaymentTransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
