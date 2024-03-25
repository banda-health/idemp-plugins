package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAchievement;

/**
 * Generated Query Resolver for PA_Achievement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PA_AchievementQuery extends POQuery<MAchievement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAchievement.Table_Name;
	}

	public Connection<MAchievement> PA_AchievementGet(int page, int pageSize, String sort, String filter,
			DataFetchingEnvironment environment) {
		return super.get(page, pageSize, sort, filter, environment);
	}
}
