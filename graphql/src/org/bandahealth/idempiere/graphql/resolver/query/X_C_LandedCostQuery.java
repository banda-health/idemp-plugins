package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_C_LandedCostDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MLandedCost;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for C_LandedCost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 11 - $Id$
 */
public class X_C_LandedCostQuery extends POQuery<MLandedCost> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MLandedCost.Table_Name;
	}

	public CompletableFuture<MLandedCost> C_LandedCost(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MLandedCost> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_C_LandedCostDataLoader.DATALOADER_C_LandedCost_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MLandedCost> C_LandedCostGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
