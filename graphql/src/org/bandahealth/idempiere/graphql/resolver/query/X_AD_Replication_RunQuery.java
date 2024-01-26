package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MReplicationRun_BH;
import org.bandahealth.idempiere.graphql.model.Connection;

/**
 * Generated Query Resolver for AD_Replication_Run - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Replication_RunQuery extends POQuery<MReplicationRun_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationRun_BH.Table_Name;
	}

	public Connection<MReplicationRun_BH> AD_Replication_RunGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
