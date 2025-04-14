package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_OperationResourceDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_OperationResource;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_OperationResource - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_OperationResourceQuery extends POQuery<X_M_OperationResource> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_OperationResource.Table_Name;
	}

	public CompletableFuture<X_M_OperationResource> M_OperationResource(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_OperationResource> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_OperationResourceDataLoader.DATALOADER_M_OperationResource_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_OperationResource> M_OperationResourceGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
