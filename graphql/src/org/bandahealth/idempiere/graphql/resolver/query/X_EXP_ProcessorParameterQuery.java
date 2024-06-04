package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_EXP_ProcessorParameterDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MEXPProcessorParameter;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for EXP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_EXP_ProcessorParameterQuery extends POQuery<MEXPProcessorParameter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MEXPProcessorParameter.Table_Name;
	}

	public CompletableFuture<MEXPProcessorParameter> EXP_ProcessorParameter(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MEXPProcessorParameter> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_EXP_ProcessorParameterDataLoader.DATALOADER_EXP_ProcessorParameter_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MEXPProcessorParameter> EXP_ProcessorParameterGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
