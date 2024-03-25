package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResourceType;

/**
 * Generated Query Resolver for S_ResourceType - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceTypeQuery extends POQuery<MResourceType> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResourceType.Table_Name;
	}

	public Connection<MResourceType> S_ResourceTypeGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
