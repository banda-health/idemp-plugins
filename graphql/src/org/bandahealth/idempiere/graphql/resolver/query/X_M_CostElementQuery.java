package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_M_CostElementDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MCostElement;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for M_CostElement - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_M_CostElementQuery extends POQuery<MCostElement> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MCostElement.Table_Name;
	}

	public CompletableFuture<MCostElement> M_CostElement(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MCostElement> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_M_CostElementDataLoader.DATALOADER_M_CostElement_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MCostElement> M_CostElementGet(int Page, int PageSize, String Sort, String Filter,
			String Where, List<Object> Parameters, DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, Where, Parameters, environment);
	}
}
