package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_I_ProductPlanningDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.dataloader.DataLoader;
import org.eevolution.model.X_I_ProductPlanning;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for I_ProductPlanning - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_I_ProductPlanningQuery extends POQuery<X_I_ProductPlanning> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return X_I_ProductPlanning.Table_Name;
	}

	public CompletableFuture<X_I_ProductPlanning> I_ProductPlanning(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, X_I_ProductPlanning> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_I_ProductPlanningDataLoader.DATALOADER_I_ProductPlanning_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<X_I_ProductPlanning> I_ProductPlanningGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
