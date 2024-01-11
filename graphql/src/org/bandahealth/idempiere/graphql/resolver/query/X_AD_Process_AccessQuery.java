package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProcessAccess;

/**
 * Generated Query Resolver for AD_Process_Access - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Process_AccessQuery extends POQuery<MProcessAccess> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProcessAccess.Table_Name;
	}

	public Connection<MProcessAccess> AD_Process_AccessGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
