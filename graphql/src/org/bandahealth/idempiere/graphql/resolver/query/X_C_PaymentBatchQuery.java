package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentBatch;

/**
 * Generated Query Resolver for C_PaymentBatch - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentBatchQuery extends POQuery<MPaymentBatch> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentBatch.Table_Name;
	}

	public Connection<MPaymentBatch> C_PaymentBatchGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
