package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperPackagingDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipperPackaging;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ShipperPackaging - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperPackagingQuery extends POQuery<MShipperPackaging> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipperPackaging.Table_Name;
	}

	public CompletableFuture<MShipperPackaging> M_ShipperPackaging(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MShipperPackaging> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShipperPackagingDataLoader.DATALOADER_M_ShipperPackaging_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MShipperPackaging> M_ShipperPackagingGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
