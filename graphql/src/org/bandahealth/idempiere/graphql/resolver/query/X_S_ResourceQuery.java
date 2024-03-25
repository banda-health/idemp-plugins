package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MResource;

/**
 * Generated Query Resolver for S_Resource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_S_ResourceQuery extends POQuery<MResource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MResource.Table_Name;
	}

	public Connection<MResource> S_ResourceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
