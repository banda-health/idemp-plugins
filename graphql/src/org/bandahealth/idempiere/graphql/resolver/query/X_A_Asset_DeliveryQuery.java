package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_A_Asset_DeliveryDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAssetDelivery;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for A_Asset_Delivery - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_A_Asset_DeliveryQuery extends POQuery<MAssetDelivery> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAssetDelivery.Table_Name;
	}

	public CompletableFuture<MAssetDelivery> A_Asset_Delivery(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAssetDelivery> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_A_Asset_DeliveryDataLoader.DATALOADER_A_Asset_Delivery_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAssetDelivery> A_Asset_DeliveryGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
