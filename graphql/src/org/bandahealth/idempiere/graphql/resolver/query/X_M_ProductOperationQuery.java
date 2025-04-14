package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_ProductOperationDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_M_ProductOperation;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_ProductOperation - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 13 - $Id$
 */
public class X_M_ProductOperationQuery extends POQuery<X_M_ProductOperation> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_M_ProductOperation.Table_Name;
	}

	public CompletableFuture<X_M_ProductOperation> M_ProductOperation(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_M_ProductOperation> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_ProductOperationDataLoader.DATALOADER_M_ProductOperation_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_M_ProductOperation> M_ProductOperationGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
