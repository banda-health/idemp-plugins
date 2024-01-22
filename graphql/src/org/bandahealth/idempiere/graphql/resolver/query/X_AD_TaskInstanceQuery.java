package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_AD_TaskInstance;

/**
 * Generated Query Resolver for AD_TaskInstance - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_TaskInstanceQuery extends POQuery<X_AD_TaskInstance> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_AD_TaskInstance.Table_Name;
	}

	public Connection<X_AD_TaskInstance> AD_TaskInstanceGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
