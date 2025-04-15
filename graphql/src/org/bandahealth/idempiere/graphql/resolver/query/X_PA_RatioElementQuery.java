package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_RatioElementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.X_PA_RatioElement;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_RatioElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_RatioElementQuery extends POQuery<X_PA_RatioElement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_PA_RatioElement.Table_Name;
	}

	public CompletableFuture<X_PA_RatioElement> PA_RatioElement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_PA_RatioElement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_RatioElementDataLoader.DATALOADER_PA_RatioElement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_PA_RatioElement> PA_RatioElementGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
