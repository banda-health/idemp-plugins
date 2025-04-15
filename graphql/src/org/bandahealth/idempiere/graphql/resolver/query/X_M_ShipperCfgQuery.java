package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperCfgDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_ShipperCfg;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ShipperCfg - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_ShipperCfgQuery extends POQuery<X_M_ShipperCfg> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_ShipperCfg.Table_Name;
	}

	public CompletableFuture<X_M_ShipperCfg> M_ShipperCfg(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_ShipperCfg> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShipperCfgDataLoader.DATALOADER_M_ShipperCfg_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_ShipperCfg> M_ShipperCfgGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
