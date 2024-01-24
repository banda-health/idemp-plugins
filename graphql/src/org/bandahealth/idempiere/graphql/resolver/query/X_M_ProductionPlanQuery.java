package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionPlan;

/**
 * Generated Query Resolver for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 8.2 - $Id$
 */
public class X_M_ProductionPlanQuery extends POQuery<MProductionPlan> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionPlan.Table_Name;
	}

	public Connection<MProductionPlan> M_ProductionPlanGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
