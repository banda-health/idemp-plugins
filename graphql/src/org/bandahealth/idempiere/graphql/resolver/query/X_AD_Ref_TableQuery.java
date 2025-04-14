package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_Ref_TableDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRefTable;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_Ref_Table - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_AD_Ref_TableQuery extends POQuery<MRefTable> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRefTable.Table_Name;
	}

	public CompletableFuture<MRefTable> AD_Ref_Table(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRefTable> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_Ref_TableDataLoader.DATALOADER_AD_Ref_Table_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRefTable> AD_Ref_TableGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
