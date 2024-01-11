package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedulerPara;

/**
 * Generated Query Resolver for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_AD_Scheduler_ParaQuery extends POQuery<MSchedulerPara> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedulerPara.Table_Name;
	}

	public Connection<MSchedulerPara> AD_Scheduler_ParaGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
