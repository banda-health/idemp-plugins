package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.base.model.MProduct_BH;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Product - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ProductQuery extends POQuery<MProduct_BH> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MProduct_BH.Table_Name;
	}

	public CompletableFuture<MProduct_BH> M_Product(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MProduct_BH> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductDataLoader.DATALOADER_M_Product_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MProduct_BH> M_ProductGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
