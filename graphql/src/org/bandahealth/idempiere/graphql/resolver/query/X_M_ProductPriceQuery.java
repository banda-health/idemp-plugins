package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductPrice_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductPriceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductPrice - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ProductPriceQuery extends POQuery<MProductPrice_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductPrice_BH.Table_Name;
	}

	public CompletableFuture<MProductPrice_BH> M_ProductPrice(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductPrice_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductPriceDataLoader.DATALOADER_M_ProductPrice_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductPrice_BH> M_ProductPriceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
