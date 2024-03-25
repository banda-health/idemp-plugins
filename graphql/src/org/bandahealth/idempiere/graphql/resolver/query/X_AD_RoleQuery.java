package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_Role;

/**
 * Generated Query Resolver for AD_Role - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_RoleQuery extends POQuery<X_AD_Role> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_Role.Table_Name;
	}

	public Connection<X_AD_Role> AD_RoleGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
