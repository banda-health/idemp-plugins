package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_ProcessorDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPProcessor;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for EXP_Processor - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_EXP_ProcessorQuery extends POQuery<MEXPProcessor> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPProcessor.Table_Name;
	}

	public CompletableFuture<MEXPProcessor> EXP_Processor(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MEXPProcessor> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_EXP_ProcessorDataLoader.DATALOADER_EXP_Processor_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MEXPProcessor> EXP_ProcessorGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
