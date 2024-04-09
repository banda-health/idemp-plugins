package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplicationLog;

/**
 * Generated Query Resolver for AD_Replication_Log - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Replication_LogQuery extends POQuery<MReplicationLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationLog.Table_Name;
	}

	public Connection<MReplicationLog> AD_Replication_LogGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
