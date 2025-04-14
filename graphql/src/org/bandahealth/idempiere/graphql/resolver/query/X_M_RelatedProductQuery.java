package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_RelatedProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_RelatedProduct;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_RelatedProduct - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_RelatedProductQuery extends POQuery<X_M_RelatedProduct> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_RelatedProduct.Table_Name;
	}

	public CompletableFuture<X_M_RelatedProduct> M_RelatedProduct(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_RelatedProduct> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_RelatedProductDataLoader.DATALOADER_M_RelatedProduct_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_RelatedProduct> M_RelatedProductGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
