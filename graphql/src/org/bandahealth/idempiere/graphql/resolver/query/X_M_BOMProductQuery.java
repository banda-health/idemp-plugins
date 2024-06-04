package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_BOMProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MBOMProduct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_BOMProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_BOMProductQuery extends POQuery<MBOMProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBOMProduct.Table_Name;
	}

	public CompletableFuture<MBOMProduct> M_BOMProduct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBOMProduct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_BOMProductDataLoader.DATALOADER_M_BOMProduct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBOMProduct> M_BOMProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
