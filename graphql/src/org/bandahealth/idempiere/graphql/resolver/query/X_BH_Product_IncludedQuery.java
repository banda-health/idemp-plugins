package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHProductIncluded;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Product_IncludedDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Product_Included - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_BH_Product_IncludedQuery extends POQuery<MBHProductIncluded> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHProductIncluded.Table_Name;
	}

	public CompletableFuture<MBHProductIncluded> BH_Product_Included(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHProductIncluded> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Product_IncludedDataLoader.DATALOADER_BH_Product_Included_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHProductIncluded> BH_Product_IncludedGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
