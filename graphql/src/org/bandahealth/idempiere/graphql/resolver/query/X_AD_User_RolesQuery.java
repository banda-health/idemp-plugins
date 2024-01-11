package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MUserRoles;

/**
 * Generated Query Resolver for AD_User_Roles - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_User_RolesQuery extends POQuery<MUserRoles> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MUserRoles.Table_Name;
	}

	public Connection<MUserRoles> AD_User_RolesGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
