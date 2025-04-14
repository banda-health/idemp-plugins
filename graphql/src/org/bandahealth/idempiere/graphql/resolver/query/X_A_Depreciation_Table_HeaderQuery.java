package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_Table_HeaderDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Depreciation_Table_Header;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Table_Header - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Depreciation_Table_HeaderQuery extends POQuery<X_A_Depreciation_Table_Header> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Header.Table_Name;
	}

	public CompletableFuture<X_A_Depreciation_Table_Header> A_Depreciation_Table_Header(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Depreciation_Table_Header> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_Table_HeaderDataLoader.DATALOADER_A_Depreciation_Table_Header_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Depreciation_Table_Header> A_Depreciation_Table_HeaderGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
