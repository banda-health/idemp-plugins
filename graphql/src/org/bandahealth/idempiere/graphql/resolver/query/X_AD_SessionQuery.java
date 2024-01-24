package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSession;

/**
 * Generated Query Resolver for AD_Session - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_SessionQuery extends POQuery<MSession> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSession.Table_Name;
	}

	public Connection<MSession> AD_SessionGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
