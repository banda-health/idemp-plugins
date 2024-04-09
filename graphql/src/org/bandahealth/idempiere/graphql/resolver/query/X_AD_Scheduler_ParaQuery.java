package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSchedulerPara;

/**
 * Generated Query Resolver for AD_Scheduler_Para - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_Scheduler_ParaQuery extends POQuery<MSchedulerPara> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSchedulerPara.Table_Name;
	}

	public Connection<MSchedulerPara> AD_Scheduler_ParaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
