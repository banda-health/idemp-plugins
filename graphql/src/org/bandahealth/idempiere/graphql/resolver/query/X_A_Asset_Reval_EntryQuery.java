package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_Reval_EntryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Asset_Reval_Entry;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Reval_Entry - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Asset_Reval_EntryQuery extends POQuery<X_A_Asset_Reval_Entry> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Asset_Reval_Entry.Table_Name;
	}

	public CompletableFuture<X_A_Asset_Reval_Entry> A_Asset_Reval_Entry(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Asset_Reval_Entry> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_Reval_EntryDataLoader.DATALOADER_A_Asset_Reval_Entry_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Asset_Reval_Entry> A_Asset_Reval_EntryGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
