package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAddressTransaction;

/**
 * Generated Query Resolver for C_AddressTransaction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_AddressTransactionQuery extends POQuery<MAddressTransaction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAddressTransaction.Table_Name;
	}

	public Connection<MAddressTransaction> C_AddressTransactionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
