package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedulerLog;

/**
 * Generated Query Resolver for AD_SchedulerLog - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_AD_SchedulerLogQuery extends POQuery<MSchedulerLog> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedulerLog.Table_Name;
	}

	public Connection<MSchedulerLog> AD_SchedulerLogGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
