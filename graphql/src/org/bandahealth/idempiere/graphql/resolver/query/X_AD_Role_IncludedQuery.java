package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRoleIncluded;

/**
 * Generated Query Resolver for AD_Role_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Role_IncludedQuery extends POQuery<MRoleIncluded> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRoleIncluded.Table_Name;
	}

	public Connection<MRoleIncluded> AD_Role_IncludedGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
