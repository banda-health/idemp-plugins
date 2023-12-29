package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashPlan;

/**
 * Generated Query Resolver for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_C_CashPlanQuery extends POQuery<MCashPlan> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashPlan.Table_Name;
	}

	public Connection<MCashPlan> C_CashPlanGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
