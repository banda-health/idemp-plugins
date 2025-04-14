package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductPriceVendorBreakDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_ProductPriceVendorBreak;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductPriceVendorBreak - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ProductPriceVendorBreakQuery extends POQuery<X_M_ProductPriceVendorBreak> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductPriceVendorBreak.Table_Name;
	}

	public CompletableFuture<X_M_ProductPriceVendorBreak> M_ProductPriceVendorBreak(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_ProductPriceVendorBreak> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductPriceVendorBreakDataLoader.DATALOADER_M_ProductPriceVendorBreak_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_ProductPriceVendorBreak> M_ProductPriceVendorBreakGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
