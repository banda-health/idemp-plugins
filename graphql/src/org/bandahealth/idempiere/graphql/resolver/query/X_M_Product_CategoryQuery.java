package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProductCategory_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_Product_CategoryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Product_Category - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_Product_CategoryQuery extends POQuery<MProductCategory_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProductCategory_BH.Table_Name;
	}

	public CompletableFuture<MProductCategory_BH> M_Product_Category(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProductCategory_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_Product_CategoryDataLoader.DATALOADER_M_Product_Category_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProductCategory_BH> M_Product_CategoryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
