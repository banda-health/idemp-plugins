package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_Tax_Acct;

/**
 * Generated Query Resolver for C_Tax_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_Tax_AcctQuery extends POQuery<X_C_Tax_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_Tax_Acct.Table_Name;
	}

	public Connection<X_C_Tax_Acct> C_Tax_AcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
