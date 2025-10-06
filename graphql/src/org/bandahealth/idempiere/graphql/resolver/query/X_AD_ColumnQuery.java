package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_ColumnDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MColumn;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Column - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_ColumnQuery extends POQuery<MColumn> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MColumn.Table_Name;
	}

	public CompletableFuture<MColumn> AD_Column(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MColumn> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_ColumnDataLoader.DATALOADER_AD_Column_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MColumn> AD_ColumnGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
