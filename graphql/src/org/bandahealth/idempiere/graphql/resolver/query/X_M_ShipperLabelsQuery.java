package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperLabelsDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipperLabels;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ShipperLabels - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_M_ShipperLabelsQuery extends POQuery<MShipperLabels> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipperLabels.Table_Name;
	}

	public CompletableFuture<MShipperLabels> M_ShipperLabels(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MShipperLabels> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShipperLabelsDataLoader.DATALOADER_M_ShipperLabels_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MShipperLabels> M_ShipperLabelsGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
