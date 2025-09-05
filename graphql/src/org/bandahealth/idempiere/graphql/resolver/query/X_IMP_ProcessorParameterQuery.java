package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_IMP_ProcessorParameterDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_IMP_ProcessorParameter;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for IMP_ProcessorParameter - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_IMP_ProcessorParameterQuery extends POQuery<X_IMP_ProcessorParameter> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_IMP_ProcessorParameter.Table_Name;
	}

	public CompletableFuture<X_IMP_ProcessorParameter> IMP_ProcessorParameter(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_IMP_ProcessorParameter> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_IMP_ProcessorParameterDataLoader.DATALOADER_IMP_ProcessorParameter_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_IMP_ProcessorParameter> IMP_ProcessorParameterGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
