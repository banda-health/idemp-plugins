package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_AchievementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAchievement;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

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

	public CompletableFuture<MAchievement> PA_Achievement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAchievement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_AchievementDataLoader.DATALOADER_PA_Achievement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAchievement> PA_AchievementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
