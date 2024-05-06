package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGoalRestriction;

/**
 * Generated Query Resolver for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_GoalRestrictionQuery extends POQuery<MGoalRestriction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGoalRestriction.Table_Name;
	}

	public Connection<MGoalRestriction> PA_GoalRestrictionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
