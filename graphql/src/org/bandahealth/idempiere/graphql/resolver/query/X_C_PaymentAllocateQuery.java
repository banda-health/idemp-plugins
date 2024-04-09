package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPaymentAllocate;

/**
 * Generated Query Resolver for C_PaymentAllocate - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_PaymentAllocateQuery extends POQuery<MPaymentAllocate> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPaymentAllocate.Table_Name;
	}

	public Connection<MPaymentAllocate> C_PaymentAllocateGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
