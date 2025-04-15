package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_AllocationLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAllocationLine;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_AllocationLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_C_AllocationLineQuery extends POQuery<MAllocationLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAllocationLine.Table_Name;
	}

	public CompletableFuture<MAllocationLine> C_AllocationLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAllocationLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_AllocationLineDataLoader.DATALOADER_C_AllocationLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAllocationLine> C_AllocationLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
