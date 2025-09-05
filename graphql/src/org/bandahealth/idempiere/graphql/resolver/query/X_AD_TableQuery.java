package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_TableDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MTable;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_TableQuery extends POQuery<MTable> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MTable.Table_Name;
	}

	public CompletableFuture<MTable> AD_Table(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MTable> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_TableDataLoader.DATALOADER_AD_Table_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MTable> AD_TableGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
