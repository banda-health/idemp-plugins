package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MScheduler;

/**
 * Generated Query Resolver for AD_Scheduler - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_SchedulerQuery extends POQuery<MScheduler> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MScheduler.Table_Name;
	}

	public Connection<MScheduler> AD_SchedulerGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
