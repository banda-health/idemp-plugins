package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_C_InterOrg_Acct;

/**
 * Generated Query Resolver for C_InterOrg_Acct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_InterOrg_AcctQuery extends POQuery<X_C_InterOrg_Acct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_C_InterOrg_Acct.Table_Name;
	}

	public Connection<X_C_InterOrg_Acct> C_InterOrg_AcctGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
