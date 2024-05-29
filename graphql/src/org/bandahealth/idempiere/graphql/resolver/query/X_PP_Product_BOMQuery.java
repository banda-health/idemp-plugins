package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOM;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Product_BOM - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_PP_Product_BOMQuery extends POQuery<MPPProductBOM> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPPProductBOM.Table_Name;
	}

	public CompletableFuture<MPPProductBOM> PP_Product_BOM(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPPProductBOM> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Product_BOMDataLoader.DATALOADER_PP_Product_BOM_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPPProductBOM> PP_Product_BOMGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
