package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ShippingProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MShippingProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ShippingProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ShippingProcessorQuery extends POQuery<MShippingProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MShippingProcessor.Table_Name;
	}

	public CompletableFuture<MShippingProcessor> M_ShippingProcessor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MShippingProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ShippingProcessorDataLoader.DATALOADER_M_ShippingProcessor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MShippingProcessor> M_ShippingProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
