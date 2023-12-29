package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentBatch;

/**
 * Generated Query Resolver for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_PaymentBatchQuery extends POQuery<MPaymentBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentBatch.Table_Name;
	}

	public Connection<MPaymentBatch> C_PaymentBatchGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
