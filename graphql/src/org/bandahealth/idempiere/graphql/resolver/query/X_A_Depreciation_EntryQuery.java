package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_EntryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MDepreciationEntry;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_EntryQuery extends POQuery<MDepreciationEntry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MDepreciationEntry.Table_Name;
	}

	public CompletableFuture<MDepreciationEntry> A_Depreciation_Entry(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MDepreciationEntry> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_EntryDataLoader.DATALOADER_A_Depreciation_Entry_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MDepreciationEntry> A_Depreciation_EntryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
