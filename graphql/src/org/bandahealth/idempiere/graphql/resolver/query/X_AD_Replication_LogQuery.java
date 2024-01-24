package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplicationLog;

/**
 * Generated Query Resolver for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_LogQuery extends POQuery<MReplicationLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationLog.Table_Name;
	}

	public Connection<MReplicationLog> AD_Replication_LogGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
