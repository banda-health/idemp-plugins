package org.bandahealth.idempiere.graphql.resolver.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import org.bandahealth.idempiere.graphql.dataloader.impl.X_PA_SLA_CriteriaDataLoader;
import org.bandahealth.idempiere.graphql.model.Connection;
import org.compiere.model.MSLACriteria;
import org.dataloader.DataLoader;

import java.util.concurrent.CompletableFuture;

/**
 * Generated Query Resolver for PA_SLA_Criteria - DO NOT CHANGE
 *
 * @author Banda Health (generated)
 * @version Release 12 - $Id$
 */
public class X_PA_SLA_CriteriaQuery extends POQuery<MSLACriteria> implements GraphQLQueryResolver {
	@Override
	protected String getTableName() {
		return MSLACriteria.Table_Name;
	}

	public CompletableFuture<MSLACriteria> PA_SLA_Criteria(String UU, DataFetchingEnvironment environment) {
		DataLoader<String, MSLACriteria> dataLoader = environment.getDataLoaderRegistry()
				.getDataLoader(X_PA_SLA_CriteriaDataLoader.DATALOADER_PA_SLA_Criteria_BY_UUID);
		return dataLoader.load(UU);
	}

	public Connection<MSLACriteria> PA_SLA_CriteriaGet(int Page, int PageSize, String Sort, String Filter,
			DataFetchingEnvironment environment) {
		return super.Get(Page, PageSize, Sort, Filter, environment);
	}
}
