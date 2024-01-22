package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentProcessor;

/**
 * Generated Query Resolver for C_PaymentProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_PaymentProcessorQuery extends POQuery<MPaymentProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentProcessor.Table_Name;
	}

	public Connection<MPaymentProcessor> C_PaymentProcessorGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
