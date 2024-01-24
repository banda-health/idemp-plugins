package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRevenueRecognitionPlan;

/**
 * Generated Query Resolver for C_RevenueRecognition_Plan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 7.1 - $Id$
 */
public class X_C_RevenueRecognition_PlanQuery extends POQuery<MRevenueRecognitionPlan> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRevenueRecognitionPlan.Table_Name;
	}

	public Connection<MRevenueRecognitionPlan> C_RevenueRecognition_PlanGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
