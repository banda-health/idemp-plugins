package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductionPlanDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MProductionPlan;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductionPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ProductionPlanQuery extends POQuery<MProductionPlan> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductionPlan.Table_Name;
	}

	public CompletableFuture<MProductionPlan> M_ProductionPlan(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductionPlan> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductionPlanDataLoader.DATALOADER_M_ProductionPlan_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductionPlan> M_ProductionPlanGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
