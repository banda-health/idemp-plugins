package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MBHProductCategoryDefault;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_BH_Product_CategoryDefaultDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for BH_Product_CategoryDefault - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_BH_Product_CategoryDefaultQuery extends POQuery<MBHProductCategoryDefault> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MBHProductCategoryDefault.Table_Name;
	}

	public CompletableFuture<MBHProductCategoryDefault> BH_Product_CategoryDefault(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MBHProductCategoryDefault> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_BH_Product_CategoryDefaultDataLoader.DATALOADER_BH_Product_CategoryDefault_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MBHProductCategoryDefault> BH_Product_CategoryDefaultGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
