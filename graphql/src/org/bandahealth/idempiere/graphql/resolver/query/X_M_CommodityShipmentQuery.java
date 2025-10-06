package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CommodityShipmentDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_CommodityShipment;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_CommodityShipment - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_CommodityShipmentQuery extends POQuery<X_M_CommodityShipment> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_CommodityShipment.Table_Name;
	}

	public CompletableFuture<X_M_CommodityShipment> M_CommodityShipment(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_CommodityShipment> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CommodityShipmentDataLoader.DATALOADER_M_CommodityShipment_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_CommodityShipment> M_CommodityShipmentGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
