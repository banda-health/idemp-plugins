package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectTypeTask;

/**
 * Generated Query Resolver for C_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_TaskQuery extends POQuery<MProjectTypeTask> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectTypeTask.Table_Name;
	}

	public Connection<MProjectTypeTask> C_TaskGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
