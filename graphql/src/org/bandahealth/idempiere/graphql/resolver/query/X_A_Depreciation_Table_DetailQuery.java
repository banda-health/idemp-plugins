package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Depreciation_Table_DetailDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_A_Depreciation_Table_Detail;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Depreciation_Table_Detail - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_A_Depreciation_Table_DetailQuery extends POQuery<X_A_Depreciation_Table_Detail> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_A_Depreciation_Table_Detail.Table_Name;
	}

	public CompletableFuture<X_A_Depreciation_Table_Detail> A_Depreciation_Table_Detail(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_A_Depreciation_Table_Detail> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Depreciation_Table_DetailDataLoader.DATALOADER_A_Depreciation_Table_Detail_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_A_Depreciation_Table_Detail> A_Depreciation_Table_DetailGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
