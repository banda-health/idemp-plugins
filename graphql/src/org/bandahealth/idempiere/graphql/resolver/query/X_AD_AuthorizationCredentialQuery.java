package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAuthorizationCredential;

/**
 * Generated Query Resolver for AD_AuthorizationCredential - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_AuthorizationCredentialQuery extends POQuery<MAuthorizationCredential> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAuthorizationCredential.Table_Name;
	}

	public Connection<MAuthorizationCredential> AD_AuthorizationCredentialGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
