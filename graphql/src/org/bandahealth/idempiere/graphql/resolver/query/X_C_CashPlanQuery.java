package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashPlanDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashPlan;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CashPlan - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_CashPlanQuery extends POQuery<MCashPlan> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashPlan.Table_Name;
	}

	public CompletableFuture<MCashPlan> C_CashPlan(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCashPlan> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CashPlanDataLoader.DATALOADER_C_CashPlan_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCashPlan> C_CashPlanGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
