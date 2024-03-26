package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_SLA_Goal;

/**
 * Generated Query Resolver for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_SLA_GoalQuery extends POQuery<X_PA_SLA_Goal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_SLA_Goal.Table_Name;
	}

	public Connection<X_PA_SLA_Goal> PA_SLA_GoalGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
