package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCost;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_Cost - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_CostQuery extends POQuery<MCost> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCost.Table_Name;
	}

	public CompletableFuture<MCost> M_Cost(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCost> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CostDataLoader.DATALOADER_M_Cost_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCost> M_CostGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
