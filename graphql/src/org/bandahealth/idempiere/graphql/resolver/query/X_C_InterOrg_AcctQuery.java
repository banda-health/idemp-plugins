package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_InterOrg_Acct;

/**
 * Generated Query Resolver for C_InterOrg_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_InterOrg_AcctQuery extends POQuery<X_C_InterOrg_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_InterOrg_Acct.Table_Name;
	}

	public Connection<X_C_InterOrg_Acct> C_InterOrg_AcctGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
