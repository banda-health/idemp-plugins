package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PP_Product_BOMLineDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.MPPProductBOMLine;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PP_Product_BOMLine - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_PP_Product_BOMLineQuery extends POQuery<MPPProductBOMLine> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MPPProductBOMLine.Table_Name;
	}

	public CompletableFuture<MPPProductBOMLine> PP_Product_BOMLine(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MPPProductBOMLine> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PP_Product_BOMLineDataLoader.DATALOADER_PP_Product_BOMLine_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MPPProductBOMLine> PP_Product_BOMLineGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
