package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_GoalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MGoal;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PA_GoalQuery extends POQuery<MGoal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MGoal.Table_Name;
	}

	public CompletableFuture<MGoal> PA_Goal(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MGoal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_GoalDataLoader.DATALOADER_PA_Goal_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MGoal> PA_GoalGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
