package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTask;

/**
 * Generated Query Resolver for AD_Task - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_AD_TaskQuery extends POQuery<MTask> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTask.Table_Name;
	}

	public Connection<MTask> AD_TaskGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
