package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MPInstance;

/**
 * Generated Query Resolver for AD_PInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_PInstanceQuery extends POQuery<MPInstance> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPInstance.Table_Name;
	}

	public Connection<MPInstance> AD_PInstanceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
