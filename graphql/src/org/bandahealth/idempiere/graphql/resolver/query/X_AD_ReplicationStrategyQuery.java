package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MReplicationStrategy;

/**
 * Generated Query Resolver for AD_ReplicationStrategy - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_ReplicationStrategyQuery extends POQuery<MReplicationStrategy> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MReplicationStrategy.Table_Name;
	}

	public Connection<MReplicationStrategy> AD_ReplicationStrategyGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
