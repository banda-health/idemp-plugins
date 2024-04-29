package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplicationRun;

/**
 * Generated Query Resolver for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Replication_RunQuery extends POQuery<MReplicationRun> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationRun.Table_Name;
	}

	public Connection<MReplicationRun> AD_Replication_RunGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
