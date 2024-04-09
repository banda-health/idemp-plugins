package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionPlan;

/**
 * Generated Query Resolver for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ProductionPlanQuery extends POQuery<MProductionPlan> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionPlan.Table_Name;
	}

	public Connection<MProductionPlan> M_ProductionPlanGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
