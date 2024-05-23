package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_CashPlanLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCashPlanLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_CashPlanLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_CashPlanLineQuery extends POQuery<MCashPlanLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCashPlanLine.Table_Name;
	}

	public CompletableFuture<MCashPlanLine> C_CashPlanLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCashPlanLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_CashPlanLineDataLoader.DATALOADER_C_CashPlanLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCashPlanLine> C_CashPlanLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
