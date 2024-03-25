package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_CashBook_Acct;

/**
 * Generated Query Resolver for C_CashBook_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashBook_AcctQuery extends POQuery<X_C_CashBook_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_CashBook_Acct.Table_Name;
	}

	public Connection<X_C_CashBook_Acct> C_CashBook_AcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
