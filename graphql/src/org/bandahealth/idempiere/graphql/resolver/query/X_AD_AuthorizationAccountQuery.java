package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAuthorizationAccount;

/**
 * Generated Query Resolver for AD_AuthorizationAccount - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationAccountQuery extends POQuery<MAuthorizationAccount> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAuthorizationAccount.Table_Name;
	}

	public Connection<MAuthorizationAccount> AD_AuthorizationAccountGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
