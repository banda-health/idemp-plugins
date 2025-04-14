package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_GoalRestrictionDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGoalRestriction;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_GoalRestriction - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_GoalRestrictionQuery extends POQuery<MGoalRestriction> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGoalRestriction.Table_Name;
	}

	public CompletableFuture<MGoalRestriction> PA_GoalRestriction(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MGoalRestriction> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_GoalRestrictionDataLoader.DATALOADER_PA_GoalRestriction_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MGoalRestriction> PA_GoalRestrictionGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
