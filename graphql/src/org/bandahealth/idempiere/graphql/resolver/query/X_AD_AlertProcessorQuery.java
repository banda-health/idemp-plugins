package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_AD_AlertProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MAlertProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for AD_AlertProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_AD_AlertProcessorQuery extends POQuery<MAlertProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MAlertProcessor.Table_Name;
	}

	public CompletableFuture<MAlertProcessor> AD_AlertProcessor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MAlertProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_AD_AlertProcessorDataLoader.DATALOADER_AD_AlertProcessor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MAlertProcessor> AD_AlertProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
