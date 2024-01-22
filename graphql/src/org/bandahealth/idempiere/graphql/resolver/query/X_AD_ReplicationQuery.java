package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplication;

/**
 * Generated Query Resolver for AD_Replication - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_ReplicationQuery extends POQuery<MReplication> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplication.Table_Name;
	}

	public Connection<MReplication> AD_ReplicationGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
