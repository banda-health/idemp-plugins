package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShipperDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShipper;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Shipper - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShipperQuery extends POQuery<MShipper> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShipper.Table_Name;
	}

	public CompletableFuture<MShipper> M_Shipper(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MShipper> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShipperDataLoader.DATALOADER_M_Shipper_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MShipper> M_ShipperGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
