package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_R_RequestProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MRequestProcessor;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for R_RequestProcessor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_R_RequestProcessorQuery extends POQuery<MRequestProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MRequestProcessor.Table_Name;
	}

	public CompletableFuture<MRequestProcessor> R_RequestProcessor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MRequestProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_R_RequestProcessorDataLoader.DATALOADER_R_RequestProcessor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MRequestProcessor> R_RequestProcessorGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
