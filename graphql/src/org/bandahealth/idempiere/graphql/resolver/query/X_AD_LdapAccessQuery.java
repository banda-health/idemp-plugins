package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLdapAccess;

/**
 * Generated Query Resolver for AD_LdapAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_LdapAccessQuery extends POQuery<MLdapAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLdapAccess.Table_Name;
	}

	public Connection<MLdapAccess> AD_LdapAccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
