package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_ProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetProduct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_ProductQuery extends POQuery<MAssetProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetProduct.Table_Name;
	}

	public CompletableFuture<MAssetProduct> A_Asset_Product(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetProduct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_ProductDataLoader.DATALOADER_A_Asset_Product_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetProduct> A_Asset_ProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
