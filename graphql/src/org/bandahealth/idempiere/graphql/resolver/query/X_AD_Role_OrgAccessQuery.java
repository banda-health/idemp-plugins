package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRoleOrgAccess;

/**
 * Generated Query Resolver for AD_Role_OrgAccess - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Role_OrgAccessQuery extends POQuery<MRoleOrgAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRoleOrgAccess.Table_Name;
	}

	public Connection<MRoleOrgAccess> AD_Role_OrgAccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
