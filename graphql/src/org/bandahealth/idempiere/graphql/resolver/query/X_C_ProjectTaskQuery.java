package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProjectTask;

/**
 * Generated Query Resolver for C_ProjectTask - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_ProjectTaskQuery extends POQuery<MProjectTask> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProjectTask.Table_Name;
	}

	public Connection<MProjectTask> C_ProjectTaskGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
