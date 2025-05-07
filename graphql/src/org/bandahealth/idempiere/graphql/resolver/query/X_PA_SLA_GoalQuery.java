package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_GoalDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSLAGoal;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_SLA_Goal - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_GoalQuery extends POQuery<MSLAGoal> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSLAGoal.Table_Name;
	}

	public CompletableFuture<MSLAGoal> PA_SLA_Goal(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSLAGoal> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_SLA_GoalDataLoader.DATALOADER_PA_SLA_Goal_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSLAGoal> PA_SLA_GoalGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
